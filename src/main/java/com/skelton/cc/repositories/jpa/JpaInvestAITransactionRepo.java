package com.skelton.cc.repositories.jpa;

import com.skelton.cc.domain.InvestAITransaction;
import com.skelton.cc.repositories.InvestAITransactionRepo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("investAITransactionRepo")
public class JpaInvestAITransactionRepo implements InvestAITransactionRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<InvestAITransaction> readInvestAITransactionCsv() {
        List<InvestAITransaction> transactionList = (List<InvestAITransaction>) entityManager.createQuery("SELECT b FROM InvestAITransaction b").getResultList();
        return transactionList;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean insertData(List<InvestAITransaction> investAITransactionList) {
        //Truncating data before inserting
        truncateData();
        for (InvestAITransaction transaction : investAITransactionList) {
            entityManager.persist(transaction);
            entityManager.flush();
        }

        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    private boolean truncateData() {

        entityManager.createQuery("delete from  InvestAITransaction").executeUpdate();
        entityManager.flush();
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean insertData(InvestAITransaction investAITransaction) {
        truncateData();
        entityManager.persist(investAITransaction);
        entityManager.flush();
        return true;
    }
}
