/*
 * Copyright 2002-2014 the original author or authors.
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

import org.springframework.batch.core.JobExecution;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.mail.MailHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

/**
 * @author Marius Bogoevici
 * @author Gunnar Hillert
 */
public class ExecutionsToMailTransformer {

	@Transformer
	public Message<String> transformExecutionsToMail(JobExecution jobExecution) {
		System.out.println("Inside mail transformer......................................................................");
		String result = "Execution has " + jobExecution.getStatus().toString();
		return MessageBuilder.withPayload(result)
				.setHeader(MailHeaders.TO, "testt@imis.com")
				.setHeader(MailHeaders.FROM, "testt@imis.com").build();
	}
}
