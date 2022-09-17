package com.homework3.DTO.employer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.homework3.domain.AbstractEntity;
import com.homework3.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerResponseDto extends AbstractEntity {

    private String name;
    private String street;
    private String address;
    private Set<Customer> customers_ids;

public Long getId(){return this.id;}
}
