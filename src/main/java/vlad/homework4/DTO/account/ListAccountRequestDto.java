package vlad.homework4.DTO.account;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ListAccountRequestDto {
    private List<AccountRequestDto> list;

}
