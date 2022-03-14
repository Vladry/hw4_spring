package com.homework3.DTO;

import com.homework3.domain.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class listCustomerDto {

    private List<CustomerRequestDto> list;
}
