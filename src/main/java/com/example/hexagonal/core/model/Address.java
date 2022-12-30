package com.example.hexagonal.core.model;

import lombok.Builder;
import lombok.Value;

@Value
public class Address {
    String street1;
    String street2;
    String city;
    String state;
    String zipCode;
}
