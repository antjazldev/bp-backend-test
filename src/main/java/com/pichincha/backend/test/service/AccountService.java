package com.pichincha.backend.test.service;

import com.pichincha.backend.test.dto.AccountDto;
import com.pichincha.backend.test.dto.NewTransactionDto;
import com.pichincha.backend.test.dto.TransactionDto;
import com.pichincha.backend.test.repository.AccountRepository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public class AccountService {

	private final AccountRepository accountRepository;

	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public AccountDto getAccount(Long id) {
		return accountRepository.findById(id)
				.map(account -> new AccountDto(account.getNumber(), account.getType(), account.getCreationDate()))
				.orElse(null);
	}
}
