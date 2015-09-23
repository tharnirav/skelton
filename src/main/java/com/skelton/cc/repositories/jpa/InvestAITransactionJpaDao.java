package com.skelton.cc.repositories.jpa;

import com.skelton.cc.domain.InvestAITransaction;
import com.skelton.cc.repositories.GenericDAO;
import com.skelton.cc.repositories.InvestAITransactionDao;
import org.springframework.stereotype.Repository;

@Repository("investAITransactionDao")
public class InvestAITransactionJpaDao extends GenericDAO<InvestAITransaction, Long> implements InvestAITransactionDao {

    public InvestAITransactionJpaDao() {
    }
}
