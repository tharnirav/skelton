package com.ifs.cc.repositories;

import java.util.List;

import com.ifs.cc.domain.InvestAIBalance;

public interface InvestAIBalanceRepo {

	public boolean insertData(InvestAIBalance investAIBalance);
	
	public boolean insertData(List<InvestAIBalance> investAIBalanceList);

	public List<InvestAIBalance> readInvestAIBalanceCsv();
}
