package org.fkit.springboot.security.repository;

import org.fkit.springboot.security.pojo.FKUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<FKUser, Long>{

	FKUser findByLoginName(String loginName);
}
