package com.kloudvista.pagenation.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MailerService {
    @Autowired
    private ConfigProperties configProperties;

    public void postMail(){

        System.out.println("from mail:   "+configProperties.getFromEmail());


        System.out.println("from mail:   "+configProperties.getPort());
        System.out.println("from mail:   "+configProperties.getHostName());
        log.info("from mail:   "+configProperties.getHostName());

    }
}
