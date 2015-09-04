package com.skelton.cc.repositories.jpa;

import com.skelton.cc.domain.InvestAITransaction;
import com.skelton.cc.repositories.GenericDAO;
import org.springframework.stereotype.Repository;

@Repository("investAITransactionDao")
public class InvestAIBalanceDao extends GenericDAO<InvestAITransaction, Long> {

    public InvestAIBalanceDao() {
    }
}
