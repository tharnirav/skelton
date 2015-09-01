package com.skelton.cc.services;

import com.skelton.cc.domain.InvestAIBalance;
import com.skelton.cc.domain.InvestAITransaction;

import java.util.List;

public interface FileReaderService {

    public List<InvestAITransaction> readInvestAITransactionCsv();

    public List<InvestAIBalance> readInvestAIBalanceCsv();
}
