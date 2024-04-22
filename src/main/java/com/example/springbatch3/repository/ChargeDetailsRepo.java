package com.example.springbatch3.repository;


import com.example.springbatch3.entity.ChargeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChargeDetailsRepo extends JpaRepository<ChargeDetails, Long> {


}
