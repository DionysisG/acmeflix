package com.acmeflix.app.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acmeflix.app.base.BaseMapper;
import com.acmeflix.app.domain.Genre;
import com.acmeflix.app.mapper.GenreMapper;
import com.acmeflix.app.service.BaseService;
import com.acmeflix.app.service.GenreService;
import com.acmeflix.app.transfer.ApiResponse;
import com.acmeflix.app.transfer.resource.GenreResource;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/genres")
public class GenreController extends AbstractController<Genre, GenreResource> {
    private final GenreService genreService;
    private final GenreMapper genreMapper;

    @Override
    protected BaseService<Genre, Long> getBaseService() {
        return genreService;
    }

    @Override
    protected BaseMapper<Genre, GenreResource> getMapper() {
        return genreMapper;
    }

    @GetMapping(params = {"description"})
	public ResponseEntity<ApiResponse<GenreResource>> findByDescription(@RequestParam String description) {
		return ResponseEntity.ok(
                ApiResponse.<GenreResource>builder().data(getMapper().toResource(genreService.findByDescription(description)))
                        .build());
	}
}