package com.bengaluru.vsv.repository.finance;

import com.bengaluru.vsv.model.finance.VsvFinInvoiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VsvFinInvoiceCategoryRepository extends JpaRepository<VsvFinInvoiceCategory, Integer> {
}
