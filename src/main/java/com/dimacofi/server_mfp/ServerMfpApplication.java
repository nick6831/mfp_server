package com.dimacofi.server_mfp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 *
 * @author nvelasquez
 */
@SpringBootApplication
public class ServerMfpApplication {

    /**
     *
     * @param application
     * @return
     */
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ServerMfpApplication.class);
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
		SpringApplication.run(ServerMfpApplication.class, args);
	}

}

