package com.kloudvista.pagenation;

import com.kloudvista.pagenation.service.MailerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("")
@Slf4j
public class PagenationApplication implements CommandLineRunner {

	@Autowired
	private MailerService MailerService;


	public static void main(String[] args) {
		SpringApplication.run(PagenationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("jdjdd");
		MailerService.postMail();
	}
}
