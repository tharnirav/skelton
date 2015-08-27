package com.ifs.cc.services;

import java.util.List;

import com.ifs.cc.domain.InvestAIBalance;

public interface InvestAIBalanceService {

    public boolean insertData();
    
    public List<InvestAIBalance> readData();

}
