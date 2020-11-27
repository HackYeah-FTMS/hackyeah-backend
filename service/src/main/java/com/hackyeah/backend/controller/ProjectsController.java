package com.hackyeah.backend.controller;

import com.hackyeah.api.ProjectsApi;
import com.hackyeah.model.ProjectDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
public class ProjectsController implements ProjectsApi {

    @Override
    public ResponseEntity<List<ProjectDto>> getProjects() {
        final ProjectDto projectDto = new ProjectDto()
                .id(1L)
                .title("Test")
                .ideaImage("https://n-22-5.dcs.redcdn.pl/file/o2/redefine/cp/xj/xj1gx9v9k1kzz4x37wcagdhi6r4ckrwo.jpg")
                .solutionImage("https://www.glebokaswiadomosc.pl/wp-content/uploads/2019/10/ekologiczne-konfetti.jpg")
                .description("This is description")
                .tags(List.of("liść"))
                .points(4)
                .creationDate(OffsetDateTime.now());
        return ResponseEntity.ok(List.of(projectDto));
    }
}
