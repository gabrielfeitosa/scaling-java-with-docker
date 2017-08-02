package com.gabrielfeitosa.smsconsumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@EnableBinding(Sink.class)
public class SMSConsumer {

    private final Logger log = LoggerFactory.getLogger(SMSConsumer.class);

    @StreamListener(Sink.INPUT)
    public void consumerEmail(SMS message) throws InterruptedException {
        log.info("Processing SMS {}", message);
        Thread.sleep(130);
    }
}
