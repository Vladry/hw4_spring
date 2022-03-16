package com.homework3.DTO.account;

import com.homework3.domain.Account;
import lombok.Data;

@Data
public class Account_Id_Dto extends Account {
    private Long customer_id = null;

    public Account_Id_Dto(){}

}