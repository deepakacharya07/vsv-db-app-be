package com.bengaluru.vsv.utils.mapper;

import com.bengaluru.vsv.dto.finance.VsvFinInvoiceDto;
import com.bengaluru.vsv.model.finance.VsvFinInvoice;
import org.springframework.stereotype.Component;

@Component
public class VsvFinInvoiceMapper {

    public VsvFinInvoiceDto mapToDTO(VsvFinInvoice vsvFinInvoice) {
        VsvFinInvoiceDto dto = new VsvFinInvoiceDto();
        
        dto.setInvoiceDate(vsvFinInvoice.getInvDate());
        dto.setInvoiceYear(vsvFinInvoice.getInvoiceYear());
        dto.setAmount(vsvFinInvoice.getAmount());
        dto.setMemberName(vsvFinInvoice.getMemberName());
        
        // Accessing associated entities
        dto.setInvCatTypDesc(vsvFinInvoice.getInvoiceCategory().getInvCatTypDesc());
        dto.setInvTypeDesc(vsvFinInvoice.getId().getInvoiceType());

        return dto;
    }
}
