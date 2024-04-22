package com.example.springbatch3.batch.step2;

import com.example.springbatch3.entity.AllTestTransactionView;
import com.example.springbatch3.procedurecall.TransactionSPcall;
import com.example.springbatch3.repository.ChargeDetailsRepo;
import com.example.springbatch3.service.APIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
public class WriterStep2 implements ItemWriter<AllTestTransactionView> {

    @Autowired
    private ChargeDetailsRepo chargeDetailsRepo;

    @Autowired
    private APIService apiService;

    @Autowired
    private TransactionSPcall transactionSPcall;

    @Override
    public void write(Chunk<? extends AllTestTransactionView> chunk) {


        chunk.forEach(item -> {


            // Step#1 call another oracle  procedure

            // step#2  call another third party api

            // update api another using oracle  procedure

        });


    }


}

