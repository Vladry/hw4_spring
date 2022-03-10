package com.homework2.DTO;

import com.homework2.domain.Account;
import lombok.Data;

@Data
public class AccountDto extends Account {
    private Long customer_id = null;

    public AccountDto(){}

}