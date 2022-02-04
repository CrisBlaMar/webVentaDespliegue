package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CantProdu;

@Repository
public interface CantProduRepository extends JpaRepository<CantProdu, Long>{

}
