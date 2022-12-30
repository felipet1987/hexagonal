package com.example.hexagonal.core.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@ToString
public class Account {
    private Customer customer;
    private List<AccountTransaction> transactions;
    private BigDecimal balance;
}
