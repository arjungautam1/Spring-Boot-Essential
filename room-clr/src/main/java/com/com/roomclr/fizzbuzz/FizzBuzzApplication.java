/**
 * @author Arjun Gautam
 * Project :Spring-Boot-Essential
 * Date : 2021-06-04
 */
package com.com.roomclr.fizzbuzz;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FizzBuzzApplication {
    public static void main(String[] args) {
        SpringApplication.run(FizzBuzzApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            for (int i = 1; i < 101; i++) {
                String result = "";
                result += (i % 3) == 0 ? "Fizz" : "";
                result += (i % 5) == 0 ? "Buzz" : "";
                System.out.println(!result.isEmpty() ? result : i);

            }
        };
    }
}
