package com.skelton.cc.repositories.jpa;

import com.skelton.cc.domain.InvestAITransaction;
import com.skelton.cc.repositories.GenericDAO;
import com.skelton.cc.repositories.InvestAITransactionRepo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("investAITransactionDao")
public class InvestAITransactionDao extends GenericDAO<InvestAITransaction, Long> {

    public InvestAITransactionDao() {
    }
}
