package com.claro.itec.xpapi.converter;

import com.claro.itec.xpapi.dto.AgentDTO;
import com.claro.itec.xpapi.dto.response.AgentRsDTO;
import com.claro.itec.xpapi.sto.AgentSTO;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.util.Converter;

@Component
public class AgentRsConvert  implements Converter<AgentSTO, AgentRsDTO> {


    @Override
    public AgentRsDTO convert(AgentSTO value) {
        AgentRsDTO agentRsDTO = new AgentRsDTO();
        agentRsDTO.setId(value.getId());
        agentRsDTO.setAgentNumber(value.getAgentNumber());
        agentRsDTO.setBusinessName(value.getBusinessName());
        agentRsDTO.setFullName(value.getName()+value.getSurname());
        agentRsDTO.setFullphoneNumber(value.getCharacteristic()+value.getPhoneNumber());
        agentRsDTO.setPhoneType(value.getPhoneType());
        agentRsDTO.setAddressNumber(value.getAddressNumber());
        agentRsDTO.setCity(value.getCity());
        agentRsDTO.setCountry(value.getCountry());
        agentRsDTO.setEmail(value.getEmail());
        agentRsDTO.setLocation(value.getLocation());
        agentRsDTO.setPostalCode(value.getPostalCode());
        agentRsDTO.setProvince(value.getProvince());
        agentRsDTO.setStreet(value.getStreet());
        return agentRsDTO;
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return null;
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return null;
    }


}
