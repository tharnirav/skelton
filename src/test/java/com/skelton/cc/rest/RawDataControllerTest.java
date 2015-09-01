package com.skelton.cc.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skelton.cc.domain.InvestAIBalance;
import com.skelton.cc.domain.InvestAITransaction;
import com.skelton.cc.services.FileReaderService;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.*;

public class RawDataControllerTest {
    private static Client client;
    private WebTarget target;
    private MockMvc mockMvc;

    @InjectMocks
    private RawDataController controller;

    @Mock
    private FileReaderService service;




    @BeforeClass
    public static void Before() {
        RawDataControllerTest.client = ClientBuilder.newClient();
    }

    @AfterClass
    public static void After() {
        client.close();
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        target = client.target("http://localhost:8080/fra-cnc/api/rawData");
    }

    @Test
    public void canGETanInvestAITransactionFundNameValue() throws Exception {

        //as on D3 field of the csv INVESTAI_TRANSACTION_BLACKROCK_44128_123114_073015
        String actualTransactionFundName = "Test Fund1";
        WebTarget resource = target.path(RestURIConstants.INVESTAI_TRANSACTION);
        Invocation.Builder invocationBuilder = resource.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        String investAITransaction = null; //= response.readEntity(String.class);
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

    @Test
    public void canGETanInvestAIBalanceFundCurrencyValue() throws Exception {
        //as on D2 field of the csv INVESTAI_BALANCE_BLACKROCK_44128_123114_073015
        String actualBalanceFundCurrency = "USD";

        WebTarget resource = target.path(RestURIConstants.INVESTAI_BALANCE);
        Invocation.Builder invocationBuilder = resource.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        response.getStatus();
        String investAIBalance = null; //response.readEntity(String.class);
        assertNotNull(investAIBalance);

        ObjectMapper mapper = new ObjectMapper();
        InvestAIBalance[] investAIBalanceArray = mapper.readValue(investAIBalance, InvestAIBalance[].class);

        String expectedBalanceFundCurrency = investAIBalanceArray[1].getFundCurrency();
        assertEquals(expectedBalanceFundCurrency, actualBalanceFundCurrency);

        //Number of Rows existing in the csv INVESTAI_BALANCE_BLACKROCK_44128_123114_073015
        int actualSizeOfInvestAIBalanceSheet = 506;
        int expectedSizeOfInvestAIBalanceSheet = investAIBalanceArray.length;
        assertTrue(expectedSizeOfInvestAIBalanceSheet == actualSizeOfInvestAIBalanceSheet);

    }
}
