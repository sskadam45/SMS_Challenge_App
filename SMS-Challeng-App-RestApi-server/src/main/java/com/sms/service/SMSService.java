package com.sms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entity.SMSEntity;
import com.sms.repository.SMSRepository;

@Service
public class SMSService implements ISMSService{
	 @Autowired
	    SMSRepository smsRepository;

	    public SMSEntity createSMSEntity(SMSEntity data) {
	        return smsRepository.save(data);
	    }

	    public List<SMSEntity> getSMSEntity() {
	        return (List<SMSEntity>) smsRepository.findAll();
	    }

	    public Optional<SMSEntity> findById(Integer id) {
	        return smsRepository.findById(id);
	    }

	    public SMSEntity update(SMSEntity data, Integer l) {
	        return smsRepository.save(data);
	    }

	    public void deleteSMSEntityById(Integer id) {
	        smsRepository.deleteById(id);
	    }

}
