package com.example.to_do_list.repository;

import com.example.to_do_list.entity.Technical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicalRepository extends JpaRepository<Technical, Long> {

}
