package com.acmeflix.app.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.acmeflix.app.domain.SubscriptionPlan;
import com.acmeflix.app.repository.SubscriptionPlanRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubscriptionPlanServiceImpl extends BaseServiceImpl<SubscriptionPlan> implements SubscriptionPlanService {
    private final SubscriptionPlanRepository subscriptionPlanRepository;

    @Override
    public JpaRepository<SubscriptionPlan, Long> getRepository() {
        return subscriptionPlanRepository;
    }

    @Override
    public SubscriptionPlan findByDescription(final String description) {
        return subscriptionPlanRepository.findByDescriptionIgnoreCase(description).orElseThrow();
    }

}
