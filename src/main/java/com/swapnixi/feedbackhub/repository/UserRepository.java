package com.swapnixi.feedbackhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swapnixi.feedbackhub.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    
}
