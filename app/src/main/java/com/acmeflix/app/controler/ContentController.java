package com.acmeflix.app.controler;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acmeflix.app.base.BaseMapper;
import com.acmeflix.app.domain.Content;
import com.acmeflix.app.domain.ContentType;
import com.acmeflix.app.mapper.ContentMapper;
import com.acmeflix.app.service.BaseService;
import com.acmeflix.app.service.ContentService;
import com.acmeflix.app.service.GenreService;
import com.acmeflix.app.transfer.ApiResponse;
import com.acmeflix.app.transfer.resource.ContentResource;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/content")
public class ContentController extends AbstractController<Content, ContentResource> {
    private final ContentService contentService;
    private final ContentMapper contentMapper;
    private final GenreService genreService;

    @Override
    protected BaseService<Content, Long> getBaseService() {
        return contentService;
    }

    @Override
    protected BaseMapper<Content, ContentResource> getMapper() {
        return contentMapper;
    }

    @GetMapping(params = {"title"})
    public ResponseEntity<ApiResponse<List<ContentResource>>> findByTitleIgnoreCaseContaining(@RequestParam String title) {

        return ResponseEntity.ok(
                ApiResponse.<List<ContentResource>>builder().data(getMapper().toResources(contentService.findByTitleIgnoreCaseContaining(title)))
                        .build());
    }

    @GetMapping(params = {"type"})
    public ResponseEntity<ApiResponse<List<ContentResource>>> findByContentType(@RequestParam String type) {
        return ResponseEntity.ok(
                ApiResponse.<List<ContentResource>>builder().data(getMapper().toResources(contentService.findByContentType(ContentType.valueOf(type))))
                        .build());
    }

    @GetMapping(params = {"genre"})
    public ResponseEntity<ApiResponse<List<ContentResource>>> findByGenre(@RequestParam String genre) {
        return ResponseEntity.ok(
                ApiResponse.<List<ContentResource>>builder().data(getMapper().toResources(contentService.findByGenre(genreService.findByDescription(genre))))
                        .build());
    }
}
