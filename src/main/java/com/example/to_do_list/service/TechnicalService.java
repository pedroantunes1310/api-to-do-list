package com.example.to_do_list.service;

import com.example.to_do_list.entity.Technical;
import com.example.to_do_list.repository.TechnicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicalService {

    @Autowired
    private TechnicalRepository technicalRepository;

    public List<Technical> technicalList() {
        return technicalRepository.findAll();
    }

    public Technical technicalSave (Technical technical) {
        return technicalRepository.save(technical);
    }

    public Optional<Technical> technicalById(Long id) {
        return technicalRepository.findById(id);
    }

    public void technicalDeleteById(Long id) {
        technicalRepository.deleteById(id);
    }

    public void technicalDeleteAll() {
        technicalRepository.deleteAll();

    }

}
