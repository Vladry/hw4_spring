package com.homework3.DTO;

import com.homework3.domain.AbstractEntity;
import com.homework3.domain.Account;
import com.homework3.domain.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDto extends AbstractEntity {

    private String name;
    private String email;
    private Integer age;
    private String phoneNumber;
    private Set<Employer> employers_names;
    private Set<Account> accounts_currency;

public Long getId(){
    return this.id;
}

}
