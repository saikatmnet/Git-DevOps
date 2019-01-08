package com.devops.microservices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/devops")
public class DevOpsController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)	
    public ResponseEntity<String> getAllBookings() {
    	return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }    

}
