package com.acmeflix.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmeflix.app.domain.Content;
import com.acmeflix.app.domain.ContentType;
import com.acmeflix.app.domain.Genre;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

    List<Content> findByTitleIgnoreCaseContaining(final String title);

    List<Content> findByGenre(final Genre genre);

    List<Content> findByContentType(final ContentType contentType);

    Optional<Content> findById(final Long id);

}
