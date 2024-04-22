package com.example.springbatch3.batch.step1;


import com.example.springbatch3.entity.ApprovedTestTrxSummery;
import com.example.springbatch3.payload.response.MarkAsHoldResponse;
import com.example.springbatch3.procedurecall.TransactionSPcall;
import com.example.springbatch3.repository.TestApprovedTrxSummaryRepo;
import com.example.springbatch3.repository.CorpApprovedTransactionRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class ReaderStep1 implements ItemReader<ApprovedTestTrxSummery> {

    private Iterator<ApprovedTestTrxSummery> iterator;

    private final TransactionSPcall transactionSPcall;

    public ReaderStep1(TestApprovedTrxSummaryRepo approvedTrxSummaryRepo, CorpApprovedTransactionRepo corpApprovedTransactionRepo, TransactionSPcall transactionSPcall) {
        this.transactionSPcall = transactionSPcall;

        log.info("reader Step1  Started step1 *****");

        LocalDate todayDate = LocalDate.now();
        List<ApprovedTestTrxSummery> list = approvedTrxSummaryRepo.getAllTransaction();


        log.info(" CBL reader Step1 {} list: "+list.size());

        if(!list.isEmpty()){

            StringBuilder sb = new StringBuilder();
            sb = sb.append("<statement>");
            for(ApprovedTestTrxSummery trxSummery:list){
                sb = sb.append( "<rowrecord>");
                sb = sb.append("<REFERENCE_NUMBER>" + trxSummery.getTransactionReference() + "</REFERENCE_NUMBER>");
                sb = sb.append("</rowrecord>");
            }
            sb = sb.append("</statement>");

            // update data after read for processing to stop other batch getting same data

            MarkAsHoldResponse response = transactionSPcall.updateBulkReference(sb.toString());
            log.info(" reader Step1  response: "+response.getOutCode());
            log.info(" reader Step1  outMessage: "+response.getOutMessage());

            if(response.getOutCode() == 1){
                this.iterator = list.iterator();
            }
        }
    }

    @Override
    public ApprovedTestTrxSummery read() {
        return (iterator != null && iterator.hasNext()) ? iterator.next() : null;
    }
}
