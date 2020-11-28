package com.hackyeah.backend.services;

import com.hackyeah.backend.entities.Comment;
import com.hackyeah.backend.entities.Idea;
import com.hackyeah.backend.entities.Tag;
import com.hackyeah.backend.entities.User;
import com.hackyeah.backend.repositories.IdeasRepository;
import com.hackyeah.backend.repositories.UserRepository;
import com.hackyeah.model.CommentDto;
import com.hackyeah.model.CreateCommentRequest;
import com.hackyeah.model.CreateIdeaRequest;
import com.hackyeah.model.IdeaDetailsDto;
import com.hackyeah.model.IdeaDto;
import com.hackyeah.model.OwnerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class IdeasService {

    private final IdeasRepository ideasRepository;
    private final UserRepository userRepository;
    private final CommentsService commentsService;
    private final TagsService tagsService;

    public List<IdeaDto> getAllIdeas() {
        return ideasRepository.findAll().stream()
                .map(this::toIdeaDto)
                .collect(Collectors.toList());
    }

    public IdeaDetailsDto getIdeaDetails(Long ideaId) {
        return ideasRepository.findById(ideaId)
                .map(this::toIdeaDetailsDto)
                .orElseThrow(() -> new RuntimeException("Idea with id " + ideaId + " not found"));
    }

    private IdeaDetailsDto toIdeaDetailsDto(Idea idea) {
        return new IdeaDetailsDto()
                .id(idea.getId())
                .owner(toOwner(idea.getUser()))
                .additionalInfo(idea.getAdditionalInfo())
                .comments(toCommentsDto(idea.getComments()))
                .tags(toTags(idea.getTags()))
                .points(idea.getPoints())
                .creationTimestamp(idea.getCreationTimestamp());
    }

    private List<String> toTags(Set<Tag> tags) {
        return tags.stream()
                .map(Tag::getName)
                .collect(Collectors.toList());
    }

    private List<CommentDto> toCommentsDto(List<Comment> comments) {
        return comments.stream()
                .map(this::toCommentDto)
                .collect(Collectors.toList());
    }

    private CommentDto toCommentDto(Comment comment) {
        final CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setOwner(toOwner(comment.getUser()));
        commentDto.setContent(comment.getContent());
        commentDto.setImage(comment.getImage());
        return commentDto;
    }

    private OwnerDto toOwner(User user) {
        return new OwnerDto()
                .id(user.getId())
                .username(user.getUsername());
    }

    private IdeaDto toIdeaDto(Idea idea) {
        return new IdeaDto()
                .id(idea.getId())
                .additionalInfo(idea.getAdditionalInfo())
                .points(idea.getPoints())
                .creationTimestamp(idea.getCreationTimestamp());
    }

    public void addComment(Long userId, Long ideaId, CreateCommentRequest createCommentRequest) {
        final User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User with id " + userId + " not found"));
        final Comment comment = commentsService.createComment(
                user,
                createCommentRequest.getContent(),
                createCommentRequest.getImage()
        );
        final Idea idea = ideasRepository.findById(ideaId)
                .orElseThrow(() -> new RuntimeException("Idea with id " + ideaId + " not found"));
        idea.getComments().add(comment);
        ideasRepository.save(idea);
    }

    public void createIdea(Long userId, CreateIdeaRequest createIdeaRequest) {
        final User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User with id " + userId + " not found"));
        final Idea idea = new Idea();
        idea.setAdditionalInfo(createIdeaRequest.getAdditionalInfo());
        idea.setImage(createIdeaRequest.getImage());
        idea.setTags(tagsService.fetchTags(createIdeaRequest.getTags()));
        idea.setUser(user);
        idea.setPoints(0);
        idea.setCreationTimestamp(1605145954709L);

        ideasRepository.save(idea);
    }
}
