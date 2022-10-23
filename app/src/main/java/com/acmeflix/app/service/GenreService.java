package com.acmeflix.app.service;

import com.acmeflix.app.domain.Genre;

public interface GenreService extends BaseService<Genre, Long>{
    Genre findByDescription(String description);
}
