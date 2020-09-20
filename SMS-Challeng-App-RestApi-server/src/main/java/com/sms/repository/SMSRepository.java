package com.sms.repository;
import org.springframework.data.repository.CrudRepository;

import com.sms.entity.SMSEntity;

public interface SMSRepository extends CrudRepository<SMSEntity, Integer>{

}
