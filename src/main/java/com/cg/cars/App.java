package com.cg.cars;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableSwagger2
//http://localhost:9090/swagger-ui/
public class App implements ApplicationRunner
{
	
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
        System.out.println( "------------Welcome to Car sales App-------------" );
    }
   private static final Logger logger = LogManager.getLogger(App.class);
   		@Override
        public void run(ApplicationArguments args) throws Exception {
            logger.debug("Debugging log");
            logger.info("Info log");
            logger.warn("Hey, There is No warning!");
            logger.error("OK");
            logger.fatal("Trail for fatal");
        }
       
}
