package com.bengaluru.vsv.service;

import com.bengaluru.vsv.dto.finance.VsvFinInvoiceDto;
import com.bengaluru.vsv.model.finance.VsvFinInvoice;
import com.bengaluru.vsv.repository.finance.VsvFinInvoiceRepository;
import com.bengaluru.vsv.utils.mapper.VsvFinInvoiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VsvFinInvoiceService {
    private final VsvFinInvoiceRepository invoiceRepository;
    private final VsvFinInvoiceMapper invoiceMapper;

    /**
     * Fetch all invoices and convert them to DTOs
     */
    public List<VsvFinInvoiceDto> getAllInvoices() {
        List<VsvFinInvoice> invoices = invoiceRepository.findAll();

        return invoices.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<VsvFinInvoiceDto> getInvoicesByVsvId(Integer vsvId) {
        List<VsvFinInvoice> invoices = invoiceRepository.findByVsvId(vsvId);

        return invoices.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Method to fetch and map the data from the repository
    public List<VsvFinInvoiceDto> getDetailedInvoicesByVsvId(Integer vsvId) {
        // Fetching the invoices along with their related entities using the custom query
        List<VsvFinInvoice> invoices = invoiceRepository.findInvoicesWithCategoriesAndTypes(vsvId);

        // Mapping the fetched entities to DTOs
        return invoices.stream()
                .map(invoiceMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Entity → DTO conversion
     */
    private VsvFinInvoiceDto convertToDTO(VsvFinInvoice invoice) {
        VsvFinInvoiceDto dto = new VsvFinInvoiceDto();

        String invoiceType = invoice.getId().getInvoiceType();
        if(invoiceType.equalsIgnoreCase("PM")) {
            dto.setInvoiceType("Payments");
        } else {
            dto.setInvoiceType("Receipts");
        }
        dto.setInvoiceTag(invoice.getId().getInvoiceTag());
        dto.setInvoiceDocNo(invoice.getId().getInvoiceDocNo());
        dto.setManualDocNumber(invoice.getManualNo());
        dto.setInvoiceYear(invoice.getInvoiceYear());
        dto.setInvoiceDate(invoice.getInvoiceDate());
        dto.setAmount(invoice.getAmount());
        dto.setMemberName(invoice.getMemberName());
        dto.setMobileNo(invoice.getMobileno());
        dto.setRemarks(invoice.getRemarks());
        dto.setVsvId(invoice.getVsvId());
        dto.setCashAmount(invoice.getCashAmount());
        dto.setOnlineAmount(invoice.getOnlineAmount());
        dto.setChequeAmount(invoice.getChequeAmount());
        dto.setCardAmount(invoice.getCardAmount());
        dto.setChequeDate(invoice.getChequeDate());
        dto.calculateAndSetPaymentMethod();

        // Safely set optional related entity fields
        if (invoice.getInvoiceCategory() != null) {
            dto.setInvoiceCategoryTypeDesc(invoice.getInvoiceCategory().getInvCatTypDesc());
        }

        if (invoice.getMemberTyp() != null) {
            dto.setMemberType(invoice.getMemberTyp().getMemberDescription());
        }

        return dto;
    }
}
