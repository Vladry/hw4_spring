package com.homework4.repository;

import com.homework4.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<Customer, Long> {
}
