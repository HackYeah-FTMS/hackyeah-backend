package com.hackyeah.backend.services;

import com.hackyeah.backend.entities.Comment;
import com.hackyeah.backend.entities.User;
import com.hackyeah.backend.repositories.CommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentsService {
    private final CommentsRepository commentsRepository;

    public Comment createComment(User user, String content, String image) {
        final Comment comment = new Comment();
        comment.setUser(user);
        comment.setContent(content);
        comment.setImage(image);
        return commentsRepository.save(comment);
    }
}
