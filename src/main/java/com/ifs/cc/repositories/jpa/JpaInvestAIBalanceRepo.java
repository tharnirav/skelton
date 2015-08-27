package com.ifs.cc.repositories.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ifs.cc.domain.InvestAIBalance;
import com.ifs.cc.repositories.InvestAIBalanceRepo;

@Repository("investAIBalanceRepo")
public class JpaInvestAIBalanceRepo implements InvestAIBalanceRepo {

	@PersistenceContext
    private EntityManager entityManager;

	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public boolean insertData(List<InvestAIBalance> investAIBalanceList) {
		truncateData();
		for(InvestAIBalance balance : investAIBalanceList){
			entityManager.persist(balance);
			entityManager.flush();
		}
		return false;
	}

	@Override
	public List<InvestAIBalance> readInvestAIBalanceCsv() {
		 List<InvestAIBalance> balanceList = (List<InvestAIBalance>)entityManager.createQuery("SELECT b FROM InvestAIBalance b").getResultList();
		 return balanceList;
	}
		

	@Transactional(propagation=Propagation.REQUIRED)
	private boolean truncateData() {
		entityManager.createQuery("delete from InvestAIBalance").executeUpdate();
		entityManager.flush();
		return true;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public boolean insertData(InvestAIBalance investAIBalance) {
		truncateData();
		entityManager.persist(investAIBalance);
		entityManager.flush();
		return true;
	}

}
