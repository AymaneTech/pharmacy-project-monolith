package com.aymanetech.pharmacy;

import org.springframework.boot.SpringApplication;

public class TestPharmaApplication {

    public static void main(String[] args) {
        SpringApplication.from(PharmaApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
