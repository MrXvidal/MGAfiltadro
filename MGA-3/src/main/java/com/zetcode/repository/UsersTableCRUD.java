package com.zetcode.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zetcode.model.Users;

public interface UsersTableCRUD extends CrudRepository<Users, Integer>{


}
