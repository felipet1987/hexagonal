package com.example.hexagonal.port.secundary;

import com.example.hexagonal.core.model.Account;

import java.util.List;

public interface AccountRepositoryPort {
    void save(Account account);

    Account getAccount(String account);

    List<String> getAccounts();
}
