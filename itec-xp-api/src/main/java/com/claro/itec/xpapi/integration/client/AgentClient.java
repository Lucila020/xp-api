package com.claro.itec.xpapi.integration.client;

import com.claro.itec.xpapi.dto.AgentDTO;
import com.claro.itec.xpapi.dto.PhoneTypeDTO;
import com.claro.itec.xpapi.dto.response.AgentRsDTO;
import com.claro.itec.xpapi.sto.AgentSTO;
import com.claro.itec.xpapi.sto.PhoneTypeSTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient("itec-agents-${itec.country:unknown}")
public interface AgentClient {

    /**
     * Gets agentDTO { @link AgenteDTO }.
     *
     * @return returns List AgentDTO { @link AgenteDTO }.
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AgentSTO> retrieveListAgents();


    /**
     * Creates a agent { @link AgentDTO }.
     *
     * @param   {@link AgentSTO} to be created
     * @return returns the created agent {@link AgentSTO}
     */
    @PostMapping(value = "/agent",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public AgentSTO createAgent(final AgentSTO agentSTO) ;


    /**
     * Updates the agentDTO { @link ContactDTO }.
     *
     * @param agentSTO {@link AgentSTO} to be updated
     * @return returns the {@link AgentSTO} updated
     */
    @PutMapping(value = "/agent",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AgentSTO updateAgent(final AgentSTO agentSTO);

    /**
     * Disable the agent
     *
     * @param agentId that are going to be disabled
     * @return returns the Ids of the reason that have been disabled
     */
    @PutMapping(value = "/agent/disable/{agentId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AgentSTO deleteAgent(final  Long agentId);


    /**
     * @param
     * @return List<PhoneTypeDTO>
     */
    @GetMapping(value="/phoneType", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PhoneTypeSTO> retrieveListPhoneTypes();




}
