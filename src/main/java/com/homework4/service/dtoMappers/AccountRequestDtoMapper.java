package com.homework3.service.dtoMappers;

import com.homework3.DTO.account.AccountRequestDto;
import com.homework3.domain.Account;
import com.homework3.domain.Currency;
import com.homework3.domain.Customer;
import com.homework3.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountRequestDtoMapper extends DtoMapperFacade<Account, AccountRequestDto>{

    @Autowired
    private CustomerService customerService;

    public AccountRequestDtoMapper(){
        super(Account.class, AccountRequestDto.class);
    }

    public void decorateEntity(final Account account, final AccountRequestDto dto){
        try {
            Customer c = customerService.getById(dto.getCustomer_id());
            account.setCustomer(c);
            Currency[] cur = Currency.values();
            Currency cU = cur[dto.getCurrency()];
            account.setCurrency(cU);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("invalid customer or currency");
        }
    }
}
