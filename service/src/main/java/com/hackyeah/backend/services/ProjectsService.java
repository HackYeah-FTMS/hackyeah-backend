package com.hackyeah.backend.services;

import com.hackyeah.backend.entities.Project;
import com.hackyeah.backend.repositories.ProjectsRepository;
import com.hackyeah.model.ProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjectsService {
    private final ProjectsRepository projectsRepository;

    public List<ProjectDto> getAllProjects() {
        final List<Project> projects = projectsRepository.findAll();
        return mapToProjectDto(projects);
    }

    private List<ProjectDto> mapToProjectDto(List<Project> projects) {
        return List.of(
                new ProjectDto()
                        .id(1L)
                        .title("Test")
                        .ideaImage("https://n-22-5.dcs.redcdn.pl/file/o2/redefine/cp/xj/xj1gx9v9k1kzz4x37wcagdhi6r4ckrwo.jpg")
                        .solutionImage("https://www.glebokaswiadomosc.pl/wp-content/uploads/2019/10/ekologiczne-konfetti.jpg")
                        .description("This is description")
                        .tags(List.of("liść"))
                        .points(4)
                        .creationTimestamp(new Timestamp(System.currentTimeMillis()).getTime())
        );
    }
}
