package com.homework3.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.homework3.domain.AbstractEntity;
import com.homework3.domain.Currency;
import com.homework3.domain.Customer;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequestDto extends AbstractEntity {

    @Min(0)
    @Max(4)
    int currency;
    @Min(0)
    Double balance;
    @Min(1)
    Long customer_id;


//    public AccountRequestDto(int currency, Double balance, Long customer_id) {
//        this.currency = currency;
//        this.balance = balance;
//        this.customer_id = customer_id;
//    }

}

