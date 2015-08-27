package com.ifs.cc.services.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifs.cc.domain.InvestAIBalance;
import com.ifs.cc.domain.InvestAITransaction;
import com.ifs.cc.services.FileReaderService;
import com.ifs.cc.services.util.InvestAIBalanceMapper;
import com.ifs.cc.services.util.InvestAITransactionMapper;

@Service("fileReaderService")
public class CsvFileReaderServiceImpl implements FileReaderService {

	private static final Logger logger = LoggerFactory.getLogger(CsvFileReaderServiceImpl.class);

	private final String COMMA_DELIMITER = ",";

	@Autowired
	private InvestAITransactionMapper transactionMapper;

	@Autowired
	private InvestAIBalanceMapper balanceMapper;
	
	ResourceBundle resource = ResourceBundle.getBundle("Message");

	public List<InvestAITransaction> readInvestAITransactionCsv() {

		List<InvestAITransaction> transactionList = new ArrayList<InvestAITransaction>();
		InvestAITransaction transaction = null;
		BufferedReader fileReader = null;
		String line = "";
		try {
			fileReader = new BufferedReader(new FileReader(resource.getString("investAI.transaction.file")));
			try {
				fileReader.readLine();
				fileReader.readLine();
				while ((line = fileReader.readLine()) != null) {

					String[] tokens = line.split(COMMA_DELIMITER);
					try {
						transaction = transactionMapper.fieldMapping(tokens);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						logger.error(e.toString());
					}
					transactionList.add(transaction);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error(e.toString());
			} finally {
				try {
					fileReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					logger.error(e.toString());
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e.toString());
		}
		return transactionList;
	}

	@Override
	public List<InvestAIBalance> readInvestAIBalanceCsv() {
		List<InvestAIBalance> balanceList = new ArrayList<InvestAIBalance>();
		InvestAIBalance balance = null;
		BufferedReader fileReader = null;
		String line = "";
		try {
			fileReader = new BufferedReader(new FileReader(resource.getString("investAI.balance.file")));
			try {
				fileReader.readLine();
				while ((line = fileReader.readLine()) != null) {

					String[] tokens = line.split(COMMA_DELIMITER);
					balance = balanceMapper.fieldMapping(tokens);
					balanceList.add(balance);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error(e.toString());
			} finally {
				try {
					fileReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					logger.error(e.toString());
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e.toString());
		}
		return balanceList;
	}
}
