package com.pichincha.backend.test.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.pichincha.backend.test.dto.AccountDto;
import com.pichincha.backend.test.dto.NewTransactionDto;
import com.pichincha.backend.test.dto.TransactionDto;
import com.pichincha.backend.test.model.Account;
import com.pichincha.backend.test.model.Transaction;
import com.pichincha.backend.test.repository.AccountRepository;
import com.pichincha.backend.test.repository.TransactionRepository;

@Repository
@Component
public class TransactionService {
	private final TransactionRepository transactionRepository;
	private final AccountRepository accountRepository;
	@PersistenceContext // or even @Autowired
    private EntityManager entityManager;
	public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository)
	{
		this.transactionRepository = transactionRepository;
		this.accountRepository = accountRepository;
	}
	/**
	 * Returns a list of all transactions for a account with passed id.
	 *
	 * @param accountId id of the account
	 * @return list of transactions sorted by creation date descending - most recent first
	 */
	public List<TransactionDto> getTransactionsForAccount(Long accountId) {
		ModelMapper modelMapper = new ModelMapper();
		Optional<Transaction> var= transactionRepository.findByAccount(accountId);
		return var.stream()
				.map(transaction -> modelMapper.map(transaction, TransactionDto.class))
				.collect(Collectors.toList());
	}

	/**
	 * Creates a new transaction
	 *
	 * @param newTransactionDto data of new transaction
	 * @return id of the created transaction
	 * @throws IllegalArgumentException if there is no account for passed newTransactionDto.accountId
	 */
	public Long addTransaction(NewTransactionDto newTransactionDto) {
		Account account = accountRepository.getOne(newTransactionDto.getAccountId());
		Transaction transaction = new Transaction();
		transaction.setAccount(account);
		transaction.setComment(newTransactionDto.getComment());
		transaction.setType(newTransactionDto.getType());
		
		return transactionRepository.save(transaction).getId();
	}
}
