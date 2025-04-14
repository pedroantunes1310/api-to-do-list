package com.example.to_do_list.service;

import com.example.to_do_list.entity.Requester;
import com.example.to_do_list.repository.RequesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequesterService {

    @Autowired
    private RequesterRepository requesterRepository;

    public Requester requesterSave(Requester requester){
        return requesterRepository.save(requester);
    }

    public List<Requester> requesterList(){
        return requesterRepository.findAll();
    }

    public Optional<Requester> requesterById(Long id){
        return requesterRepository.findById(id);
    }

    public void requesterDeleteById(Long id){
        requesterRepository.deleteById(id);
    }

    public void requesterDeleteAll(){
        requesterRepository.deleteAll();
    }

}
