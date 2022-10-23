package com.acmeflix.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EPISODES")
@SequenceGenerator(name = "idGenerator", sequenceName = "EPISODES_SEQ", initialValue = 1, allocationSize = 1)
public class Episode extends BaseModel {

	@NotNull
    @ManyToOne
	private Content content;

	@NotNull
	@Column(length = 100, nullable = false)
	private String title;

	@NotNull
	private short seasonNum;

	@NotNull
	private short episodeNum;
}
