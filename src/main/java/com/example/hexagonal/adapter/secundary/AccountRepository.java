package com.example.hexagonal.adapter.secundary;

import com.example.hexagonal.adapter.secundary.model.AccountDTO;
import com.example.hexagonal.adapter.secundary.model.CustomerDTO;
import com.example.hexagonal.adapter.secundary.model.TransactionDTO;
import com.example.hexagonal.adapter.secundary.repository.AccountCrudRepository;
import com.example.hexagonal.adapter.secundary.repository.CustomerCrudRepository;
import com.example.hexagonal.adapter.secundary.repository.TransactionCrudRepository;
import com.example.hexagonal.core.model.Account;
import com.example.hexagonal.core.model.AccountTransaction;
import com.example.hexagonal.port.secundary.AccountRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.example.hexagonal.adapter.secundary.Mapper.*;

@AllArgsConstructor
@Service
@Slf4j
public class AccountRepository implements AccountRepositoryPort {
    AccountCrudRepository repository;
    CustomerCrudRepository customerRepository;
    TransactionCrudRepository transactionRepository;
    @Override
    public void save(Account account) {

        String accountId = UUID.randomUUID().toString();

        repository.save(new AccountDTO(accountId,
                account.getBalance()));

        customerRepository.save(mapCustomer(accountId, account.getCustomer()));

        List<AccountTransaction> transactions = account.getTransactions();
        transactions.forEach(t -> {
            transactionRepository.save(mapTransaction(accountId, t));
        });
    }

    @Override
    public Account getAccount(String account) {
        log.info("Getting account {}", account);

        AccountDTO accountDTO = repository.findById(account).get();

        List<TransactionDTO> transactionDTOS = transactionRepository.findByAccountNumber(account);
        List<AccountTransaction> transactions = transactionDTOS.stream()
                .map(Mapper::mapToTransaction)

                .collect(Collectors.toList());

        CustomerDTO customerDTO = customerRepository.findByAccountNumber(account);

        return Account.builder()
                .balance(accountDTO.getBalance())
                .transactions(transactions)
                .customer(mapToCustomer(customerDTO))
                .build();
    }

    @Override
    public List<String> getAccounts() {
        List<AccountDTO> all = (List<AccountDTO>) repository.findAll();
        return all
                .stream().map(AccountDTO::getAccountNumber).collect(Collectors.toList());
    }


}
