package com.skelton.cc.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class InvestAITransaction {

    private Date startDate;
    private Date endDate;
    @Id
    //@GeneratedValue
    private long fundId;
    private String fundName;
    private long investmentId;
    private String investmentName;
    private String investmentType;
    private String investmentCurrency;
    private Date tradeDate;
    private Date settlementDate;
    private String action;
    private long units;
    private BigDecimal inflow;
    private BigDecimal outflow;
    private String securityType;
    private String assetType;
    private String timestamp;

    @SuppressWarnings("unused")
    private InvestAITransaction() {

    }


    public InvestAITransaction(Date startDate, Date endDate, long fundId, String fundName, long investmentId,
                               String investmentName, String investmentType, String investmentCurrency, Date tradeDate,
                               Date settlementDate, String action, long units, BigDecimal inflow, BigDecimal outflow, String securityType,
                               String assetType, String timestamp) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.fundId = fundId;
        this.fundName = fundName;
        this.investmentId = investmentId;
        this.investmentName = investmentName;
        this.investmentType = investmentType;
        this.investmentCurrency = investmentCurrency;
        this.tradeDate = tradeDate;
        this.settlementDate = settlementDate;
        this.action = action;
        this.units = units;
        this.inflow = inflow;
        this.outflow = outflow;
        this.securityType = securityType;
        this.assetType = assetType;
        this.timestamp = timestamp;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public long getFundId() {
        return fundId;
    }

    public String getFundName() {
        return fundName;
    }

    public long getInvestmentId() {
        return investmentId;
    }

    public String getInvestmentName() {
        return investmentName;
    }

    public String getInvestmentType() {
        return investmentType;
    }

    public String getInvestmentCurrency() {
        return investmentCurrency;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public String getAction() {
        return action;
    }

    public long getUnits() {
        return units;
    }

    public BigDecimal getInflow() {
        return inflow;
    }

    public BigDecimal getOutflow() {
        return outflow;
    }

    public String getSecurityType() {
        return securityType;
    }

    public String getAssetType() {
        return assetType;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvestAITransaction that = (InvestAITransaction) o;

        if (fundId != that.fundId) return false;
        if (investmentId != that.investmentId) return false;
        if (units != that.units) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (fundName != null ? !fundName.equals(that.fundName) : that.fundName != null) return false;
        if (investmentName != null ? !investmentName.equals(that.investmentName) : that.investmentName != null)
            return false;
        if (investmentType != null ? !investmentType.equals(that.investmentType) : that.investmentType != null)
            return false;
        if (investmentCurrency != null ? !investmentCurrency.equals(that.investmentCurrency) : that.investmentCurrency != null)
            return false;
        if (tradeDate != null ? !tradeDate.equals(that.tradeDate) : that.tradeDate != null) return false;
        if (settlementDate != null ? !settlementDate.equals(that.settlementDate) : that.settlementDate != null)
            return false;
        if (action != null ? !action.equals(that.action) : that.action != null) return false;
        if (inflow != null ? !inflow.equals(that.inflow) : that.inflow != null) return false;
        if (outflow != null ? !outflow.equals(that.outflow) : that.outflow != null) return false;
        if (securityType != null ? !securityType.equals(that.securityType) : that.securityType != null) return false;
        if (assetType != null ? !assetType.equals(that.assetType) : that.assetType != null) return false;
        return !(timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null);

    }

    @Override
    public int hashCode() {
        int result = startDate != null ? startDate.hashCode() : 0;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (int) (fundId ^ (fundId >>> 32));
        result = 31 * result + (fundName != null ? fundName.hashCode() : 0);
        result = 31 * result + (int) (investmentId ^ (investmentId >>> 32));
        result = 31 * result + (investmentName != null ? investmentName.hashCode() : 0);
        result = 31 * result + (investmentType != null ? investmentType.hashCode() : 0);
        result = 31 * result + (investmentCurrency != null ? investmentCurrency.hashCode() : 0);
        result = 31 * result + (tradeDate != null ? tradeDate.hashCode() : 0);
        result = 31 * result + (settlementDate != null ? settlementDate.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (int) (units ^ (units >>> 32));
        result = 31 * result + (inflow != null ? inflow.hashCode() : 0);
        result = 31 * result + (outflow != null ? outflow.hashCode() : 0);
        result = 31 * result + (securityType != null ? securityType.hashCode() : 0);
        result = 31 * result + (assetType != null ? assetType.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InvestAITransaction{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", fundId=" + fundId +
                ", fundName='" + fundName + '\'' +
                ", investmentId=" + investmentId +
                ", investmentName='" + investmentName + '\'' +
                ", investmentType='" + investmentType + '\'' +
                ", investmentCurrency='" + investmentCurrency + '\'' +
                ", tradeDate=" + tradeDate +
                ", settlementDate=" + settlementDate +
                ", action='" + action + '\'' +
                ", units=" + units +
                ", inflow=" + inflow +
                ", outflow=" + outflow +
                ", securityType='" + securityType + '\'' +
                ", assetType='" + assetType + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
