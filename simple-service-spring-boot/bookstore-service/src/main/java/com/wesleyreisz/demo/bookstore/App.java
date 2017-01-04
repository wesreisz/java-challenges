package com.wesleyreisz.demo.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class App 
{
    public static void main( String[] args ) {
        SpringApplication.run(App.class,args);
        System.out.println( "Starting the app" );
    }
}
