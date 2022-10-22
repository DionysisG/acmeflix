package com.acmeflix.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

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
@Table(name = "PLANS")
@SequenceGenerator(name = "idGenerator", sequenceName = "PLANS_SEQ", initialValue = 1, allocationSize = 1)
public class SubscriptionPlan extends BaseModel {
	@NotNull
	@Column(name = "desc", length = 50, nullable = false)
    private String description;

    @NotNull
    @Min(value = 1, message = "At least 1 device at a time")
	@Column( name = "sim_devices", nullable = false)
    private short simultaneousWatch;

    @NotNull
    @Min(value = 1, message = "At least 1 profile must exist")
	@Column(name = "max_profiles", nullable = false)
    private short maxProfiles;

    @Null
    @Column(precision = 6, scale = 2, nullable = true)
    private double price;

    @NotNull
	@Column(name = "available", nullable = false)
    private boolean available;
}
