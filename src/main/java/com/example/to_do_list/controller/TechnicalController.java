package com.example.to_do_list.controller;

import com.example.to_do_list.entity.Technical;
import com.example.to_do_list.service.TechnicalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/technical")
public class TechnicalController {

    @Autowired
    private TechnicalService technicalService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Technical> technicalList(){
        return technicalService.technicalList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Technical technicalSave(@RequestBody Technical technical){
        return technicalService.technicalSave(technical);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void technicalUpdate(@PathVariable ("id") Long id, @RequestBody Technical technical){
        technicalService.technicalById(id)
                .map(technicalBase -> {
                    modelMapper.map(technical, technicalBase);
                    technicalService.technicalSave(technicalBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "technical not found."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void technicalDelete(@PathVariable ("id") Long id){
        technicalService.technicalById(id)
                .map(technical ->{
                    technicalService.technicalDeleteById(id);
                    return  Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "technical not found."));
    }

    @DeleteMapping("delete-all")
    public void technicalDeleteAll(){
        technicalService.technicalDeleteAll();
    }

}
