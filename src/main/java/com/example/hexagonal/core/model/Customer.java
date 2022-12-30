package com.example.hexagonal.core.model;

import com.example.hexagonal.core.model.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    String name;
    String email;
    String phone;
    Address address;

}
