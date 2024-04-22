package com.example.springbatch3.batch;

import com.example.springbatch3.batch.step1.ProcessorStep1;
import com.example.springbatch3.batch.step1.ReaderStep1;
import com.example.springbatch3.batch.step1.WriterStep1;
import com.example.springbatch3.batch.step2.ProcessorStep2;
import com.example.springbatch3.batch.step2.ReaderStep2;
import com.example.springbatch3.batch.step2.WriterStep2;
import com.example.springbatch3.entity.AllTestTransactionView;
import com.example.springbatch3.entity.ApprovedTestTrxSummery;
import com.example.springbatch3.procedurecall.TransactionSPcall;
import com.example.springbatch3.repository.AllTestApprovedTransactionViewRepo;
import com.example.springbatch3.repository.TestApprovedTrxSummaryRepo;
import com.example.springbatch3.repository.CorpApprovedTransactionRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

@Component
@RequiredArgsConstructor
@Slf4j
public class CblJob {
    private final TestApprovedTrxSummaryRepo approvedTrxSummaryRepo;
    private final CorpApprovedTransactionRepo corpApprovedTransactionRepo;

    private final AllTestApprovedTransactionViewRepo allApprovedTransactionViewRepo;


    private final ProcessorStep1 batchProcessorStep1;
    private final WriterStep1 batchWriterStep1;

    private final ProcessorStep2 batchProcessorStep2;
    private final WriterStep2 batchWriterStep2;

    private final PlatformTransactionManager transactionManager;
    private final JobRepository jobRepository;


    @Autowired
    private TransactionSPcall transactionSPcall;


    @Value("${spring.batch.job.chunk.size}")
    private Integer chunkSize;


    public Job createFirstJob(){

        return new JobBuilder("CBL-STEP1", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step1())
                .next(step2())
                .build();


    }




    private Step step1(){


        return new StepBuilder("step1", jobRepository)
                .<ApprovedTestTrxSummery, ApprovedTestTrxSummery> chunk(chunkSize, transactionManager)
                .reader(new ReaderStep1(approvedTrxSummaryRepo,corpApprovedTransactionRepo, transactionSPcall))
                .processor(batchProcessorStep1)
                .writer(batchWriterStep1)
                .build();
    }

    private Step step2(){

        return new StepBuilder("step2", jobRepository)
                .<AllTestTransactionView, AllTestTransactionView> chunk(chunkSize, transactionManager)
                .reader(new ReaderStep2(allApprovedTransactionViewRepo))
                .processor(batchProcessorStep2)
                .writer(batchWriterStep2)
                .build();
    }

}
