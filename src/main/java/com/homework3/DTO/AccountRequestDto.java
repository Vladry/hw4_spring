package com.homework3.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.homework3.domain.AbstractEntity;
import com.homework3.domain.Currency;
import com.homework3.domain.Customer;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequestDto extends AbstractEntity {

    String number;
    Currency currency;
    @Min(0)
    Double balance;
    Customer customer;


    public AccountRequestDto(Currency currency, Customer customer) {
        this.number = UUID.randomUUID().toString();
        this.currency = currency;
        this.balance = 0.0;
        this.customer = customer;
    }

    public AccountRequestDto(Currency currency, Double balance, Customer customer) {
        this.number = UUID.randomUUID().toString();
        this.currency = currency;
        this.balance = balance;
        this.customer = customer;
    }
}

