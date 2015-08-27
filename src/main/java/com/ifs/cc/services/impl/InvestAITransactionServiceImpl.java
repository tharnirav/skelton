package com.ifs.cc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifs.cc.domain.InvestAITransaction;
import com.ifs.cc.repositories.InvestAITransactionRepo;
import com.ifs.cc.services.FileReaderService;
import com.ifs.cc.services.InvestAITransactionService;

@Service("investAITransactionService")
public class InvestAITransactionServiceImpl implements InvestAITransactionService {

	@Autowired
	private FileReaderService  fileReaderService;
	
	@Autowired
	private InvestAITransactionRepo investAITransactionRepo;
	
	@Override
	public boolean insertData() {
		// TODO Auto-generated method stub
		
		List<InvestAITransaction> transactionList = fileReaderService.readInvestAITransactionCsv();
		
		boolean result = investAITransactionRepo.insertData(transactionList);
		
		return result;
	}

	@Override
	public List<InvestAITransaction> readData() {

		List<InvestAITransaction> investAITransactionList = investAITransactionRepo.readInvestAITransactionCsv();
		
		return investAITransactionList;
	}
}
