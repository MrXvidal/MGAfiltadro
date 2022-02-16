package com.zetcode.repository;

import java.util.List;
import com.zetcode.model.Users;
import org.apache.tomcat.jni.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


public interface UserAccountRepository extends CrudRepository<User, Long> {


}