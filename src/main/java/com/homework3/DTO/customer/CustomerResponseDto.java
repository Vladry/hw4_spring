package com.homework3.DTO.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("fn")
    private String name;
    private String email;
    private Integer age;
    @JsonProperty("phN")
    private String phoneNumber;
    @JsonIgnore
    private String password;
    @JsonProperty("emplNa")
    private Set<Employer> employers_names;
    @JsonProperty("accCurr")
//    private Set<Account> accounts_currency;
    private String accounts_currency;

public Long getId(){
    return this.id;
}

}
