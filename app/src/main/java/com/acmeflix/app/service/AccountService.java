package com.acmeflix.app.service;

import com.acmeflix.app.domain.Account;

public interface AccountService extends BaseService<Account, Long> {
    Account findByEmail(String email);
}
