package com.homework3.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer extends AbstractEntity {


    @Column(name = "name", length = 30, nullable = false)
    private String name;
    @Column(name= "email", length = 40, nullable = true)
    private String email;
    private Integer age;
    private String phoneNumber;
    @JsonIgnore
    private String password;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "customers_employers")
    private Set<Employer> employers;



    @OneToMany(mappedBy="customer", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Account> accounts;

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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Customer c = (Customer) o;
        return this.name.equals(c.name) && this.email.equals(c.email) && this.age.equals(c.age);
    }

    @Override
    public int hashCode() {
        int h1 = 31 * this.name.hashCode();
        int h2 = 15 * this.email.hashCode();
        int h3 = 37 * this.age;

        return h1+h2+h3;
    }

    @Override
    public String toString() {
        return null;
    }

}
