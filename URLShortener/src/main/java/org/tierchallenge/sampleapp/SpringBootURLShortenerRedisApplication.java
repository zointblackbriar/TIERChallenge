/*
 * Copyright 2022-2023 Orcun Oruc
 *
 * You should have received a copy of a license with this program. 
 *
 * You may not use, copy, modify, sublicense, or distribute the Program or any
 * portion of it, except as expressly provided under the given license.
 */
package org.tierchallenge.sampleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

import java.util.Collections;


/**
 * Main application with custom port 3000.
 *
 * @author Orcun Oruc
 */
@ComponentScan
@SpringBootApplication
public class SpringBootURLShortenerRedisApplication {

    //~ Methods ------------------------------------------------------------------------------------------------------------------

    /**
     * TODO DOCUMENT ME!
     *
     * @param args TODO DOCUMENT ME!
     */
    public static void main(String[] args) {
        // Custom port Spring Web Application
        SpringApplication app = new SpringApplication(SpringBootURLShortenerRedisApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "3000"));
        app.run(args);
    }
}
