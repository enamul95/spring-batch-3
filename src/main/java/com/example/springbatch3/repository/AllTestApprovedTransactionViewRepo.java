package com.example.springbatch3.repository;



import com.example.springbatch3.entity.AllTestTransactionView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Repository
public interface AllTestApprovedTransactionViewRepo extends JpaRepository<AllTestTransactionView, Long> {


    @Query(value = "SELECT * FROM VW_ALL_APPROVED_TANSACTION WHERE STATUS = 6 AND PAYMENT_TYPE_ID = 2 AND  SETTLEMENT_STATUS = 1 AND TRUNC(INSERT_DATE) = TRUNC(SYSDATE) FOR UPDATE", nativeQuery = true)
    List<AllTestTransactionView> getAllTransaction();


}
