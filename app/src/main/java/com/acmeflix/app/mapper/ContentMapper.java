package com.acmeflix.app.mapper;

import org.mapstruct.Mapper;

import com.acmeflix.app.base.BaseMapper;
import com.acmeflix.app.domain.Content;
import com.acmeflix.app.transfer.resource.ContentResource;

@Mapper(componentModel = "spring")
public interface ContentMapper extends BaseMapper<Content, ContentResource> {

}