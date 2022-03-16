package com.homework3.DTO;

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
    int currency;
    @Min(0)
    Double balance;
    @Min(1)
    Long customer_id;
    String account_id;
}

