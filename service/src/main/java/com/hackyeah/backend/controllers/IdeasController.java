package com.hackyeah.backend.controllers;

import com.hackyeah.api.IdeasApi;
import com.hackyeah.backend.services.IdeasService;
import com.hackyeah.model.IdeaDetailsDto;
import com.hackyeah.model.IdeaDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class IdeasController implements IdeasApi {
    private final IdeasService ideasService;

    @Override
    public ResponseEntity<List<IdeaDto>> getIdeas() {
        return ResponseEntity.ok(ideasService.getAllIdeas());
    }

    @Override
    public ResponseEntity<IdeaDetailsDto> getIdeaDetails(Integer ideaId) {
        return ResponseEntity.ok(ideasService.getIdeaDetails(ideaId));
    }
}
