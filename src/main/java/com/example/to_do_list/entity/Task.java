package com.example.to_do_list.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "priority")
    private int priority;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "dateTime", nullable = false)
    private LocalDateTime dateTime;

    /*
    @Column(name = "user_id")
    private List<User> user;


    @Column(name = "category_id")
    private List<Category> category;
    */
}