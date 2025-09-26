package com.bengaluru.vsv.model.finance;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vsv_fin_invoice_category")
@Data
public class VsvFinInvoiceCategory {
    @Id
    @Column(name = "invoice_cat_type")
    private Integer invCatTyp;

    @Column(name = "invoice_cat_type_desc", length = 50)
    private String invCatTypDesc;

    @Column(name = "invoice_cat_main_head", length = 5)
    private String invCatMainHead;
}
