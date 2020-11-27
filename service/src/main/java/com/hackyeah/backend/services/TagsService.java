package com.hackyeah.backend.services;

import com.hackyeah.backend.entities.Tag;
import com.hackyeah.backend.repositories.TagsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TagsService {

    private final TagsRepository tagsRepository;

    public Set<Tag> fetchTags(List<String> tags) {
        return tags.stream()
                .map(tagName -> tagsRepository.findByName(tagName).orElseGet(() -> createTag(tagName)))
                .collect(Collectors.toSet());
    }

    private Tag createTag(String tagName) {
        final Tag tag = new Tag();
        tag.setName(tagName);
        return tagsRepository.save(tag);
    }
}
