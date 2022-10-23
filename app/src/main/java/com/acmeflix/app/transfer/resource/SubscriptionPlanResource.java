package com.acmeflix.app.transfer.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class SubscriptionPlanResource extends BaseResource {
    private String description;
    private short simultaneousWatch;
    private short maxProfiles;
    private double price;
    private boolean available;
}
