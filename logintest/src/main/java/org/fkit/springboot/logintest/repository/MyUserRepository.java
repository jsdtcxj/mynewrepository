package org.fkit.springboot.logintest.repository;

import org.fkit.springboot.logintest.security.pojo.FKUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<FKUser, Long>{

	FKUser findByLoginName(String loginName);
}
