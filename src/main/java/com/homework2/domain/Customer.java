package com.homework2.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
