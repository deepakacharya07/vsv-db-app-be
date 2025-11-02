package com.bengaluru.vsv.utils.mapper;

import com.bengaluru.vsv.dto.finance.VsvFinInvoiceDto;
import com.bengaluru.vsv.model.finance.VsvFinInvoice;
import org.springframework.stereotype.Component;

@Component
public class VsvFinInvoiceMapper {

    public VsvFinInvoiceDto mapToDTO(VsvFinInvoice vsvFinInvoice) {
        VsvFinInvoiceDto dto = new VsvFinInvoiceDto();
        
        dto.setInvoiceDate(vsvFinInvoice.getInvoiceDate());
        dto.setInvoiceYear(vsvFinInvoice.getInvoiceYear());
        dto.setAmount(vsvFinInvoice.getAmount());
        dto.setMemberName(vsvFinInvoice.getMemberName());
        
        // Accessing associated entities
        dto.setInvoiceCategoryTypeDesc(vsvFinInvoice.getInvoiceCategory().getInvCatTypDesc());
        dto.setInvoiceTypeDesc(vsvFinInvoice.getId().getInvoiceType());

        return dto;
    }
}
