package com.hackyeah.backend.services;

import com.hackyeah.backend.entities.Project;
import com.hackyeah.backend.entities.Tag;
import com.hackyeah.backend.repositories.ProjectsRepository;
import com.hackyeah.model.ProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProjectsService {
    private final ProjectsRepository projectsRepository;

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
}
