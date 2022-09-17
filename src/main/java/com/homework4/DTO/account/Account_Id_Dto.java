package com.homework4.DTO.account;

import com.homework4.domain.Account;
import lombok.Data;

@Data
public class Account_Id_Dto extends Account {
    private Long customer_id = null;

    public Account_Id_Dto(){}

}