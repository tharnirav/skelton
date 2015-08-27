package com.ifs.cc.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ifs.cc.domain.InvestAIBalance;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-config.xml")
public class InvestAIBalanceRepoTest {
	
	private InvestAIBalance balance;
	
	private List<InvestAIBalance> investAIBalanceList;
	
	@Autowired
	InvestAIBalanceRepo repo;
	
	@Before
	public void setUp(){
	
		String startDate = "1/1/2001";
		String endDate = "12/31/2001";
		String fundID = "7777";
		String fundName = "Test Fund";
		String fundCurrency = "USD";
		String categorytype = "Asset";
		String accountNumber = "11111";
		String accountSegment_1 = "0";
		String accountSegment_2 = "0";
		String accountName = "Test Account";
		String openingBalance = "0";
		String dR = "2432432.234";
		String cR = "-2432432.234";
		String closingBalance = "-2432432.234";
		String createTimeStamp = "2015.07.30 14:20:37";
		String processStatusCode = "SUCCESSFUL";
		String sourceSystemName = "U";
		String processType = "INVESTAI";

		balance = new InvestAIBalance(startDate, endDate, fundID, fundName, fundCurrency, categorytype,
				accountNumber, accountSegment_1, accountSegment_2, accountName, openingBalance, dR, cR, closingBalance,
				createTimeStamp, processStatusCode, sourceSystemName, processType);
		investAIBalanceList = new ArrayList<InvestAIBalance>();
		investAIBalanceList.add(balance);
	}

	@Test
	public void testInsertReadAndTruncateBalanceList() {
		repo.insertData(investAIBalanceList);
		
		List<InvestAIBalance> expectedBalanceList;
		expectedBalanceList = repo.readInvestAIBalanceCsv();
		
		assertEquals(investAIBalanceList.size(), expectedBalanceList.size());
		
		assertEquals(expectedBalanceList.get(0).getFundID(),balance.getFundID());
		
	}

	@Test
	public void testInsertReadAndTruncateBalanceObject() {
		repo.insertData(balance);
		
		List<InvestAIBalance> expectedBalanceList;
		expectedBalanceList = repo.readInvestAIBalanceCsv();
		
		assertEquals(investAIBalanceList.size(), expectedBalanceList.size());
		
		assertEquals(expectedBalanceList.get(0).getFundID(),balance.getFundID());
	}

}
