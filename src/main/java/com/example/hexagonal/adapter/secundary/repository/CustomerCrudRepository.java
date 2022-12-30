package com.example.hexagonal.adapter.secundary.repository;

import com.example.hexagonal.adapter.secundary.model.CustomerDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerCrudRepository extends CrudRepository<CustomerDTO, String> {
    @Query(
            value = "SELECT * FROM Customer c WHERE c.account_number = :accountNumber",
            nativeQuery = true)
    CustomerDTO findByAccountNumber(String accountNumber);
}
