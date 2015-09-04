package com.skelton.cc.repositories;

import com.skelton.cc.domain.InvestAITransaction;
import com.skelton.cc.repositories.jpa.InvestAITransactionDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-config.xml")
public class InvestAITransactionDaoTest {

    private DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

    private InvestAITransaction transaction;

    private List<InvestAITransaction> investAITransactionList;

    @Autowired
    InvestAITransactionDao investAITransactionDao;

    @Before
    public void setUp() throws ParseException {

        Date startDate = df.parse("01/01/2001");
        Date endDate = df.parse("12/31/2001");
        Long fundId = Long.parseLong("9999");
        String fundName = "Test Fund1";
        Long investmentId = Long.parseLong("999");
        String investmentName = "InvestName1";
        String investmentType = "PI";
        String investmentCurrency = "USD";

        Date tradeDate = df.parse("3/28/2001");
        Date settlementDate = df.parse("3/28/2001");
        String action = "Dist:Cash";
        Long units = 1L;

        BigDecimal inflow = new BigDecimal(2423432.56);
        BigDecimal outflow = new BigDecimal(2);
        String securityType = "equity";
        String assetType = "hedgeFund";
        String timestamp = "20150730_142135";

        transaction = new InvestAITransaction(startDate, endDate, fundId, fundName, investmentId, investmentName,
                investmentType, investmentCurrency, tradeDate, settlementDate, action, units, inflow, outflow,
                securityType, assetType, timestamp);
        ///initialized list
        investAITransactionList = new ArrayList<InvestAITransaction>();
        investAITransactionList.add(transaction);
    }

    @Test
    public void testInsertReadAndTruncateTransactionObject() {

        investAITransactionDao.save(transaction);

        List<InvestAITransaction> expectedTransactionList;
        expectedTransactionList = investAITransactionDao.findAll();

        assertEquals(investAITransactionList.size(), expectedTransactionList.size());

        assertEquals(expectedTransactionList.get(0).getFundId(), transaction.getFundId());
    }

//    @Test
//    public void testInsertReadAndTruncateTransactionList() {
//
//        investAITransactionRepo.insertData(investAITransactionList);
//
//        List<InvestAITransaction> expectedTransactionList;
//        expectedTransactionList = investAITransactionRepo.readInvestAITransactionCsv();
//
//        assertEquals(investAITransactionList.size(), expectedTransactionList.size());
//
//        assertEquals(expectedTransactionList.get(0).getFundId(), transaction.getFundId());
//    }
}
