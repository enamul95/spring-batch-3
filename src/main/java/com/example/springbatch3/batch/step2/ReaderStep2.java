package com.example.springbatch3.batch.step2;

;
import com.example.springbatch3.entity.AllTestTransactionView;
import com.example.springbatch3.repository.AllTestApprovedTransactionViewRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;

import java.util.Iterator;
import java.util.List;

@Slf4j
public class ReaderStep2 implements ItemReader<AllTestTransactionView> {

    private Iterator<AllTestTransactionView> iterator;



    public ReaderStep2(AllTestApprovedTransactionViewRepo allApprovedTransactionViewRepoo) {

        log.info(" Step2  Started: ");

       List<AllTestTransactionView> list = allApprovedTransactionViewRepoo.getAllTransaction();
        log.info(" Step2 list: "+list.size());

        if(!list.isEmpty()){

            this.iterator = list.iterator();
        }

    }

    @Override
    public AllTestTransactionView read() {

        return (iterator != null && iterator.hasNext()) ? iterator.next() : null;
    }
}
