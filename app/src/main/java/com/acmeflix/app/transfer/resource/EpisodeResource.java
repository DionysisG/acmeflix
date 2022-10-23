package com.acmeflix.app.transfer.resource;


import com.acmeflix.app.domain.Content;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class EpisodeResource extends BaseResource {
	private Content content;
	private String title;
	private short seasonNum;
	private short episodeNum;
}
