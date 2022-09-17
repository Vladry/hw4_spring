package com.homework4.repository;

import com.homework4.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountJpaRepository extends JpaRepository<Account, Long> {
}
