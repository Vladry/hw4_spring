package com.homework3.DTO;

import com.homework3.domain.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerRequestDto extends AbstractEntity {
    @Min(3)
    private String name;
    @Min(3)
    private String street;
    @Min(3)
    private String address;
    private Set<CustomerRequestDto> customers;


}
