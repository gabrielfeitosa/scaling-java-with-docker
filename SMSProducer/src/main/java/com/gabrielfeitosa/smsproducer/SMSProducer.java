package com.gabrielfeitosa.smsproducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@EnableBinding(Source.class)
public class SMSProducer {

    private final Logger log = LoggerFactory.getLogger(SMSProducer.class);

    @Autowired
    private Source source;

    public void produceSMS() throws InterruptedException {
        int index = 1;
        Random randomGenerator = new Random();
        while(true){
            SMS sms = new SMS(index, randomGenerator.nextInt(999999), "SMS message");
            log.debug("Sending SMS {}", sms);
            source.output().send(MessageBuilder.withPayload(sms).build());
            Thread.sleep(100);
            index++;
        }
    }
}
