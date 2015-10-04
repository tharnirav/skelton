package com.skelton.cc.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InvestAIBalance {

    private String startDate;
    private String endDate;
    @Id
    //@GeneratedValue
    private String fundID;
    private String fundName;
    private String fundCurrency;
    private String categoryType;
    private String accountNumber;
    private String accountSegment_1;
    private String accountSegment_2;
    private String accountName;
    private String openingBalance;
    private String debit;
    private String credit;
    private String closingBalance;
    private String createTimeStamp;
    private String processStatusCode;
    private String sourceSystemName;
    private String processType;


    @SuppressWarnings("unused")
    public InvestAIBalance() {

    }


    public InvestAIBalance(String startDate, String endDate, String fundID, String fundName, String fundCurrency,
                           String categoryType, String accountNumber, String accountSegment_1, String accountSegment_2, String accountName,
                           String openingBalance, String dR, String cR, String closingBalance, String createTimeStamp,
                           String processStatusCode, String sourceSystemName, String processType) {

        this.startDate = startDate;
        this.endDate = endDate;
        this.fundID = fundID;
        this.fundName = fundName;
        this.fundCurrency = fundCurrency;
        this.categoryType = categoryType;
        this.accountNumber = accountNumber;
        this.accountSegment_1 = accountSegment_1;
        this.accountSegment_2 = accountSegment_2;
        this.accountName = accountName;
        this.openingBalance = openingBalance;
        this.debit = dR;
        this.credit = cR;
        this.closingBalance = closingBalance;
        this.createTimeStamp = createTimeStamp;
        this.processStatusCode = processStatusCode;
        this.sourceSystemName = sourceSystemName;
        this.processType = processType;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getFundID() {
        return fundID;
    }

    public String getFundName() {
        return fundName;
    }

    public String getFundCurrency() {
        return fundCurrency;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountSegment_1() {
        return accountSegment_1;
    }

    public String getAccountSegment_2() {
        return accountSegment_2;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getOpeningBalance() {
        return openingBalance;
    }

    public String getDebit() {
        return debit;
    }

    public String getCredit() {
        return credit;
    }

    public String getClosingBalance() {
        return closingBalance;
    }

    public String getCreateTimeStamp() {
        return createTimeStamp;
    }

    public String getProcessStatusCode() {
        return processStatusCode;
    }

    public String getSourceSystemName() {
        return sourceSystemName;
    }

    public String getProcessType() {
        return processType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvestAIBalance that = (InvestAIBalance) o;

        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (fundID != null ? !fundID.equals(that.fundID) : that.fundID != null) return false;
        if (fundName != null ? !fundName.equals(that.fundName) : that.fundName != null) return false;
        if (fundCurrency != null ? !fundCurrency.equals(that.fundCurrency) : that.fundCurrency != null) return false;
        if (categoryType != null ? !categoryType.equals(that.categoryType) : that.categoryType != null) return false;
        if (accountNumber != null ? !accountNumber.equals(that.accountNumber) : that.accountNumber != null)
            return false;
        if (accountSegment_1 != null ? !accountSegment_1.equals(that.accountSegment_1) : that.accountSegment_1 != null)
            return false;
        if (accountSegment_2 != null ? !accountSegment_2.equals(that.accountSegment_2) : that.accountSegment_2 != null)
            return false;
        if (accountName != null ? !accountName.equals(that.accountName) : that.accountName != null) return false;
        if (openingBalance != null ? !openingBalance.equals(that.openingBalance) : that.openingBalance != null)
            return false;
        if (debit != null ? !debit.equals(that.debit) : that.debit != null) return false;
        if (credit != null ? !credit.equals(that.credit) : that.credit != null) return false;
        if (closingBalance != null ? !closingBalance.equals(that.closingBalance) : that.closingBalance != null)
            return false;
        if (createTimeStamp != null ? !createTimeStamp.equals(that.createTimeStamp) : that.createTimeStamp != null)
            return false;
        if (processStatusCode != null ? !processStatusCode.equals(that.processStatusCode) : that.processStatusCode != null)
            return false;
        if (sourceSystemName != null ? !sourceSystemName.equals(that.sourceSystemName) : that.sourceSystemName != null)
            return false;
        return !(processType != null ? !processType.equals(that.processType) : that.processType != null);

    }

    @Override
    public int hashCode() {
        int result = startDate != null ? startDate.hashCode() : 0;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (fundID != null ? fundID.hashCode() : 0);
        result = 31 * result + (fundName != null ? fundName.hashCode() : 0);
        result = 31 * result + (fundCurrency != null ? fundCurrency.hashCode() : 0);
        result = 31 * result + (categoryType != null ? categoryType.hashCode() : 0);
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        result = 31 * result + (accountSegment_1 != null ? accountSegment_1.hashCode() : 0);
        result = 31 * result + (accountSegment_2 != null ? accountSegment_2.hashCode() : 0);
        result = 31 * result + (accountName != null ? accountName.hashCode() : 0);
        result = 31 * result + (openingBalance != null ? openingBalance.hashCode() : 0);
        result = 31 * result + (debit != null ? debit.hashCode() : 0);
        result = 31 * result + (credit != null ? credit.hashCode() : 0);
        result = 31 * result + (closingBalance != null ? closingBalance.hashCode() : 0);
        result = 31 * result + (createTimeStamp != null ? createTimeStamp.hashCode() : 0);
        result = 31 * result + (processStatusCode != null ? processStatusCode.hashCode() : 0);
        result = 31 * result + (sourceSystemName != null ? sourceSystemName.hashCode() : 0);
        result = 31 * result + (processType != null ? processType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InvestAIBalance{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", fundID='" + fundID + '\'' +
                ", fundName='" + fundName + '\'' +
                ", fundCurrency='" + fundCurrency + '\'' +
                ", categoryType='" + categoryType + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountSegment_1='" + accountSegment_1 + '\'' +
                ", accountSegment_2='" + accountSegment_2 + '\'' +
                ", accountName='" + accountName + '\'' +
                ", openingBalance='" + openingBalance + '\'' +
                ", debit='" + debit + '\'' +
                ", credit='" + credit + '\'' +
                ", closingBalance='" + closingBalance + '\'' +
                ", createTimeStamp='" + createTimeStamp + '\'' +
                ", processStatusCode='" + processStatusCode + '\'' +
                ", sourceSystemName='" + sourceSystemName + '\'' +
                ", processType='" + processType + '\'' +
                '}';
    }
}
