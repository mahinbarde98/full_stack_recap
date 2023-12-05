package com.stackroute.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

    @Autowired
    TriggerClass triggerClass;

    /*
    Provide KafkaListener config annotation
     */
    @KafkaListener(topics = AppConstants.LOCATION_UPDATE_TOPIC,groupId = AppConstants.GROUP_ID)
    public void updatedLocation(String value){
        System.out.println(value);
        this.getBrokerMessage(value);

    }

    public String getBrokerMessage(String value) {
        return "Location value received:"+triggerClass.getMessageValue(value);
    }

}
