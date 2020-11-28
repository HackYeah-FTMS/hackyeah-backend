package com.hackyeah.backend.controllers;

import com.hackyeah.api.ImagesApi;
import com.hackyeah.backend.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ImagesController implements ImagesApi {

    private final ImageService imageService;

    @Override
    public ResponseEntity<byte[]> getImage(String imageName) {
        HttpHeaders headers = new HttpHeaders();
        final byte[] image = imageService.getImage(imageName);
        if (image != null) {
            headers.setContentType(MediaType.IMAGE_JPEG);
            headers.setContentLength(image.length);
            headers.setCacheControl(CacheControl.noCache().getHeaderValue());
            return new ResponseEntity<>(image, headers, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
}
