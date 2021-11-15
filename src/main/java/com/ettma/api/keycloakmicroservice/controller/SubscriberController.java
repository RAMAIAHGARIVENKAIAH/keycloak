package com.ettma.api.keycloakmicroservice.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ettma.api.keycloakmicroservice.entity.PortalUserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/api")
public class SubscriberController {
	@Autowired
	private PortalUserRepository portalUserRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
    @RequestMapping(value = "/anonymous", method = RequestMethod.GET)
    public ResponseEntity<String> getAnonymous() {
    	String  portalUser = portalUserRepository.findUpdateObjectId("ettmatest1@gmail.com", null, 0, null);
        return ResponseEntity.ok(portalUser);
        
    }

    @RolesAllowed({"user", "Administrator"})
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<String> getUser(@RequestHeader String Authorization) {
        return ResponseEntity.ok("Hello User");
    }

    @RolesAllowed("admin")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ResponseEntity<String> getAdmin(@RequestHeader String Authorization) {
        return ResponseEntity.ok("Hello Admin");
    }

    @RolesAllowed({ "admin", "user" })
    @RequestMapping(value = "/all-user", method = RequestMethod.GET)
    public ResponseEntity<String> getAllUser(@RequestHeader String Authorization) {
    	String  portalUser = portalUserRepository.findUpdateObjectId("ettmatest1@gmail.com", null, 0, null);
        return ResponseEntity.ok(portalUser);
    }
    
    
    @RolesAllowed({ "admin", "user","ADMINISTRATOR" })
   // @RequestMapping(value = "/users/GetSubScriberobjectId", method = RequestMethod.POST)
    @PostMapping(path= "/users/GetSubScriberobjectId", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> getSubScriberobjectId(@RequestHeader String Authorization, @RequestBody SubscriberRequest subscriberRequest) throws JsonMappingException, JsonProcessingException {
    	
    	//SubscriberRequest  subscriberRequestObjRequest = objectMapper.readValue(subscriberRequest, SubscriberRequest.class);
    	System.out.println(subscriberRequest+"\nUserAd==>"+subscriberRequest.getUserAd());
    	String  portalUser = portalUserRepository.findUpdateObjectId(subscriberRequest.getUserAd(), null, 0, null);
        return ResponseEntity.ok(portalUser);
    }

    @RolesAllowed({ "admin", "user" ,"ADMINISTRATOR"})
    @RequestMapping(value = "/subscribers/Users/{subscriberUserId}", method = RequestMethod.GET)
    public ResponseEntity<String> getUserDetails(@RequestHeader String Authorization, @PathVariable("subscriberUserId") int subscriberUserId) {
    	List<String>  portalUser = portalUserRepository.GetSubscriberUserDetail(Integer.toString(subscriberUserId), 0, null);
        return ResponseEntity.ok(portalUser.toString());
    }
    
    @RolesAllowed({ "admin", "user" ,"ADMINISTRATOR"})
    @RequestMapping(value = "/tools/Gettoolkitspage", method = RequestMethod.GET)
    public ResponseEntity<String> getToolKitsPage(@RequestHeader String Authorization, @RequestParam ("userId") int subscriberUserId) {
    	String  portalUser = portalUserRepository.getToolKitsPage(Integer.toString(subscriberUserId), 0, null);
        return ResponseEntity.ok(portalUser);
    }
    
    @RolesAllowed({ "admin", "user" ,"ADMINISTRATOR"})
    @RequestMapping(value = "/Tableau", method = RequestMethod.GET)
    public ResponseEntity<String> getToolKitsPage(@RequestHeader String Authorization) {
    	
    	String request = "{\"username\":\"ettmatest1@gmail.com\"}";
    	String  portalUser = restTemplate.postForObject("http://avawave.ettma.com/trusted", request, String.class);
    	
    	System.out.println(portalUser);
        return ResponseEntity.ok(portalUser);
    }
}