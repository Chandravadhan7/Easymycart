package com.xyz.easymycart.repository;

import com.xyz.easymycart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

  User save(User user);

  @Query(value = "select * from user u where u.id = :id", nativeQuery = true)
  User getUserDetails(@Param("id") Long id);

  @Query(value = "select * from user u where u.email = :email", nativeQuery = true)
  User getUserByEmail(@Param("email") String email);
}
