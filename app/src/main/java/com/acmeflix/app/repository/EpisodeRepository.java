package com.acmeflix.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmeflix.app.domain.Content;
import com.acmeflix.app.domain.Episode;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long> {

	List<Episode> findByContent(final Content content);
}
