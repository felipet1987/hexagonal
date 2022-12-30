package com.example.hexagonal.core.service;

import com.example.hexagonal.core.model.Account;
import com.example.hexagonal.port.primary.AccountServicePort;
import com.example.hexagonal.port.secundary.AccountRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AccountService implements AccountServicePort {

    private final AccountRepositoryPort accountRepository;

    @Override
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Account getAccount(String account) {

        return accountRepository.getAccount(account);
    }

    @Override
    public List<String> getAccounts() {
        return accountRepository.getAccounts();
    }


}
