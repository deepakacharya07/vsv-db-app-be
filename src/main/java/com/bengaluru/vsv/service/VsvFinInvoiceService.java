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

        dto.setInvoiceTyp(invoice.getId().getInvoiceType());
        dto.setInvoiceTag(invoice.getId().getInvoiceTag());
        dto.setInvDocNO(invoice.getId().getInvoiceDocNo());
        dto.setInvoiceDate(invoice.getInvDate());
        dto.setAmount(invoice.getAmount());
        dto.setMemberName(invoice.getMemberName());
        dto.setMobileNo(invoice.getMobileno());
        dto.setRemarks(invoice.getRemarks());
        dto.setVsvId(invoice.getVsvId());

        // Safely set optional related entity fields
        if (invoice.getInvoiceCategory() != null) {
            dto.setInvCatTypDesc(invoice.getInvoiceCategory().getInvCatTypDesc());
        }

        if (invoice.getMemberTyp() != null) {
            dto.setMemberType(invoice.getMemberTyp().getMemberDescription());
        }

        return dto;
    }
}
