package com.swapnixi.feedbackhub.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@getters
@Table(name= "users")
public class Users{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="user_name", nullable = false,length = 100)
    private String name; 
    @Column(name="user_email", nullable = false,length = 100)
    private String email;
    private String password;
    private String about;

}