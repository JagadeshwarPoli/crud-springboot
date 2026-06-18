package com.self.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.self.crud.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
