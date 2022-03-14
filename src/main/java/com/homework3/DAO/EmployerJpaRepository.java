package com.homework3.DAO;

import com.homework3.domain.Employer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployerJpaRepository extends JpaRepository<Employer, Long> {
}
