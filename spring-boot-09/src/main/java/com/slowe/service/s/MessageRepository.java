package com.slowe.service.s;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slowe.entity.s.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{

}
