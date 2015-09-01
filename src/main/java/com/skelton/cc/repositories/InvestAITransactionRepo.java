package com.skelton.cc.repositories;

import com.skelton.cc.domain.InvestAITransaction;

import java.util.List;

public interface InvestAITransactionRepo {

    public boolean insertData(InvestAITransaction investAITransaction);

    public boolean insertData(List<InvestAITransaction> investAITransactionList);

    public List<InvestAITransaction> readInvestAITransactionCsv();

}
