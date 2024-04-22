package com.example.springbatch3.config;

import com.example.springbatch3.batch.CblJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Component
@Slf4j
public class ScheduledJobBean {
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    CblJob job;

    @Autowired
    JobExplorer jobExplorer;

    @Autowired
    private JobRepository jobRepository;

    @Scheduled(cron = "${batch-schduled-time}")
    public void perform() throws Exception
    {


        SimpleDateFormat dateFormat = new SimpleDateFormat("EE, dd MMM yyyy, hh:mm a");
        String scheduleStartDate = dateFormat.format(new Date());
        log.info(" schedule start date  start Time------>  "+ scheduleStartDate);

        JobExecution execution = null;

            try {

                JobParameters jobParameters = new JobParametersBuilder()
                        .addLong("startAtCBLStep1", System.currentTimeMillis())
                        .toJobParameters();

                execution = jobLauncher.run(job.createFirstJob(), jobParameters);

                log.info( "{} CBL batch {} Step1 existStatus: "+execution.getExitStatus().getExitCode());

            } catch (JobExecutionAlreadyRunningException | JobRestartException |
                     JobInstanceAlreadyCompleteException |
                     JobParametersInvalidException ex) {
                // Handle exceptions if necessary
                log.error("{} EFT batch {} Step1 {} execution {} JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException message: "+ex.getMessage());
                ex.printStackTrace();

            }catch (Exception ex) {
                log.error("{} CBL batch {} Step1 execution {} error: "+ex.getMessage());
                ex.printStackTrace();
                log.error(ex.getMessage());

            }






        String scheduleEndDate = dateFormat.format(new Date());
        log.info( " CBL batch ended. # schedule end date {} Ended Time------>  "+ scheduleEndDate);





    }



}
