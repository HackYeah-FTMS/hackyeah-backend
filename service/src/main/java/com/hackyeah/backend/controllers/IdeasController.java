package com.hackyeah.backend.controllers;

import com.hackyeah.api.IdeasApi;
import com.hackyeah.backend.services.IdeasService;
import com.hackyeah.model.CreateCommentRequest;
import com.hackyeah.model.CreateIdeaRequest;
import com.hackyeah.model.IdeaDetailsDto;
import com.hackyeah.model.IdeaDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class IdeasController implements IdeasApi {
    private final IdeasService ideasService;

    @Override
    public ResponseEntity<List<IdeaDto>> getIdeas() {
        log.info("GET /ideas request");
        return ResponseEntity.ok(ideasService.getAllIdeas());
    }

    @Override
    public ResponseEntity<IdeaDetailsDto> getIdeaDetails(Long ideaId) {
        log.info("GET /ideas/{} request", ideaId);
        return ResponseEntity.ok(ideasService.getIdeaDetails(ideaId));
    }

    @Override
    public ResponseEntity<Void> addCommentForIdea(Long userId,
                                                  Long ideaId,
                                                  @Valid CreateCommentRequest createCommentRequest) {
        log.info("POST /ideas/{}/comments request", ideaId);
        ideasService.addComment(userId, ideaId, createCommentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<Void> addIdea(Long userId, @Valid CreateIdeaRequest createIdeaRequest) {
        log.info("POST /ideas request");
        ideasService.createIdea(userId, createIdeaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
