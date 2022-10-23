package com.acmeflix.app.service;

import com.acmeflix.app.domain.SubscriptionPlan;

public interface SubscriptionPlanService extends BaseService<SubscriptionPlan, Long>{
    SubscriptionPlan findByDescription(String description);
}
