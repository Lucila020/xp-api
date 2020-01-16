package com.claro.itec.xpapi.controller;

import com.claro.itec.xpapi.dto.AgentDTO;
import com.claro.itec.xpapi.dto.response.AgentRsDTO;
import com.claro.itec.xpapi.handler.AgentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
public class AgentController {

  private AgentHandler agentHandler;

  @Autowired
  public AgentController(AgentHandler agentHandler) {
        this.agentHandler = agentHandler;
    }

    /**
     * Gets agentDTO { @link AgenteDTO }.
     *
     * @return returns List AgentDTO { @link AgenteDTO }.
     */
    @GetMapping(path="/itec/agent/",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AgentRsDTO> retrieveListAgents(){
        return this.agentHandler.retrieveListAgents();
    }


    /**
     * Creates a agent { @link AgentDTO }.
     *
     * @param   {@link AgentDTO} to be created
     * @return returns the created agent {@link AgentDTO}
     */
    @PostMapping(path="/itec/agent/",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public AgentDTO createAgent(@Valid @RequestBody final AgentDTO agent) {
        return this.agentHandler.createAgent(agent);
    }


    /**
     * Updates the agentDTO { @link ContactDTO }.
     *
     * @param agentDTO {@link AgentDTO} to be updated
     * @return returns the {@link AgentDTO} updated
     */
    @PutMapping(path="/itec/agent/",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AgentDTO updateAgent(@Valid @RequestBody final AgentDTO agentDTO) {
        return this.agentHandler.updateAgent(agentDTO);
    }

    /**
     * Disable the agent
     *
     * @param agentId that are going to be disabled
     * @return returns the Ids of the reason that have been disabled
     */
    @PutMapping(value = "/itec/agent/disable/{agentId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AgentDTO disableAgent(final @PathVariable("agentId") Long agentId) {
         return this.agentHandler.deleteAgent(agentId);
    }
}
