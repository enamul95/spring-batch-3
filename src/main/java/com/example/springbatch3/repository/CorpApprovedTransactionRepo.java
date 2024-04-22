package com.example.springbatch3.repository;


import com.example.springbatch3.entity.TestApprovedTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CorpApprovedTransactionRepo extends JpaRepository<TestApprovedTransaction, Long> {







}
