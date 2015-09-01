package com.skelton.cc.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skelton.cc.domain.InvestAIBalance;
import com.skelton.cc.domain.InvestAITransaction;
import com.skelton.cc.services.FileReaderService;
import com.skelton.cc.services.InvestAIBalanceService;
import com.skelton.cc.services.InvestAITransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

/**
 * Handles requests for the application home page.
 */
@Component
@Path("/rawData")
public class RawDataController {

    private static final Logger logger = LoggerFactory.getLogger(RawDataController.class);

    @Autowired
    FileReaderService fraService;

    @Autowired
    private InvestAITransactionService investAITransactionService;

    @Autowired
    private InvestAIBalanceService investAIBalanceService;

    private final ObjectMapper mapper = new ObjectMapper();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(RestURIConstants.INVESTAI_TRANSACTION)
    public Response getInvestAITransactionList() {


        boolean result = investAITransactionService.insertData();

        List<InvestAITransaction> transactionList = null;
        transactionList = investAITransactionService.readData();

        String transactionJsonObject = null;
        try {
            transactionJsonObject = mapper.writeValueAsString(transactionList);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return Response.status(200).entity(transactionJsonObject).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(RestURIConstants.INVESTAI_BALANCE)
    public Response getInvestAIBalanceList() {

        investAIBalanceService.insertData();

        List<InvestAIBalance> balanceList = null;
        balanceList = investAIBalanceService.readData();

        String balanceJsonObject = null;
        try {
            balanceJsonObject = mapper.writeValueAsString(balanceList);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return Response.status(200).entity(balanceJsonObject).build();

    }

}
