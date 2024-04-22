package com.example.springbatch3.repository;


import com.example.springbatch3.entity.TestApprovedTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CorpApprovedTransactionRepo extends JpaRepository<TestApprovedTransaction, Long> {







}
