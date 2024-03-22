package com.swapnixi.feedbackhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swapnixi.feedbackhub.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u")
    List<User> findMyUsers();

    @Query("SELECT u FROM User u WHERE u.name LIKE '%new%'")
    List<User> nameHasNewKeyword();


}
