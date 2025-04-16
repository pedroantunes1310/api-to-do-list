package com.example.to_do_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.to_do_list.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
