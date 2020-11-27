package com.hackyeah.backend.controllers;

import com.hackyeah.api.ProjectsApi;
import com.hackyeah.model.ProjectDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.List;

@Slf4j
@RestController
public class ProjectsController implements ProjectsApi {

    @Override
    public ResponseEntity<List<ProjectDto>> getProjects() {
        log.info("GET /projects request");
        final ProjectDto projectDto = new ProjectDto()
                .id(1L)
                .title("Test")
                .ideaImage("https://n-22-5.dcs.redcdn.pl/file/o2/redefine/cp/xj/xj1gx9v9k1kzz4x37wcagdhi6r4ckrwo.jpg")
                .solutionImage("https://www.glebokaswiadomosc.pl/wp-content/uploads/2019/10/ekologiczne-konfetti.jpg")
                .description("This is description")
                .tags(List.of("liść"))
                .points(4)
                .creationTimestamp(new Timestamp(System.currentTimeMillis()).getTime());
        return ResponseEntity.ok(List.of(projectDto));
    }
}
