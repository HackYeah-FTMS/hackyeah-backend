package com.hackyeah.backend.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackyeah.api.ProjectsApi;
import com.hackyeah.backend.services.ProjectsService;
import com.hackyeah.model.CreateProjectRequest;
import com.hackyeah.model.ProjectDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
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

    @Override
    public ResponseEntity<Void> addProject(Long userId,
                                           String data,
                                           @Valid MultipartFile ideaImage,
                                           @Valid MultipartFile solutionImage) {
        log.info("POST /projects request with data: {} and userId: {}", data, userId);
        CreateProjectRequest createProjectRequest = toCreateProjectRequest(data);
        if (createProjectRequest == null) {
            log.error("createProjectRequest null");
            final String withoutBrackets = data.substring(1).substring(0, data.length() - 2).replace("\\", "");
            log.info("Retry convert data to request: {}", withoutBrackets);
            createProjectRequest = toCreateProjectRequest(withoutBrackets);
            if (createProjectRequest == null) {
                return ResponseEntity.badRequest().build();
            }
        } else {
            log.info(createProjectRequest.toString());
        }
        projectsService.createProject(userId, createProjectRequest, ideaImage, solutionImage);
        return ResponseEntity.noContent().build();
    }

    private CreateProjectRequest toCreateProjectRequest(String data) {
        try {
            return new ObjectMapper().readValue(data, CreateProjectRequest.class);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            log.error(e.getOriginalMessage());
            return null;
        }
    }
}
