package com.mycompany.newsroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mycompany.newsroom.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
