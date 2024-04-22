package com.example.springbatch3.repository;



import com.example.springbatch3.entity.ApprovedTestTrxSummery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface TestApprovedTrxSummaryRepo extends JpaRepository<ApprovedTestTrxSummery, Long> {

    //@Query("select t from ApprovedTrxSummery as t where  t.status =17")
   //



    @Query(value = "SELECT * FROM APPROVED_TRX_SUMMERY WHERE STATUS = 17 AND PAYMENT_TYPE_ID = 2 AND TRUNC(INSERT_DATE) = TRUNC(SYSDATE) FOR UPDATE", nativeQuery = true)
    List<ApprovedTestTrxSummery> getAllTransaction();


///TO_CHAR(INSERT_DATE, 'mm') = TO_CHAR(sysdate, 'mm')
    ApprovedTestTrxSummery findByTransactionReference(String transactionReference);


    @Modifying
    @Query(" update ApprovedTestTrxSummery set status = 2 where status= 44 and transactionReference = ?1")
    public void updateSegmentedTransaction(String transactionReference);

    @Query("select a from ApprovedTestTrxSummery a where a.status = 44 and a.paymentTypeId=2  and a.transactionReference = ?1")
    ApprovedTestTrxSummery getApprovedTrxSummeryByTransactionReference(String transactionReference);


    @Query("select a from ApprovedTestTrxSummery a where a.status = 44 and a.paymentTypeId=2  and a.transactionReference = ?1")
    ApprovedTestTrxSummery getUpdatedTransactionStatus(String transactionReference);





}
