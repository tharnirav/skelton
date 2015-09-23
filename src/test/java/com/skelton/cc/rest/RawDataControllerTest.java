package com.skelton.cc.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skelton.cc.domain.InvestAITransaction;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class RawDataControllerTest extends BaseJerseyTest {

    private RawDataController controller;

    public RawDataControllerTest() throws Exception {
        super();
    }
    //target = client.target("http://localhost:8080/fra-cnc/api/rawData");

    @Test
    public void canGETanInvestAITransactionFundNameValue() throws Exception {

        WebTarget target = target("rawData/investAI/transaction");
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        javax.ws.rs.core.Response response = builder.get();
        String investAITransaction = builder.get(String.class);
        System.out.println(investAITransaction);
        assertEquals(200, response.getStatus());



        //as on D3 field of the csv INVESTAI_TRANSACTION_BLACKROCK_44128_123114_073015
        String actualTransactionFundName = "Test Fund1";
        assertNotNull(investAITransaction);

        ObjectMapper mapper = new ObjectMapper();
        InvestAITransaction[] investAITransactionArray = mapper.readValue(investAITransaction,
                InvestAITransaction[].class);

        String expectedTransactionFundname = investAITransactionArray[1].getFundName();
        assertEquals(expectedTransactionFundname, actualTransactionFundName);

        //Number of Rows existing in the csv INVESTAI_TRANSACTION_BLACKROCK_44128_123114_073015
        int actualSizeOfInvestAITransactionSheet = 32;
        int expectedSizeOfInvestAIBalanceSheet = investAITransactionArray.length;
        assertTrue(expectedSizeOfInvestAIBalanceSheet == actualSizeOfInvestAITransactionSheet);
    }

    @Override
    ResourceConfig getResourceConfig() {
        return new ResourceConfig(RawDataController.class);
    }

//    @Test
//    public void canGETanInvestAIBalanceFundCurrencyValue() throws Exception {
//        //as on D2 field of the csv INVESTAI_BALANCE_BLACKROCK_44128_123114_073015
//        String actualBalanceFundCurrency = "USD";
//
//        WebTarget resource = target.path(RestURIConstants.INVESTAI_BALANCE);
//        Invocation.Builder invocationBuilder = resource.request(MediaType.APPLICATION_JSON);
//        Response response = invocationBuilder.get();
//        response.getStatus();
//        String investAIBalance = null; //response.readEntity(String.class);
//        assertNotNull(investAIBalance);
//
//        ObjectMapper mapper = new ObjectMapper();
//        InvestAIBalance[] investAIBalanceArray = mapper.readValue(investAIBalance, InvestAIBalance[].class);
//
//        String expectedBalanceFundCurrency = investAIBalanceArray[1].getFundCurrency();
//        assertEquals(expectedBalanceFundCurrency, actualBalanceFundCurrency);
//
//        //Number of Rows existing in the csv INVESTAI_BALANCE_BLACKROCK_44128_123114_073015
//        int actualSizeOfInvestAIBalanceSheet = 506;
//        int expectedSizeOfInvestAIBalanceSheet = investAIBalanceArray.length;
//        assertTrue(expectedSizeOfInvestAIBalanceSheet == actualSizeOfInvestAIBalanceSheet);
//
//    }
}
