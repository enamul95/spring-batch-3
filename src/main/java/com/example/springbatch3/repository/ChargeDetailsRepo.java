package com.example.springbatch3.repository;


import com.example.springbatch3.entity.ChargeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargeDetailsRepo extends JpaRepository<ChargeDetails, Long> {


}
