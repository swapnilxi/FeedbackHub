package com.swapnixi.feedbackhub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swapnixi.feedbackhub.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u")
    List<User> findMyUsers();

    @Query("SELECT u FROM User u WHERE u.name LIKE '%new%'")
    List<User> nameHasNewKeyword();

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password ")
    boolean login(@Param("email") String email, @Param("password") String password);

}
