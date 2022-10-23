package com.acmeflix.app.mapper;

import org.mapstruct.Mapper;

import com.acmeflix.app.base.BaseMapper;
import com.acmeflix.app.domain.Genre;
import com.acmeflix.app.transfer.resource.GenreResource;

@Mapper(componentModel = "spring")
public interface GenreMapper extends BaseMapper<Genre, GenreResource> {

}