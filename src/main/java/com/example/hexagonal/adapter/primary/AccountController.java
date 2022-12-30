package com.example.hexagonal.adapter.primary;

import com.example.hexagonal.core.model.Account;
import com.example.hexagonal.port.primary.AccountServicePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
public class AccountController {
    private AccountServicePort accountService;

    @PostMapping(
            value = "/api/v1/saveAccount",
            produces = "application/json"
    )
    public void saveAccount(@RequestBody Account account) {
        log.info("Saving account: {}", account);
        accountService.saveAccount(account);
    }
    @PostMapping(
            value = "/api/v1/getAccount")
    public Account getAccount(@RequestBody AccountQuery account) {
        log.info("Getting account: " + account.toString());
        return accountService.getAccount(account.account);
    }

    @PostMapping(
            value = "/api/v1/getAccounts")
    public List<String> getAccounts() {
        return accountService.getAccounts();
    }



}
