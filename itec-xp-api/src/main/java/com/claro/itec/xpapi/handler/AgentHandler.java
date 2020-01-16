package com.claro.itec.xpapi.handler;

import com.claro.itec.xpapi.dto.AgentDTO;
import com.claro.itec.xpapi.dto.response.AgentRsDTO;

import java.util.List;

public interface AgentHandler {

    /**
     *
     * @return la Lista de AgentDTO con enable true
     */
    public List<AgentRsDTO> retrieveListAgents() ;

    /**
     *
     * @param agentDTO
     * @return el AgentDTO creado
     */
    public AgentDTO createAgent(final AgentDTO agentDTO);

    /**
     *
     * @param agentDTO
     * @return el AgentDTO actualizado
     */
    public AgentDTO updateAgent(final AgentDTO agentDTO);

    /**
     *
     * @param agentId
     * @return AgentDTO con enable False
     */
    public AgentDTO deleteAgent(final  Long agentId);
}
