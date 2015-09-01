package com.skelton.cc.services.impl;

import com.skelton.cc.domain.InvestAITransaction;
import com.skelton.cc.repositories.InvestAITransactionRepo;
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
