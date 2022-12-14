package vlad.homework4.DTO.employer;

import lombok.experimental.Accessors;
import vlad.homework4.domain.AbstractEntity;
import vlad.homework4.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
public class EmployerResponseDto extends AbstractEntity {

    private String name;
    private String street;
    private String address;
    private Set<Customer> customers_ids;

public Long getId(){return this.id;}
}
