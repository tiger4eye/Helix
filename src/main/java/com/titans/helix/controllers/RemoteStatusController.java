package com.titans.helix.controllers;

import com.titans.helix.data.HelixRequest;
import com.titans.helix.data.HelixRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/helixrequest")
@RestController
public class RemoteStatusController {

    @Autowired
    private HelixRequestRepository helixRequestRepository;

    @GetMapping("/all")
    public List<HelixRequest> all() {
        return helixRequestRepository.findAll();
    }

    @RequestMapping(path = "/add/{firstName}/{lastName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<HelixRequest> insertHelixRequest(@PathVariable(value = "firstName") String firstName, @PathVariable(value = "lastName") String lastName) {

        HelixRequest helixRequest = new HelixRequest();
        helixRequest.setFirstName(firstName);
        helixRequest.setLastName(lastName);
        helixRequest.setRequestTime(null);
        helixRequestRepository.save(helixRequest);
        return helixRequestRepository.findAll();
    }
}
