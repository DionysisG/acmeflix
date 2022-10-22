package com.acmeflix.app.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACCOUNTS")
@SequenceGenerator(name = "idGenerator", sequenceName = "ACCOUNTS_SEQ", initialValue = 1, allocationSize = 1)
public class Account extends BaseModel {

	@Column(nullable = false)
	private Date registerDate;

    @NotNull
    @ManyToOne
    private SubscriptionPlan subscriptionPlan;

    @NotNull
	@Email
	@Column(length = 50, nullable = false, unique = true)
	private String email;

    @NotNull
	@Column(length = 40, nullable = false)
	private String firstname;

    @NotNull
	@Column(length = 40, nullable = false)
	private String lastname;

	@Column(length = 100)
	private String address;
}
