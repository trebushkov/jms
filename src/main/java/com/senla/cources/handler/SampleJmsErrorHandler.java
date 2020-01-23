package com.senla.cources.handler;

import com.senla.cources.service.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;

@Service
public class SampleJmsErrorHandler implements ErrorHandler {

    private Logger log = LoggerFactory.getLogger(Consumer.class);

    @Override
    public void handleError(Throwable t) {
        log.warn("In default jms error handler...");
        log.error("Error Message : {}", t.getMessage());
    }

}

