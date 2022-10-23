package com.acmeflix.app.mapper;

import org.mapstruct.Mapper;

import com.acmeflix.app.base.BaseMapper;
import com.acmeflix.app.domain.Account;
import com.acmeflix.app.transfer.resource.AccountResource;

@Mapper(componentModel = "spring")
public interface AccountMapper extends BaseMapper<Account, AccountResource> {

}
