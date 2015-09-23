package com.skelton.cc.repositories.jpa;

import com.skelton.cc.domain.InvestAIBalance;
import com.skelton.cc.domain.InvestAITransaction;
import com.skelton.cc.repositories.GenericDAO;
import com.skelton.cc.repositories.InvestAIBalanceDao;
import org.springframework.stereotype.Repository;

@Repository("investAIBalanceDao")
public class InvestAIBalanceJpaDao extends GenericDAO<InvestAIBalance, Long> implements InvestAIBalanceDao {

    public InvestAIBalanceJpaDao() {
    }
}
