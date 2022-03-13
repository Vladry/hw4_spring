package com.homework3.DTO;

import com.homework3.domain.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerRequestDto extends AbstractEntity {
//    @Min(3)
    @Size(min = 3, message = "name must be longer")
    private String name;
    @Size(min = 3, message = "street must be longer")
    private String street;
    @Size(min = 3, message = "address must be longer")
    private String address;
    private Set<CustomerRequestDto> customers;


}
