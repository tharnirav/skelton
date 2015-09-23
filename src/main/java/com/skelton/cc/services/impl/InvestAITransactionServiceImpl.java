package com.skelton.cc.services.impl;

import com.skelton.cc.domain.InvestAITransaction;
import com.skelton.cc.repositories.InvestAITransactionDao;
import com.skelton.cc.services.FileReaderService;
import com.skelton.cc.services.InvestAITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("investAITransactionService")
public class InvestAITransactionServiceImpl implements InvestAITransactionService {

    @Autowired
    private FileReaderService fileReaderService;

    @Autowired
    private InvestAITransactionDao investAITransactionDao;

    @Override
    public boolean insertData() {
        List<InvestAITransaction> transactionList = fileReaderService.readInvestAITransactionCsv();
        investAITransactionDao.saveAll(transactionList);
        return true;
    }

    @Override
    public List<InvestAITransaction> readData() {
        List<InvestAITransaction> investAITransactionList = investAITransactionDao.findAll();
        return investAITransactionList;
    }
}
