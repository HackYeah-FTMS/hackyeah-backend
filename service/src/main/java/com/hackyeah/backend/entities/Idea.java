package com.hackyeah.backend.entities;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.Set;

@Getter
@Entity(name = "IDEAS")
public class Idea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private User user;
    private String image;
    private String additionalInfo;
    @ManyToMany
    private Set<Tag> tags;
    @OneToMany
    private List<Comment> comments;
    private int points;
    private Long creationTimestamp;
}
