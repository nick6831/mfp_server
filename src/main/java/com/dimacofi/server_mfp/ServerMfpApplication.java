package com.dimacofi.server_mfp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.servlet.config.annotation.RedirectViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@SpringBootApplication
public class ServerMfpApplication {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ServerMfpApplication.class);
    }
    
  
    
	public static void main(String[] args) {
		SpringApplication.run(ServerMfpApplication.class, args);
	}

}

