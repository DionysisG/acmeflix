package com.acmeflix.app.transfer.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class GenreResource extends BaseResource {
    private String description;
}
