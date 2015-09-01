package com.skelton.cc.repositories;

import com.skelton.cc.domain.InvestAIBalance;

import java.util.List;

public interface InvestAIBalanceRepo {

    public boolean insertData(InvestAIBalance investAIBalance);

    public boolean insertData(List<InvestAIBalance> investAIBalanceList);

    public List<InvestAIBalance> readInvestAIBalanceCsv();
}
