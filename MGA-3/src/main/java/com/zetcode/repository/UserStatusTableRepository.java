package com.zetcode.repository;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.zetcode.model.UserStatus;

@Repository
public interface UserStatusTableRepository extends JpaRepository<UserStatus, Integer> {

}