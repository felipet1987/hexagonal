package com.example.hexagonal.adapter.secundary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountDTO {
    @Id
    private String accountNumber;
    private BigDecimal balance;


}
