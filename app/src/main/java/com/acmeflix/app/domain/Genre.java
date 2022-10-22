package com.acmeflix.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "GENRES")
@SequenceGenerator(name = "idGenerator", sequenceName = "GENRES_SEQ", initialValue = 1, allocationSize = 1)
public class Genre extends BaseModel {
	@NotNull
	@Column(name = "desc", length = 50, nullable = false)
	private String description;
}
