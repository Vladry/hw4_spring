package com.homework3.DTO.account;

import com.homework3.domain.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequestDto extends AbstractEntity {

    @Min(0)
    @Max(4)
    private int currency;
    @Min(0)
    private Double balance;
    @Min(1)
    private Long customer_id;
    private String account_id;
    private String number;
}

