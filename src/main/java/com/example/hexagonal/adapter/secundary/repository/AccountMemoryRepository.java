package com.example.hexagonal.adapter.secundary.repository;

import com.example.hexagonal.adapter.secundary.model.AccountDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@Slf4j
public class AccountMemoryRepository {

    List<AccountDTO> accounts = new ArrayList<>();

    private static void accept(AccountDTO a) {
        log.info(a.toString());
    }

    public void save(AccountDTO accountDTO) {
        accounts.add(accountDTO);
    }

    public AccountDTO findByAccountNumber(String account) {
        log.info(account);

        accounts.forEach(AccountMemoryRepository::accept);


        return accounts.stream().filter(a -> account.equals(a.getAccountNumber())).findFirst().orElse(null);
    }

    public List<AccountDTO> findAll() {
        return accounts;
    }
}
