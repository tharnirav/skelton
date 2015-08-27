package com.ifs.cc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifs.cc.domain.InvestAIBalance;
import com.ifs.cc.repositories.InvestAIBalanceRepo;
import com.ifs.cc.services.FileReaderService;
import com.ifs.cc.services.InvestAIBalanceService;

@Service("investAIBalanceService")
public class InvestAIBalanceServiceImpl implements InvestAIBalanceService {

	@Autowired
	private FileReaderService fileReaderService;

	@Autowired
	private InvestAIBalanceRepo investAIBalanceRepo;

	@Override
	public boolean insertData() {
		List<InvestAIBalance> balanceList = fileReaderService.readInvestAIBalanceCsv();

		boolean result = investAIBalanceRepo.insertData(balanceList);

		return result;
	}

	@Override
	public List<InvestAIBalance> readData() {
		List<InvestAIBalance> investAIBalanceList = investAIBalanceRepo.readInvestAIBalanceCsv();

		return investAIBalanceList;
	}

}
