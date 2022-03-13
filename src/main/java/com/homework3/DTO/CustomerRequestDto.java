package com.homework3.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.homework3.domain.AbstractEntity;
import com.homework3.domain.Account;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestDto extends AbstractEntity {

    @Min(2)
    private String name;
    @Email
    private String email;
    @Min(18)
    @Max(100)
    private Integer age;
    @Pattern(regexp = "(\\+38|0)[0-9]{9}]")   // https://www.baeldung.com/java-regex-validate-phone-numbers
    private String phoneNumber;
    @JsonIgnore
    @NotBlank
    private String password;
    private Set<EmployerRequestDto> employers;
    private Set<Account> accounts;



    public CustomerRequestDto(String name, String email, int age) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.accounts = new HashSet<>();
    }

    public CustomerRequestDto(String name) {
        this.name = name;
    }

    public CustomerRequestDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public CustomerRequestDto(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public CustomerRequestDto(Long id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
