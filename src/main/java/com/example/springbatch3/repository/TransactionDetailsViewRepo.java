package com.example.springbatch3.repository;

import com.example.springbatch3.entity.TestTransactionDetailsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDetailsViewRepo extends JpaRepository<TestTransactionDetailsView, Long> {

    @Query("select t from TestTransactionDetailsView as t where t.transactionReference=?1")
    List<TestTransactionDetailsView> getByTrxRef(String trxRef);


}
