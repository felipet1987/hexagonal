package com.example.hexagonal.adapter.secundary.model;

import com.example.hexagonal.core.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {
    @Id
    private String id;

    private String accountNumber;
    private String name;
    private String email;
    private String phone;

    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zipCode;





}
