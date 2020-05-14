package org.fkit.springboot.logintest.repository;

import org.fkit.springboot.logintest.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findById(int id);
}
