package com.skelton.cc.batch;

/**
 * Created by nthar on 10/3/2015.
 */

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JobStatusCheckScheduler {

    @Autowired @Qualifier("statuses")
    private QueueChannel statusesChannel;

    public void run() {

        JobExecution jobExecution = ((Message<JobExecution>) statusesChannel.receive(120000)).getPayload();
        ExitStatus exitStatus = jobExecution.getExitStatus();
        System.out.println(" Job status is ................................"  +  exitStatus.getExitCode());

    }
}
