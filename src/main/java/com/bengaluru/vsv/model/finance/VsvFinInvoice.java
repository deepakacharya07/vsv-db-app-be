package com.bengaluru.vsv.model.finance;

import com.bengaluru.vsv.model.keys.VsvFinInvoiceKey;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "vsv_fin_invoice")
@Data
public class VsvFinInvoice {
    @EmbeddedId
    private VsvFinInvoiceKey id;

    @Column(name = "invoice_date")
    private Date invDate;

    @Column(name = "invoice_year")
    private Integer invoiceYear;

    @Column(name = "manual_no")
    private Integer manualNo;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "cash_amount")
    private Float cshAmt;

    @Column(name = "online_amount")
    private Float onlineAmt;

    @Column(name = "online_refno", length = 25)
    private String onlineRefno;

    @Column(name = "cheque_amount")
    private Float chqAmt;

    @Column(name = "cheque_no")
    private Integer chqno;

    @Column(name = "cheque_date")
    private Date chqDate;

    @Column(name = "card_amount")
    private Float cardAmt;

    @Column(name = "card_no", length = 10)
    private String cardNo;

    @Column(name = "card_slip_no")
    private Integer cardSlipNo;

    @Column(name = "card_bank", length = 25)
    private String cardBank;

    @Column(name = "remarks", length = 200)
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "invoice_cat_type")
    private VsvFinInvoiceCategory invoiceCategory;

    @ManyToOne
    @JoinColumn(name = "invoice_member_id")
    private VsvFinMemberTyp memberTyp;

    @Column(name = "vsv_id")
    private Integer vsvId;

    @Column(name = "event_id")
    private Integer eventId;

    @Column(name = "member_name", length = 150)
    private String memberName;

    @Column(name = "address1", length = 200)
    private String address1;

    @Column(name = "mobileno", length = 45)
    private String mobileno;

    @Column(name = "created_by", length = 45)
    private String crtUsrId;

    @Column(name = "created_date_time")
    private Date crtDateTime;
}
