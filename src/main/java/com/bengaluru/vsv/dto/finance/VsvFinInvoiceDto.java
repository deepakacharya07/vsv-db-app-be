package com.bengaluru.vsv.dto.finance;

import lombok.Data;

import java.util.Date;

@Data
public class VsvFinInvoiceDto {
    private String invoiceType;
    private Integer invoiceTag;
    private Integer invoiceDocNo;
    private Date invoiceDate;
    private Integer invoiceYear;
    private Integer manualDocNumber;
    private String invoiceCategoryTypeDesc;
    private String memberDescription;
    private Float amount;
    private Integer vsvId;
    private String memberName;
    private String mobileNo;
    private String remarks;
    private String memberType;
    private String invoiceTypeDesc;
    private Float cashAmount;
    private Float onlineAmount;
    private Float chequeAmount;
    private Integer chequeNumber;
    private Date chequeDate;
    private Float cardAmount;
    private String paymentMethod;

    public void calculateAndSetPaymentMethod() {
        int nonZeroCount = 0;
        String method = null;

        if (isValidAmount(cashAmount)) {
            nonZeroCount++;
            method = "CASH";
        }
        if (isValidAmount(onlineAmount)) {
            nonZeroCount++;
            method = (nonZeroCount > 1) ? "MIXED" : "ONLINE";
        }
        if (isValidAmount(chequeAmount)) {
            nonZeroCount++;
            method = (nonZeroCount > 1) ? "MIXED" : "CHEQUE";
        }
        if (isValidAmount(cardAmount)) {
            nonZeroCount++;
            method = (nonZeroCount > 1) ? "MIXED" : "CARD";
        }

        if (nonZeroCount == 0) {
            method = "NONE";
        }
        this.paymentMethod = method;
    }
    private boolean isValidAmount(Float value) {
        return value != null && value != 0.0f;
    }

}
