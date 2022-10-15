package com.system.pe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.pe.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
	
	public Optional<Account> findByAccountUsername(String accountUsername);

}
