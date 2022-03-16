package com.homework3.DTO;

import com.homework3.domain.AbstractEntity;
import com.homework3.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDto extends AbstractEntity {

    String number;
    String currency;
    Double balance;

    Long customer_id;

    public Long getId(){
        return id;
    }


}
