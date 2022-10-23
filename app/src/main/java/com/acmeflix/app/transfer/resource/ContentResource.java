package com.acmeflix.app.transfer.resource;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.acmeflix.app.domain.ContentType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class ContentResource extends BaseResource {
    private ContentType contentType;
    private String title;
    private String director;
    private String cast;
    private Set<GenreResource> genre = new HashSet<>();
    private Date releaseDate;
}
