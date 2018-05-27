package com.lru.model;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lru.Common;
import com.mdl.controller.GetMapping;
import com.mdl.exceptions.NigoException;
import com.mdl.response.AgentEmailResponse;

@RestController
@RequestMapping(value = Common.LISTCONSTANTS.API.ROOT_PATH)
public class LRUController {


	@GetMapping(value = GET_AGENT_URI)
	public ResponseEntity<AgentEmailResponse> getAgentEmail(@PathVariable String agentID) throws NigoException {
		return new ResponseEntity<>(agentEmailResponse, HttpStatus.OK);
	}


}
