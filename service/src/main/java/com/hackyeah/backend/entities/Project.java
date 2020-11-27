package com.hackyeah.backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@Entity(name = "PROJECTS")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private User user;
    private String ideaImage;
    private String solutionImage;
    private String description;
    @ManyToMany
    private Set<Tag> tags;
    private int points;
    private Long creationTimestamp;
}
