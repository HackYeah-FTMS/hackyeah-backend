package com.hackyeah.backend.controllers;

import com.hackyeah.api.ProjectsApi;
import com.hackyeah.backend.services.ProjectsService;
import com.hackyeah.model.ProjectDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ProjectsController implements ProjectsApi {

    private final ProjectsService projectsService;

    @Override
    public ResponseEntity<List<ProjectDto>> getProjects() {
        log.info("GET /projects request");
        return ResponseEntity.ok(projectsService.getAllProjects());
    }
}
