package com.example.hexagonal.port.primary;

import com.example.hexagonal.core.model.Account;

import java.util.List;

public interface AccountServicePort {
    void saveAccount(Account account);

    Account getAccount(String account);

    List<String> getAccounts();
}
