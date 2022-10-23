package com.acmeflix.app.mapper;

import org.mapstruct.Mapper;

import com.acmeflix.app.base.BaseMapper;
import com.acmeflix.app.domain.Episode;
import com.acmeflix.app.transfer.resource.EpisodeResource;

@Mapper(componentModel = "spring")
public interface EpisodeMapper extends BaseMapper<Episode, EpisodeResource> {

}
