package com.bengaluru.vsv.model.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VsvFinInvoiceTypKey implements Serializable {

    @Column(name = "invoice_type", length = 3)
    private String invoiceTyp;

    @Column(name = "invoice_tag")
    private Integer invoiceTag;
}
