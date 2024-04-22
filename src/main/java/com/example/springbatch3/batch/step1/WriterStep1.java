package com.example.springbatch3.batch.step1;


import com.example.springbatch3.entity.ApprovedTestTrxSummery;
import com.example.springbatch3.entity.FileUploadInfo;
import com.example.springbatch3.entity.TestTransactionDetailsView;
import com.example.springbatch3.procedurecall.TransactionSPcall;
import com.example.springbatch3.repository.*;
import com.example.springbatch3.service.APIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@Slf4j
public class WriterStep1 implements ItemWriter<ApprovedTestTrxSummery> {

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
    public void write(Chunk<? extends ApprovedTestTrxSummery> chunk) {


        chunk.forEach(item -> {

            String vCustomerName = "";

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            String settleDate = df.format(new Date());



            FileUploadInfo fileUploadInfo = fileUploadInfoRepo.findByTransactionReference(item.getTransactionReference());
            if (fileUploadInfo == null) {
                //transaction file info not found!
                // throw new Exception("Transactions not found!");
            }

            List<TestTransactionDetailsView> transactionViewList = transactionDetailsViewRepo.getByTrxRef(item.getTransactionReference());

            if (transactionViewList == null || transactionViewList.size() == 0) {
               // throw new Exception("Transactions not found!");

            }



            approveTransaction(item,fileUploadInfo,transactionViewList,0,settleDate,vCustomerName);
        });


    }
    public void approveTransaction(ApprovedTestTrxSummery item,
                                   FileUploadInfo fileUploadInfo,
                                   List<TestTransactionDetailsView> transactionViewList,
                                   int isAbabil,
                                   String settleDate,
                                   String vCustomerName){

        // Step#1 call oracle  procedure

        // step#2  call third party api

        // update api using oracle  procedure




    }




}
