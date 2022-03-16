package com.homework3.service.dtoMappers;

import com.homework3.DTO.AccountRequestDto;
import com.homework3.domain.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountRequestDtoMapper extends DtoMapperFacade<Account, AccountRequestDto>{
    public AccountRequestDtoMapper(){
        super(Account.class, AccountRequestDto.class);
    }

}
