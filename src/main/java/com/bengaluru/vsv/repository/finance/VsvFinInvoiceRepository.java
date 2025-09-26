package com.bengaluru.vsv.repository.finance;

import com.bengaluru.vsv.model.finance.VsvFinInvoice;
import com.bengaluru.vsv.model.keys.VsvFinInvoiceKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VsvFinInvoiceRepository extends JpaRepository<VsvFinInvoice, VsvFinInvoiceKey> {
    List<VsvFinInvoice> findByVsvId(Integer vsvId);
    @Query("SELECT vfi FROM VsvFinInvoice vfi " +
            "JOIN vfi.invoiceCategory vfc " +
            "JOIN vfi.memberTyp vfm " +
            "JOIN VsvFinInvoiceTyp vft ON vft.id.invoiceTyp = vfi.id.invoiceType AND vft.id.invoiceTag = vfi.id.invoiceTag " +
            "WHERE vfi.vsvId = :vsvId")
    List<VsvFinInvoice> findInvoicesWithCategoriesAndTypes(@Param("vsvId") Integer vsvId);
}
