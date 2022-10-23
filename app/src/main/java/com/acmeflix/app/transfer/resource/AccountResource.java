package com.acmeflix.app.transfer.resource;

import java.util.Date;

import com.acmeflix.app.domain.SubscriptionPlan;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class AccountResource extends BaseResource {
    private Date registerDate;
    private SubscriptionPlan subscriptionPlan;
    private String email;
    private String firstname;
    private String lastname;
    private String address;
    private boolean active;
}
