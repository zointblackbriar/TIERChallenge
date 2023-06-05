/*
 * Copyright 2022-2023 Orcun Oruc
 *
 * You should have received a copy of a license with this program. 
 *
 * You may not use, copy, modify, sublicense, or distribute the Program or any
 * portion of it, except as expressly provided under the given license.
 */
package com.tierchallenge.SpringBootTierChallenge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.tierchallenge.sampleapp.controller.URLShortenerController;


/**
 * TODO DOCUMENT ME!
 *
 * @author $author$
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(URLShortenerController.class)
public class MockTestURLShortener {

    //~ Instance fields ----------------------------------------------------------------------------------------------------------

    /**
     * TODO DOCUMENT ME!
     */
    @Autowired
    private MockMvc mockMvc;

    //~ Methods ------------------------------------------------------------------------------------------------------------------

    /**
     * TODO DOCUMENT ME!
     */
    @Test
    public void testRestControllerGet() {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/samplemessage"))
                .contentType(MediaType.TEXT_PLAIN)
                .characterEncoding("utf-8")
                .andExpect(status().isOk());
    }
}
