package com.bengaluru.vsv.controller;

import com.bengaluru.vsv.dto.finance.VsvFinInvoiceDto;
import com.bengaluru.vsv.model.finance.VsvFinInvoice;
import com.bengaluru.vsv.service.VsvFinInvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vsv-finance-details")
@RequiredArgsConstructor
public class VsvFinInvoiceController {
    private final VsvFinInvoiceService invoiceService;
    @GetMapping
    public ResponseEntity<List<VsvFinInvoiceDto>> getAllInvoices() {
        List<VsvFinInvoiceDto> invoices = invoiceService.getAllInvoices();
        return ResponseEntity.ok(invoices);
    }

    @GetMapping("/{vsvId}")
    public ResponseEntity<List<VsvFinInvoiceDto>> getInvoicesByVsvId(@PathVariable Integer vsvId) {
        List<VsvFinInvoiceDto> invoices = invoiceService.getInvoicesByVsvId(vsvId);
        return ResponseEntity.ok(invoices);
    }

    @GetMapping("/invoice/{vsvId}")
    public List<VsvFinInvoiceDto> getInvoices(@PathVariable Integer vsvId) {
        return invoiceService.getDetailedInvoicesByVsvId(vsvId);
    }
}
