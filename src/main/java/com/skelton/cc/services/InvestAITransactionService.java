package com.skelton.cc.services;

import com.skelton.cc.domain.InvestAITransaction;

import java.util.List;

public interface InvestAITransactionService {

    public boolean insertData();

    public List<InvestAITransaction> readData();

}
