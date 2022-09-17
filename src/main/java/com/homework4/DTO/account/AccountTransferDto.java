package com.homework4.DTO.account;

import com.homework4.domain.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransferDto extends AbstractEntity {
    private String from;
    private String to;
    private String accNumber;
    private Double amount;
}


