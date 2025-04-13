package com.example.to_do_list.repository;


import com.example.to_do_list.entity.Requester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequesterRepository extends JpaRepository<Requester, Long> {

}
