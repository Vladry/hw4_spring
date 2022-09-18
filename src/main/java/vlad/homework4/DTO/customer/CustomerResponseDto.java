package vlad.homework4.DTO.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import vlad.homework4.DTO.Views;
import vlad.homework4.domain.AbstractEntity;
import vlad.homework4.domain.Employer;
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
    @JsonView(Views.Internal.class)
    private String phoneNumber;
//    @JsonIgnore
//    private String password;
    @JsonProperty("emplNa")
    private Set<Employer> employers_names;
    @JsonView({Views.Public.class, Views.Internal.class})
    @JsonProperty("accCurr")
    private String accounts_currency;

public Long getId(){
    return this.id;
}

}
