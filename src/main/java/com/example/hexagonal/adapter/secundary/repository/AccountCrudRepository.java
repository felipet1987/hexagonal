package com.example.hexagonal.adapter.secundary.repository;

import com.example.hexagonal.adapter.secundary.model.AccountDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountCrudRepository extends CrudRepository<AccountDTO, String> {
//    @Query(
//            value = "SELECT * FROM accountdto a WHERE a.account_number = :accountNumber",nativeQuery = true)
    public Optional<AccountDTO> findByAccountNumber(String accountNumber);

}
