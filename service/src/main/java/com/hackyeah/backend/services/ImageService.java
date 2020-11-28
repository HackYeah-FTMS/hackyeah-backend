package com.hackyeah.backend.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Service
public class ImageService {

    @Value("${imageLocation}")
    private String imagesLocation;

    public String saveImage(MultipartFile file, String imagePrefix) {
        try {
            final String imageName = imagePrefix + file.getOriginalFilename();
            final Path source = Paths.get(getResourcesFile() + "/images/" + imageName);
            final File imagesDirectory = new File(getResourcesFile() + "/images/");
            if (!imagesDirectory.exists()) {
                imagesDirectory.mkdirs();
            }
            final byte[] imageBytes = file.getBytes();
            final String filePath = imagesLocation + "/" + imagePrefix + file.getOriginalFilename();
            Files.write(source, imageBytes);
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private Path getResourcesFile() {
        return new File(this.getClass().getResource("/").getFile()).toPath().toAbsolutePath();
    }

    public byte[] getImage(String name) {
        try {
            final Path source = Paths.get(getResourcesFile() + "/images/" + name);
            Path path = Paths.get(source.toUri());
            return Files.readAllBytes(path);
        } catch (NoSuchFileException exception) {
            log.warn("File not found: {}", name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
