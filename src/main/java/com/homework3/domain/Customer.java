package com.homework3.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Entity
/*@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor*/

@Entity
@Getter
@Setter
//@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString(of = {"name", "email", "age", "phoneNumber"})


@Table(name = "customers")
public class Customer extends AbstractEntity {


    @Column(name = "name", length = 30, nullable = false)
    private String name;
    @Column(name= "email", length = 40, nullable = true)
    private String email;
    private Integer age;
    private String phoneNumber;
    @JsonIgnore
    @Column(name = "password", length = 30, nullable = false)
    private String password;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "customers_employers")
    private Set<Employer> employers = new HashSet<>();

    @OneToMany(mappedBy="customer", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Account> accounts = new HashSet<>();



/*
    public Customer(String name, String email, int age) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.accounts = new HashSet<>();
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Customer(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Customer(Long id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }
*/




}
