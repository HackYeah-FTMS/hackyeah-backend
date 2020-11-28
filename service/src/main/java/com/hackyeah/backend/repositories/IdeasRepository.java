package com.hackyeah.backend.repositories;

import com.hackyeah.backend.entities.Idea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdeasRepository extends JpaRepository<Idea, Long> {
}
