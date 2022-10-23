package com.acmeflix.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmeflix.app.domain.Content;
import com.acmeflix.app.domain.ContentType;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

    Optional<Content> findByTitle(final String title);

    List<Content> findByGenre(final String genre);

    List<Content> findByContentType(final ContentType contentType);
}
