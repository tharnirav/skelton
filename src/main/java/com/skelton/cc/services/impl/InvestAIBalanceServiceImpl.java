package com.skelton.cc.services.impl;

import com.skelton.cc.domain.InvestAIBalance;
import com.skelton.cc.repositories.InvestAIBalanceDao;
import com.skelton.cc.services.FileReaderService;
import com.skelton.cc.services.InvestAIBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("investAIBalanceService")
public class InvestAIBalanceServiceImpl implements InvestAIBalanceService {

    @Autowired
    private FileReaderService fileReaderService;

    @Autowired
    private InvestAIBalanceDao investAIBalanceDao;

    @Override
    public boolean insertData() {
        List<InvestAIBalance> balanceList = fileReaderService.readInvestAIBalanceCsv();
        investAIBalanceDao.saveAll(balanceList);
        return true;
    }

    @Override
    public List<InvestAIBalance> readData() {
        List<InvestAIBalance> investAIBalanceList = investAIBalanceDao.findAll();
        return investAIBalanceList;
    }

}
