package com.slowe.service.p;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slowe.entity.p.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
