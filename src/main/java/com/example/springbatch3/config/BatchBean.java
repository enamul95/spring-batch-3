package com.example.springbatch3.config;


import com.example.springbatch3.batch.step1.ProcessorStep1;
import com.example.springbatch3.batch.step1.WriterStep1;
import com.example.springbatch3.batch.step2.ProcessorStep2;
import com.example.springbatch3.batch.step2.WriterStep2;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchBean {
    @Bean
    public ProcessorStep1 batchProcessorStep1() {
        return new ProcessorStep1();
    }

    @Bean
    public WriterStep1 batchWriterStep1() {
        return new WriterStep1();
    }


    @Bean
    public ProcessorStep2 batchProcessorStep2() {
        return new ProcessorStep2();
    }

    @Bean
    public WriterStep2 batchWriterStep2() {
        return new WriterStep2();
    }


}
