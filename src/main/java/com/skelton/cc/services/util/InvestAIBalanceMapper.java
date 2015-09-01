package com.skelton.cc.services.util;

import com.skelton.cc.domain.InvestAIBalance;
import org.springframework.stereotype.Service;

@Service("balanceMapper")
public class InvestAIBalanceMapper {

    public InvestAIBalance fieldMapping(String[] token) {

        InvestAIBalance balance;

        String startDate = token[0];
        String endDate = token[1];
        String fundID = token[2];
        String fundName = token[3];
        String fundCurrency = token[4];
        String categorytype = token[5];
        String accountNumber = token[6];
        String accountSegment_1 = token[7];
        String accountSegment_2 = token[8];
        String accountName = token[9];
        String openingBalance = token[10];
        String dR = token[11];
        String cR = token[12];
        String closingBalance = token[12];
        String createTimeStamp = token[13];
        String processStatusCode = token[14];
        String sourceSystemName = token[15];
        String processType = token[16];

        balance = new InvestAIBalance(startDate, endDate, fundID, fundName, fundCurrency, categorytype,
                accountNumber, accountSegment_1, accountSegment_2, accountName, openingBalance, dR, cR, closingBalance,
                createTimeStamp, processStatusCode, sourceSystemName, processType);
        return balance;
    }

}
