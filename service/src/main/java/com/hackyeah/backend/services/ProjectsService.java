package com.hackyeah.backend.services;

import com.hackyeah.backend.entities.Project;
import com.hackyeah.backend.entities.Tag;
import com.hackyeah.backend.entities.User;
import com.hackyeah.backend.repositories.ProjectsRepository;
import com.hackyeah.backend.repositories.UserRepository;
import com.hackyeah.model.CreateProjectRequest;
import com.hackyeah.model.ProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProjectsService {
    private final ProjectsRepository projectsRepository;
    private final UserRepository userRepository;
    private final TagsService tagsService;

    public List<ProjectDto> getAllProjects() {
        final List<Project> projects = projectsRepository.findAll();
        return mapToProjectDto(projects);
    }

    private List<ProjectDto> mapToProjectDto(List<Project> projects) {
        return projects.stream()
                .map(this::toProjectDto)
                .sorted(Comparator.comparing(ProjectDto::getCreationTimestamp).reversed())
                .collect(Collectors.toList());
    }

    private ProjectDto toProjectDto(Project project) {
        return new ProjectDto()
                .id(project.getId())
                .ownerId(project.getUser().getId())
                .title(project.getTitle())
                .ideaImage(project.getIdeaImage())
                .solutionImage(project.getSolutionImage())
                .description(project.getDescription())
                .tags(project.getTags().stream().map(Tag::getName).collect(Collectors.toList()))
                .points(project.getPoints())
                .creationTimestamp(project.getCreationTimestamp());
    }

    @Transactional
    public ResponseEntity<Void> createProject(Integer userId, CreateProjectRequest createProjectRequest) {
        final Project project = new Project();
        final User user = userRepository.findById(Long.valueOf(userId))
                .orElseThrow(() -> new RuntimeException("User does not exist"));
        project.setUser(user);
        project.setTags(tagsService.fetchTags(createProjectRequest.getTags()));

        project.setTitle(createProjectRequest.getTitle());
        project.setDescription(createProjectRequest.getDescription());
        project.setIdeaImage(createProjectRequest.getIdeaImage());
        project.setSolutionImage(createProjectRequest.getSolutionImage());
        project.setCreationTimestamp(Timestamp.valueOf(LocalDateTime.now()).getTime());
        project.setPoints(0);

        projectsRepository.save(project);

        return ResponseEntity.noContent().build();
    }
}
