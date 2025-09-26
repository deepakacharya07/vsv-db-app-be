package com.bengaluru.vsv.model.finance;

import com.bengaluru.vsv.model.keys.VsvFinInvoiceTypKey;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vsv_fin_invoice_typ")
@Data
public class VsvFinInvoiceTyp {
    @EmbeddedId
    private VsvFinInvoiceTypKey id;

    @Column(name = "invoice_type_desc", length = 45)
    private String invoiceTypDesc;
}
