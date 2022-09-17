package com.homework3.DTO.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.homework3.DTO.Views;
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
    @JsonView({Views.Public.class, Views.Internal.class})
    private String name;
    @JsonView(Views.Public.class)
    private String email;
    @JsonView(Views.Public.class)
    private Integer age;
    @JsonProperty("phN")
    @JsonView(Views.Public.class)
    private String phoneNumber;
    @JsonIgnore
    private String password;
    @JsonProperty("emplNa")
    private Set<Employer> employers_names;
    @JsonView({Views.Public.class, Views.Internal.class})
    @JsonProperty("accCurr")
    private String accounts_currency;

public Long getId(){
    return this.id;
}

}
