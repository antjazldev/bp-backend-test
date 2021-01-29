package com.pichincha.backend.test.rest;

import com.pichincha.backend.test.dto.AccountDto;
import com.pichincha.backend.test.dto.TransactionDto;
import com.pichincha.backend.test.service.AccountService;
import com.pichincha.backend.test.service.TransactionService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/accounts")
public class AccountController {

	private final AccountService aService;
	private final TransactionService tService;


	public AccountController(AccountService accountService,
			                 TransactionService transactionService) {
		this.aService = accountService;
		this.tService = transactionService;
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public AccountDto getAccount(@PathVariable Long id) {
		return aService.getAccount(id);
	}
	@GetMapping(value = "/{id}/transactions")
	@ResponseStatus(HttpStatus.OK)
	public List<TransactionDto> getTransactionsForAccount(@PathVariable Long id) {
		return tService.getTransactionsForAccount(id);
	}

}
