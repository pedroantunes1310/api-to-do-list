package com.example.to_do_list.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.to_do_list.entity.Category;
import com.example.to_do_list.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired 
    private ModelMapper modelMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Category> categoryList(){
        return categoryService.categoryList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category categorySave (@RequestBody Category category){
        return categoryService.categorySave(category);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void categoryUpdate(@PathVariable ("id") Long id, @RequestBody Category category){
        categoryService.categoryById(id)
                .map(categoryBase -> {
                    modelMapper.map(category, categoryBase);
                    categoryService.categorySave(categoryBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "category not found."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void categoryDelete(@PathVariable ("id") Long id){
        categoryService.categoryById(id)
                .map(category -> {
                    categoryService.categoryDeleteById(id);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "category not found."));
    }
}
