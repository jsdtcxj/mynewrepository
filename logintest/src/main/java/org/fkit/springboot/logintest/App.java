package org.fkit.springboot.logintest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("org.fkit.springboot.logintest.repository")
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class);
    }
}
