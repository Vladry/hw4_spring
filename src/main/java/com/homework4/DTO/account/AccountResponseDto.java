package com.homework3.DTO.account;

import com.homework3.domain.AbstractEntity;
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
