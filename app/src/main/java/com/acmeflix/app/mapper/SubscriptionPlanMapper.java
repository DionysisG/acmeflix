package com.acmeflix.app.mapper;

import org.mapstruct.Mapper;

import com.acmeflix.app.base.BaseMapper;
import com.acmeflix.app.domain.SubscriptionPlan;
import com.acmeflix.app.transfer.resource.SubscriptionPlanResource;

@Mapper(componentModel = "spring")
public interface SubscriptionPlanMapper extends BaseMapper<SubscriptionPlan, SubscriptionPlanResource> {

}
