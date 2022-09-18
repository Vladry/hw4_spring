package vlad.homework4.DTO.account;

import vlad.homework4.domain.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransferDto extends AbstractEntity {
    private String from;
    private String to;
    private String accNumber;
    private Double amount;
}


