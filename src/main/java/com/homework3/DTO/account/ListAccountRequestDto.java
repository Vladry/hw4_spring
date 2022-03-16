package com.homework3.DTO.account;

import com.homework3.domain.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ListAccountRequestDto {
    private List<AccountRequestDto> list;

}
