package com.example.hexagonal.adapter.secundary.repository;

import com.example.hexagonal.adapter.secundary.model.TransactionDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionCrudRepository extends CrudRepository<TransactionDTO,String> {
    List<TransactionDTO> findByAccountNumber(String accountNumber);
}
