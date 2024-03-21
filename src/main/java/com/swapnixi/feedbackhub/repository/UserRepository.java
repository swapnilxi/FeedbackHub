package com.swapnixi.feedbackhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swapnixi.feedbackhub.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    
}
