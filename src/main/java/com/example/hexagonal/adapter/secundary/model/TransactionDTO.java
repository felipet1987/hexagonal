package com.example.hexagonal.adapter.secundary.model;

import com.example.hexagonal.core.model.TransactionType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "transaction")
public class TransactionDTO {
    @Id
    private String id;
    private String accountNumber;

    BigDecimal amount;
    TransactionType type;
    String timestamp;
    String description;


}
