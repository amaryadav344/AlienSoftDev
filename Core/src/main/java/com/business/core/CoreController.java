package com.business.core;


import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CoreController {
    @Autowired
    private RabbitTemplate template;
    @Autowired
    private TopicExchange exchange;

    @RequestMapping(value = "/LoadXmlCache", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getXmlFromObject() {

        return new ResponseEntity(HttpStatus.OK);
    }


}
