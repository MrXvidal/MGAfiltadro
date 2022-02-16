package com.zetcode.repository;

import org.springframework.data.repository.CrudRepository;

import com.zetcode.model.UserStatus;

public interface UserStatusTableCRUD extends CrudRepository<UserStatus, Integer>{

}
