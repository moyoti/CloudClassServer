/**
 * @Author: dongqihang
 * @Date: Created in 13:08 2019/1/18
 */
package com.my;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class SpringBootServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootServerApplication.class, args);
    }
}
