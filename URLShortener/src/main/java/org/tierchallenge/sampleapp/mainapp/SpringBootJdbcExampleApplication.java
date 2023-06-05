/*
 * Copyright 2022-2023 Orcun Oruc
 *
 * You should have received a copy of a license with this program. 
 *
 * You may not use, copy, modify, sublicense, or distribute the Program or any
 * portion of it, except as expressly provided under the given license.
 */
package org.tierchallenge.sampleapp.mainapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;


/**
 * TODO DOCUMENT ME!
 *
 * @author $author$
 */
@SpringBootApplication
public class SpringBootJdbcExampleApplication implements CommandLineRunner {

    //~ Methods ------------------------------------------------------------------------------------------------------------------

    //
    // @Autowired
    // StudentService studentService;

    /**
     * TODO DOCUMENT ME!
     *
     * @param args TODO DOCUMENT ME!
     */
    public static void main(String[] args) {
        // SpringApplication.run(SpringBootJdbcExampleApplication.class, args);
        // Custom port Spring Web Application
        SpringApplication app = new SpringApplication(SpringBootJdbcExampleApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "3000"));
        app.run(args);
    }

    /**
     * TODO DOCUMENT ME!
     *
     * @param  args TODO DOCUMENT ME!
     *
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
    }

}
