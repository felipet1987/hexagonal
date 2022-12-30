package com.example.hexagonal.core.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class AccountTransaction {
    BigDecimal amount;
    TransactionType type;
    String timestamp;
    String description;
}
