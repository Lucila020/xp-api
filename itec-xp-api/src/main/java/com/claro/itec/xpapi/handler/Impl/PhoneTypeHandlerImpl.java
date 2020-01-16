package com.claro.itec.xpapi.handler.Impl;

import com.claro.itec.xpapi.dto.PhoneTypeDTO;
import com.claro.itec.xpapi.handler.PhoneTypeHandler;
import com.claro.itec.xpapi.integration.client.AgentClient;


import com.claro.itec.xpapi.sto.PhoneTypeSTO;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

public class PhoneTypeHandlerImpl  implements PhoneTypeHandler {

    private static final Logger LOGGER = Logger.getLogger(PhoneTypeHandlerImpl.class);
    private AgentClient phoneTypeService;
    private Converter<PhoneTypeSTO,PhoneTypeDTO> phoneTypeConverter;

    @Autowired
    public PhoneTypeHandlerImpl(AgentClient phoneTypeService, Converter<PhoneTypeSTO, PhoneTypeDTO> phoneTypeConverter) {
        this.phoneTypeService = phoneTypeService;
        this.phoneTypeConverter = phoneTypeConverter;
    }

    @Override
    public List<PhoneTypeDTO> retrieveListPhoneTypes() {
        LOGGER.info("Listing Phone Type");
        List<PhoneTypeDTO> listDTO = phoneTypeService.retrieveListPhoneTypes().stream().map(value -> this.phoneTypeConverter.convert(value)).collect(Collectors.toList());
        return listDTO;

    }
}
