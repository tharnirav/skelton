package com.ifs.cc.services;

import com.ifs.cc.domain.InvestAIBalance;
import com.ifs.cc.domain.InvestAITransaction;

import java.util.List;

public interface FileReaderService {

	public List<InvestAITransaction> readInvestAITransactionCsv();
	
	public List<InvestAIBalance> readInvestAIBalanceCsv();
}
