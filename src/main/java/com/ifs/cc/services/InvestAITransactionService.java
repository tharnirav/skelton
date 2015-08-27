package com.ifs.cc.services;

import java.util.List;

import com.ifs.cc.domain.InvestAITransaction;

public interface InvestAITransactionService {

    public boolean insertData();
    
    public List<InvestAITransaction> readData();

}
