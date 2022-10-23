package com.acmeflix.app.service;

import java.util.List;

import com.acmeflix.app.domain.Content;
import com.acmeflix.app.domain.ContentType;
import com.acmeflix.app.domain.Genre;

public interface ContentService extends BaseService<Content, Long> {
    List<Content> findByTitleIgnoreCaseContaining(String title);

    List<Content> findByGenre(Genre genre);

    List<Content> findByContentType(ContentType contentType);

    Content findById(Long id);
}