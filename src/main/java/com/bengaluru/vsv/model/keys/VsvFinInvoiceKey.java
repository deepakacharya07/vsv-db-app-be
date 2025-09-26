package com.bengaluru.vsv.model.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VsvFinInvoiceKey implements Serializable {

    @Column(name = "invoice_type")
    private String invoiceType;

    @Column(name = "invoice_tag")
    private Integer invoiceTag;

    @Column(name = "invoice_doc_no")
    private Integer invoiceDocNo;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VsvFinInvoiceKey that = (VsvFinInvoiceKey) o;
        return Objects.equals(invoiceType, that.invoiceType) &&
               Objects.equals(invoiceTag, that.invoiceTag) &&
               Objects.equals(invoiceDocNo, that.invoiceDocNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceType, invoiceTag, invoiceDocNo);
    }
}
