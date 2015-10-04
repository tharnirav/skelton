/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.skelton.cc.integration;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.integration.annotation.Router;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marius Bogoevici
 * @author Gunnar Hillert
 */
public class JobExecutionsRouter {

	@Router
	public List<String> routeJobExecution(JobExecution jobExecution) {

		System.out.println("Inside router......................................................................");
		final List<String> routeToChannels = new ArrayList<String>();

		if (jobExecution.getStatus().equals(BatchStatus.FAILED)) {
			routeToChannels.add("jobRestarts");
		}
		else {

			if (jobExecution.getStatus().equals(BatchStatus.COMPLETED)) {
				routeToChannels.add("completeApplication");
			}

			routeToChannels.add("notifiableExecutions");
		}

		return routeToChannels;
	}
}
