package com.acmeflix.app.controler;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acmeflix.app.base.BaseMapper;
import com.acmeflix.app.domain.Episode;
import com.acmeflix.app.mapper.EpisodeMapper;
import com.acmeflix.app.service.BaseService;
import com.acmeflix.app.service.ContentService;
import com.acmeflix.app.service.EpisodeService;
import com.acmeflix.app.transfer.ApiResponse;
import com.acmeflix.app.transfer.resource.EpisodeResource;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/episodes")
public class EpisodeController extends AbstractController<Episode, EpisodeResource> {
	private final EpisodeService episodeService;
	private final EpisodeMapper episodeMapper;
	private final ContentService contentService;

	@Override
	protected BaseService<Episode, Long> getBaseService() {
		return episodeService;
	}

	@Override
	protected BaseMapper<Episode, EpisodeResource> getMapper() {
		return episodeMapper;
	}

	@GetMapping(params = {"content"})
    public ResponseEntity<ApiResponse<List<EpisodeResource>>> findByContent(@RequestParam Long content) {
        return ResponseEntity.ok(
                ApiResponse.<List<EpisodeResource>>builder().data(getMapper().toResources(episodeService.findByContent(contentService.findById(content))))
						.build());
    }
}
