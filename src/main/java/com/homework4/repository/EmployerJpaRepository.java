package com.homework4.repository;

import com.homework4.domain.Employer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployerJpaRepository extends JpaRepository<Employer, Long> {
}
