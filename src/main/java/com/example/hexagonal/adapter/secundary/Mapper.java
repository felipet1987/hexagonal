package com.example.hexagonal.adapter.secundary;

import com.example.hexagonal.adapter.secundary.model.CustomerDTO;
import com.example.hexagonal.adapter.secundary.model.TransactionDTO;
import com.example.hexagonal.core.model.AccountTransaction;
import com.example.hexagonal.core.model.Address;
import com.example.hexagonal.core.model.Customer;

import java.util.UUID;

public class Mapper {

     static AccountTransaction mapToTransaction(TransactionDTO t) {
        return AccountTransaction.builder()
                .amount(t.getAmount())
                .type(t.getType())
                .timestamp(t.getTimestamp())
                .description(t.getDescription())
                .build();
    }

    static  Customer mapToCustomer(CustomerDTO customerDTO) {
        Address address = new Address(
                customerDTO.getStreet1(),
                customerDTO.getStreet2(),
                customerDTO.getCity(),
                customerDTO.getState(),
                customerDTO.getZipCode()
        );
        return Customer.builder()
                .address(address)
                .phone(customerDTO.getPhone())
                .name(customerDTO.getName())
                .email(customerDTO.getEmail())
                .build();
    }

    static  TransactionDTO mapTransaction(String accountId, AccountTransaction t) {
        return TransactionDTO.builder()
                .id(UUID.randomUUID().toString())
                .accountNumber(accountId)
                .amount(t.getAmount())
                .description(t.getDescription())
                .timestamp(t.getTimestamp())
                .type(t.getType())
                .build();
    }

     static CustomerDTO mapCustomer(String accountId, Customer customer) {
        Address address = customer.getAddress();
        return CustomerDTO.builder()
                .id(UUID.randomUUID().toString())
                .accountNumber(accountId)
                .name(customer.getName())
                .email(customer.getEmail())
                .city(address.getCity())
                .phone(customer.getPhone())
                .state(address.getState())
                .street1(address.getStreet1())
                .street2(address.getStreet2())
                .zipCode(address.getZipCode())
                .phone(customer.getPhone())
                .build();
    }

}
