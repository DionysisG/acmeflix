package com.acmeflix.app.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acmeflix.app.base.BaseMapper;
import com.acmeflix.app.domain.Account;
import com.acmeflix.app.mapper.AccountMapper;
import com.acmeflix.app.service.BaseService;
import com.acmeflix.app.service.AccountService;
import com.acmeflix.app.transfer.ApiResponse;
import com.acmeflix.app.transfer.resource.AccountResource;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController extends AbstractController<Account, AccountResource> {
    private final AccountService accountService;
    private final AccountMapper accountMapper;

	@Override
	public BaseService<Account, Long> getBaseService() {
		return accountService;
	}

	@Override
	public BaseMapper<Account, AccountResource> getMapper() {
		return accountMapper;
	}

	@GetMapping(params = {"email"})
	public ResponseEntity<ApiResponse<AccountResource>> findByEmail(@RequestParam String email) {
		return ResponseEntity.ok(
				ApiResponse.<AccountResource>builder().data(getMapper().toResource(accountService.findByEmail(email)))
                        .build());
	}
}
