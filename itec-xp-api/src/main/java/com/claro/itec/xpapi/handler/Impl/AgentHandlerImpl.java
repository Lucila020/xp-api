package com.claro.itec.xpapi.handler.Impl;

import com.claro.itec.xpapi.converter.AgentRsConvert;
import com.claro.itec.xpapi.dto.AgentDTO;
import com.claro.itec.xpapi.dto.response.AgentRsDTO;
import com.claro.itec.xpapi.handler.AgentHandler;
import com.claro.itec.xpapi.integration.client.AgentClient;
import com.claro.itec.xpapi.sto.AgentSTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.core.convert.converter.Converter;
import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

@Service
public class AgentHandlerImpl implements AgentHandler {

    private static final Logger LOGGER = Logger.getLogger(AgentHandlerImpl.class);
     private AgentClient agentService;
     private AgentRsConvert agentConvert;
     private Converter<AgentDTO,AgentSTO> agentToServiceConvert;
     private Converter<AgentSTO, AgentDTO> agentDTOConvert;

     @Autowired
    public AgentHandlerImpl(AgentClient agentService, AgentRsConvert agentConvert, Converter<AgentDTO, AgentSTO> agentToServiceConvert, Converter<AgentSTO, AgentDTO> agentDTOConvert) {
        this.agentService = agentService;
        this.agentConvert = agentConvert;
        this.agentToServiceConvert = agentToServiceConvert;
        this.agentDTOConvert = agentDTOConvert;
    }

    /**
     *
     * @return List<AgentDTO></AgentDTO>
     */
    @Override
    public List<AgentRsDTO> retrieveListAgents() {
        LOGGER.info("Listing  Agents");

      final List<AgentRsDTO> listDTO = agentService.retrieveListAgents().stream().map(value -> this.agentConvert.convert(value)).collect(Collectors.toList());
      if(listDTO.isEmpty()){
          LOGGER.error("La lista está vacía");
      }
        return listDTO;
    }

    /**
     *
     * @param agentDTO
     * @return the new AgentDTO
     */
    @Override
    public AgentDTO createAgent(AgentDTO agentDTO) {
        final AgentDTO agentDTO1 =  agentDTOConvert.convert(agentService.createAgent(agentToServiceConvert.convert(agentDTO)));
        LOGGER.info("Creating  Agents");
        return  agentDTO1;
    }

    /**
     *
     * @param agentDTO
     * @return update AgenteDTO
     */
    @Override
    public AgentDTO updateAgent(AgentDTO agentDTO) {
        final AgentDTO agentDTO1 =agentDTOConvert.convert(agentService.updateAgent(agentToServiceConvert.convert(agentDTO)));
        LOGGER.info("Updating  Agents");
        return agentDTO1;

    }

    /**
     *
     * @param agentId
     * @return AgentDTO enable false
     */
    @Override
    public AgentDTO deleteAgent(Long agentId) {
        final AgentDTO agentDTO =agentDTOConvert.convert(agentService.deleteAgent(agentId));
        LOGGER.info("Deleting  Agents");
        return agentDTO;
    }
}
