package id.co.kbbukopin.cde.rencana.model;

import java.math.BigDecimal;
import java.util.Objects;

public class RDOpenAccountExcelModel {

    private String employeeNo;
    private Integer term;
    private String contraAccount;
    private String payawayAccount;
    private Integer installmentDay;
    private BigDecimal firstInstallmentAmount;
    private BigDecimal installmentAmount;
    private String description;
    private String verificationResult;

    public RDOpenAccountExcelModel() {
    }

    public RDOpenAccountExcelModel(String employeeNo, Integer term, String contraAccount, String payawayAccount, Integer installmentDay, BigDecimal firstInstallmentAmount, BigDecimal installmentAmount, String description, String verificationResult) {
        this.employeeNo = employeeNo;
        this.term = term;
        this.contraAccount = contraAccount;
        this.payawayAccount = payawayAccount;
        this.installmentDay = installmentDay;
        this.firstInstallmentAmount = firstInstallmentAmount;
        this.installmentAmount = installmentAmount;
        this.description = description;
        this.verificationResult = verificationResult;
    }
    
    private RDOpenAccountExcelModel(Builder builder) {
        this.employeeNo = builder.employeeNo;
        this.term = builder.term;
        this.contraAccount = builder.contraAccount;
        this.payawayAccount = builder.payawayAccount;
        this.installmentDay = builder.installmentDay;
        this.firstInstallmentAmount = builder.firstInstallmentAmount;
        this.installmentAmount = builder.installmentAmount;
        this.description = builder.description;
        this.verificationResult = builder.verificationResult;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {

        private String employeeNo;
        private Integer term;
        private String contraAccount;
        private String payawayAccount;
        private Integer installmentDay;
        private BigDecimal firstInstallmentAmount;
        private BigDecimal installmentAmount;
        private String description;
        private String verificationResult;

        public Builder employeeNo(String employeeNo) {
            this.employeeNo = employeeNo;
            return this;
        }

        public Builder term(Integer term) {
            this.term = term;
            return this;
        }

        public Builder contraAccount(String contraAccount) {
            this.contraAccount = contraAccount;
            return this;
        }

        public Builder payawayAccount(String payawayAccount) {
            this.payawayAccount = payawayAccount;
            return this;
        }

        public Builder installmentDay(Integer installmentDay) {
            this.installmentDay = installmentDay;
            return this;
        }

        public Builder firstInstallmentAmount(BigDecimal firstInstallmentAmount) {
            this.firstInstallmentAmount = firstInstallmentAmount;
            return this;
        }

        public Builder installmentAmount(BigDecimal installmentAmount) {
            this.installmentAmount = installmentAmount;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder verificationResult(String verificationResult) {
            this.verificationResult = verificationResult;
            return this;
        }

        public RDOpenAccountExcelModel build() {
            return new RDOpenAccountExcelModel(this);
        }
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getContraAccount() {
        return contraAccount;
    }

    public void setContraAccount(String contraAccount) {
        this.contraAccount = contraAccount;
    }

    public String getPayawayAccount() {
        return payawayAccount;
    }

    public void setPayawayAccount(String payawayAccount) {
        this.payawayAccount = payawayAccount;
    }

    public Integer getInstallmentDay() {
        return installmentDay;
    }

    public void setInstallmentDay(Integer installmentDay) {
        this.installmentDay = installmentDay;
    }

    public BigDecimal getFirstInstallmentAmount() {
        return firstInstallmentAmount;
    }

    public void setFirstInstallmentAmount(BigDecimal firstInstallmentAmount) {
        this.firstInstallmentAmount = firstInstallmentAmount;
    }

    public BigDecimal getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(BigDecimal installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVerificationResult() {
        return verificationResult;
    }

    public void setVerificationResult(String verificationResult) {
        this.verificationResult = verificationResult;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RDOpenAccountExcelModel that = (RDOpenAccountExcelModel) o;
        return Objects.equals(employeeNo, that.employeeNo) && Objects.equals(term, that.term) && Objects.equals(contraAccount, that.contraAccount) && Objects.equals(payawayAccount, that.payawayAccount) && Objects.equals(installmentDay, that.installmentDay) && Objects.equals(firstInstallmentAmount, that.firstInstallmentAmount) && Objects.equals(installmentAmount, that.installmentAmount) && Objects.equals(description, that.description) && Objects.equals(verificationResult, that.verificationResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNo, term, contraAccount, payawayAccount, installmentDay, firstInstallmentAmount, installmentAmount, description, verificationResult);
    }

    @Override
    public String toString() {
        return "RDOpenAccountExcelModel{" +
                "employeeNo='" + employeeNo + '\'' +
                ", term=" + term +
                ", contraAccount='" + contraAccount + '\'' +
                ", payawayAccount='" + payawayAccount + '\'' +
                ", installmentDay=" + installmentDay +
                ", firstInstallmentAmount=" + firstInstallmentAmount +
                ", installmentAmount=" + installmentAmount +
                ", description='" + description + '\'' +
                ", verificationResult='" + verificationResult + '\'' +
                '}';
    }
}
