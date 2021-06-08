package com.company.investments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.company.investments.entity.UserAccounts;
import com.company.investments.entity.Users;

@Repository
public interface UserAccountsRepository extends JpaRepository<UserAccounts, Long> {

	List<UserAccounts> findByUser(Users loguser);


}
