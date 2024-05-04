package com.likelion.lionshop.repository;

import com.likelion.lionshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
