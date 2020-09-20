package com.sms.service;

import java.util.List;
import java.util.Optional;

import com.sms.entity.SMSEntity;

public interface ISMSService {
	
     public SMSEntity createSMSEntity(SMSEntity user);
     public List<SMSEntity> getSMSEntity();
     public Optional<SMSEntity> findById(Integer id);
     public SMSEntity update(SMSEntity user, Integer l);
     public void deleteSMSEntityById(Integer id);
}