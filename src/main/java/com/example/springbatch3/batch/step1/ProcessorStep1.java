package com.example.springbatch3.batch.step1;



import com.example.springbatch3.entity.ApprovedTestTrxSummery;
import com.example.springbatch3.entity.TestTransactionDetailsView;
import com.example.springbatch3.procedurecall.TransactionSPcall;
import com.example.springbatch3.repository.*;
import com.example.springbatch3.service.APIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class ProcessorStep1 implements ItemProcessor<ApprovedTestTrxSummery, ApprovedTestTrxSummery> {


    @Autowired
    private FileUploadInfoRepo fileUploadInfoRepo;

    @Autowired
    private APIService apiService;

    @Autowired
    private TransactionDetailsViewRepo transactionDetailsViewRepo;

    @Autowired
    private TestApprovedTrxSummaryRepo approvedTrxSummaryRepo;

    @Autowired
    private CorpApprovedTransactionRepo corpApprovedTransactionRepo;


    @Autowired
    private TransactionSPcall transactionSPcall;

    @Autowired
    private ChargeDetailsRepo chargeDetailsRepo;


    @Override
    public ApprovedTestTrxSummery process(ApprovedTestTrxSummery item) throws Exception {


        log.info( " CBL process Step1   Started  *****");


        ApprovedTestTrxSummery approvedTrxSummeryByTransactionReference = approvedTrxSummaryRepo.getApprovedTrxSummeryByTransactionReference(item.getTransactionReference());

        if(approvedTrxSummeryByTransactionReference == null){
            log.info( "{} CBL process Step1 {} approvedTrxSummeryByTransactionReference {} not found :"+item.getTransactionReference());
            return null;
        }



        /** End Account Balance Check*/


        List<TestTransactionDetailsView> transactionViewList = transactionDetailsViewRepo.getByTrxRef(item.getTransactionReference());

        if (transactionViewList == null || transactionViewList.size() == 0) {
            log.info( "CBL process Step1 {} Transactions not found!: " + item.getTransactionReference());
            //throw new CityLiveException("Transactions not found!");
            return  null;
        }


        return item;
    }




}
