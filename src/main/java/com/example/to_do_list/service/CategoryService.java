package com.example.to_do_list.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.to_do_list.entity.Category;
import com.example.to_do_list.repository.CategoryRepository;

@Service    
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category categorySave(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> categoryList(){
        return categoryRepository.findAll();
    } 

    public Optional<Category> categoryById(Long id){
        return categoryRepository.findById(id);
    }

    public void categoryDeleteById(Long id){
        categoryRepository.deleteById(id);
    }

    public void categoryDeleteAll(){
        categoryRepository.deleteAll();
    }

}
