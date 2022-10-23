package com.acmeflix.app.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.acmeflix.app.domain.Genre;
import com.acmeflix.app.repository.GenreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl extends BaseServiceImpl<Genre> implements GenreService {
    private final GenreRepository genreRepository;

	@Override
	public JpaRepository<Genre, Long> getRepository() {
		return genreRepository;
	}

	@Override
	public Genre findByDescription(final String description) {
		return genreRepository.findByDescriptionIgnoreCase(description).orElseThrow();
	}
}
