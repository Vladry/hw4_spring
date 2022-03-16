package com.homework3.DAO;

import com.homework3.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountJpaRepository extends JpaRepository<Account, Long> {
}
