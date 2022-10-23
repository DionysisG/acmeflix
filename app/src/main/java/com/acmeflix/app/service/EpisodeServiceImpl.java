package com.acmeflix.app.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.acmeflix.app.domain.Content;
import com.acmeflix.app.domain.Episode;
import com.acmeflix.app.repository.EpisodeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EpisodeServiceImpl extends BaseServiceImpl<Episode> implements EpisodeService {
    private final EpisodeRepository episodeRepository;

    @Override
    public JpaRepository<Episode, Long> getRepository() {
        return episodeRepository;
    }

    @Override
    public List<Episode> findByContent(Content content) {
        return episodeRepository.findByContent(content);
    }
}