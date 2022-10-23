package com.acmeflix.app.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
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
@Table(name = "CONTAINTS")
@SequenceGenerator(name = "idGenerator", sequenceName = "CONTAINTS_SEQ", initialValue = 1, allocationSize = 1)
public class Content extends BaseModel {

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private ContentType contentType;

	@NotNull
	@Column(length = 100, nullable = false)
	private String title;

	@NotNull
	@Column(length = 40, nullable = false)
	private String director;

	@NotNull
	@Column(length = 100, nullable = false)
	private String cast;

	@NotNull
	@ManyToMany
	private Set<@NotNull Genre> genre;

	@NotNull
	@Column(nullable = false)
	private Date releaseDate;
}