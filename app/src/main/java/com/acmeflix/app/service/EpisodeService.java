package com.acmeflix.app.service;

import java.util.List;

import com.acmeflix.app.domain.Content;
import com.acmeflix.app.domain.Episode;

public interface EpisodeService extends BaseService<Episode, Long> {

	List<Episode> findByContent(Content content);
}
