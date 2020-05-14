package org.fkit.springboot.logintest.repository;

import org.fkit.springboot.logintest.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClazzRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

}
