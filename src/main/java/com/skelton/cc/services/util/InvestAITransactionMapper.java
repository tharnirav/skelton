package com.skelton.cc.services.util;

import com.skelton.cc.domain.InvestAITransaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service("transactionMapper")
public class InvestAITransactionMapper {

    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

    public InvestAITransaction fieldMapping(String[] tokens) throws ParseException {
        InvestAITransaction transaction;

        Date startDate = df.parse(tokens[0]);
        Date endDate = df.parse(tokens[1]);
        Long fundId = Long.parseLong(tokens[2]);
        String fundName = tokens[3];
        Long investmentId = Long.parseLong(tokens[4]);
        String investmentName = tokens[5];
        String investmentType = tokens[6];
        String investmentCurrency = tokens[7];

        Date tradeDate = df.parse(tokens[8]);
        Date settlementDate = df.parse(tokens[9]);
        String action = tokens[10];
        Long units;
        if (tokens[11].equals("")) {
            units = 0L;
        } else {
            units = Long.parseLong(tokens[11]);
        }

        BigDecimal inflow = new BigDecimal(tokens[12]);
        BigDecimal outflow = new BigDecimal(tokens[13]);
        String securityType = tokens[14];
        String assetType = tokens[15];
        String timestamp = tokens[16];

        transaction = new InvestAITransaction(startDate, endDate, fundId, fundName, investmentId, investmentName,
                investmentType, investmentCurrency, tradeDate, settlementDate, action, units, inflow, outflow,
                securityType, assetType, timestamp);
        return transaction;
    }

}
