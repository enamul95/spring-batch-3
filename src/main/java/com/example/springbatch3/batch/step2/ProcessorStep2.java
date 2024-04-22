package com.example.springbatch3.batch.step2;

import com.example.springbatch3.entity.AllTestTransactionView;
import com.example.springbatch3.procedurecall.TransactionSPcall;
import com.example.springbatch3.service.APIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ProcessorStep2 implements ItemProcessor<AllTestTransactionView, AllTestTransactionView> {


    @Autowired
    private APIService apiService;

    @Autowired
    private TransactionSPcall transactionSPcall;


    @Override
    public AllTestTransactionView process(AllTestTransactionView item) throws Exception {

        // process data

        return item;
    }



}
