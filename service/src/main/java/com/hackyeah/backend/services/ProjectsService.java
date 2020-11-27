package com.hackyeah.backend.services;

import com.hackyeah.backend.entities.Project;
import com.hackyeah.backend.repositories.ProjectsRepository;
import com.hackyeah.model.ProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
                        .title("Mój pomysł na liście")
                        .ideaImage("https://n-22-5.dcs.redcdn.pl/file/o2/redefine/cp/xj/xj1gx9v9k1kzz4x37wcagdhi6r4ckrwo.jpg")
                        .solutionImage("https://www.glebokaswiadomosc.pl/wp-content/uploads/2019/10/ekologiczne-konfetti.jpg")
                        .description("Idzie jesień więc o liście bardzo łatwo...")
                        .tags(List.of("liść"))
                        .points(4)
                        .creationTimestamp(Timestamp.valueOf(LocalDateTime.now().minusDays(17)).getTime()),
                new ProjectDto()
                        .id(2L)
                        .title("Reużyj rolki!")
                        .ideaImage("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/paper-roll-on-orange-background-royalty-free-image-1584641876.jpg")
                        .solutionImage("https://i.pinimg.com/564x/54/d5/27/54d52748c025cc5c11aff93e9136ba31.jpg")
                        .description("Zamiast wyrzucac rolki po papierze można stworzyć ładną doniczkę na sadzonki.")
                        .tags(List.of("rolka", "papier"))
                        .points(14)
                        .creationTimestamp(Timestamp.valueOf(LocalDateTime.now().minusDays(7)).getTime()),
                new ProjectDto()
                        .id(3L)
                        .title("Plecaczek")
                        .ideaImage("https://img.buzzfeed.com/buzzfeed-static/static/2019-04/11/15/asset/buzzfeed-prod-web-01/sub-buzz-19419-1555009752-1.jpg")
                        .solutionImage("https://img.buzzfeed.com/buzzfeed-static/static/2019-04/11/15/asset/buzzfeed-prod-web-01/sub-buzz-19661-1555009856-1.jpg")
                        .description("Bardzo prosty sposób na stworzenie swojego plecaka")
                        .tags(List.of("rolka", "papier"))
                        .points(14)
                        .creationTimestamp(Timestamp.valueOf(LocalDateTime.now()).getTime())
        );
    }
}
