package com.sms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.sms.entity.SMSEntity;
import com.sms.service.ISMSService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value={"/sms"})
@CrossOrigin(origins = "http://localhost:4200")
public class SMSController {
	
	 	@Autowired
	    ISMSService smsService;

	 	@GetMapping(value="/getAll", headers="Accept=application/json")
	    public List<SMSEntity> getAllSMSData() {
	        List<SMSEntity> data=smsService.getSMSEntity();
	        return data;

	    }
	 	
	    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiOperation(value = "Find by id",notes = "Also returns a link to retrieve all data with rel - all-Data")
	    public ResponseEntity<Optional<SMSEntity>>getSMSDataById(@PathVariable("id") Integer id) {	 
	        Optional<SMSEntity> data = smsService.findById(id);
	        if ( !data.isPresent() ) {
	            return new ResponseEntity<Optional<SMSEntity>>(data,HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Optional<SMSEntity>>(data,HttpStatus.OK);
	    }

	    @PostMapping(value="/create",headers="Accept=application/json")
	    public ResponseEntity<SMSEntity> createNewSMSData(@RequestBody SMSEntity data, UriComponentsBuilder ucBuilder){
	        System.out.println("Creating data "+data);
	        SMSEntity  resp = smsService.createSMSEntity(data);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/sms/{id}").buildAndExpand(data.getId()).toUri()); 
	        
	        return new ResponseEntity<SMSEntity>(resp,headers, HttpStatus.CREATED);
	    }

	    @PutMapping(value="/update", headers="Accept=application/json")
	    public ResponseEntity<Optional<SMSEntity>> updateSMSData(@RequestBody SMSEntity currentData)
	    {
	        System.out.println("id"+currentData.getId());
	        Optional<SMSEntity> data = smsService.findById(currentData.getId());
	        System.out.println(data.toString());
	        if (  !data.isPresent()  ) {
	        	System.out.println("no data found...");
	            return new ResponseEntity<Optional<SMSEntity>>(data,HttpStatus.NOT_FOUND);
	        }
	        smsService.update(currentData, currentData.getId());
	        return new ResponseEntity<Optional<SMSEntity>>(data,HttpStatus.OK);
	    }

	    @DeleteMapping(value="/{id}", headers ="Accept=application/json")
	    public ResponseEntity<Optional<SMSEntity>> deleteSMSData(@PathVariable("id") Integer id){
	    	Optional<SMSEntity> data = smsService.findById(id);
	        if (!data.isPresent()) {
	            return new ResponseEntity<Optional<SMSEntity>>(data,HttpStatus.NOT_FOUND);
	        }
	        smsService.deleteSMSEntityById(id);
	        return new ResponseEntity<Optional<SMSEntity>>(data,HttpStatus.NO_CONTENT);
	    }
	
}
