package com.acmeflix.app.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.acmeflix.app.domain.Content;
import com.acmeflix.app.domain.ContentType;
import com.acmeflix.app.domain.Genre;
import com.acmeflix.app.repository.ContentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl extends BaseServiceImpl<Content> implements ContentService {
    private final ContentRepository contentRepository;

    @Override
	public JpaRepository<Content, Long> getRepository() {
		return contentRepository;
	}

    @Override
    public List<Content> findByTitleIgnoreCaseContaining (String title) {
        return contentRepository.findByTitleIgnoreCaseContaining(title);
    }

    @Override
    public List<Content> findByGenre(Genre genre) {
        return contentRepository.findByGenre(genre);
    }

    @Override
    public List<Content> findByContentType(ContentType contentType) {
        return contentRepository.findByContentType(contentType);
    }

    @Override
    public Content findById(Long id) {
        return contentRepository.findById(id).orElseThrow();
    }
}
