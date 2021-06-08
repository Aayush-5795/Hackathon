package com.company.investments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.company.investments.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

	

}
