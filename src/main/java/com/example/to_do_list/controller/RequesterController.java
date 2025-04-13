package com.example.to_do_list.controller;

import com.example.to_do_list.entity.Requester;
import com.example.to_do_list.service.RequesterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/requester")
public class RequesterController {

    @Autowired
    private RequesterService requesterService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Requester> requesterList(){
        return requesterService.requesterList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Requester requesterSave(@RequestBody Requester requester){
        return requesterService.requesterSave(requester);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void requesterUpdate(@PathVariable ("id") Long id, @RequestBody Requester requester){
        requesterService.requesterById(id)
                .map(requesterBase -> {
                    modelMapper.map(requester, requesterBase);
                    requesterService.requesterSave(requesterBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "requester not found."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void requesterDelete(@PathVariable ("id") Long id){
        requesterService.requesterById(id)
                .map(requester ->{
                    requesterService.requesterDeletebyId(id);
                    return  Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "requester not found."));
    }

    @DeleteMapping("delete-all")
    public void requesterDeleteAll(){
        requesterService.requesterDeleteAll();
    }

}
