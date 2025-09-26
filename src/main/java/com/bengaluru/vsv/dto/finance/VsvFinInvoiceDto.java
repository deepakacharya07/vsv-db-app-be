package com.bengaluru.vsv.dto.finance;

import lombok.Data;

import java.util.Date;

@Data
public class VsvFinInvoiceDto {
    private String invoiceTyp;
    private Integer invoiceTag;
    private Integer invDocNO;
    private Date invoiceDate;
    private Integer invoiceYear;
    private String invCatTypDesc;
    private String memberDescription;
    private Float amount;
    private Integer vsvId;
    private String memberName;
    private String mobileNo;
    private String remarks;
    private String memberType;
    private String invTypeDesc;
}
