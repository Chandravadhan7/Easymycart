package com.xyz.easymycart.repository;

import com.xyz.easymycart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User save(User user);
}
