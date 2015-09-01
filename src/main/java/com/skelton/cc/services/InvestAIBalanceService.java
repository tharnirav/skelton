package com.skelton.cc.services;

import com.skelton.cc.domain.InvestAIBalance;

import java.util.List;

public interface InvestAIBalanceService {

    public boolean insertData();

    public List<InvestAIBalance> readData();

}
