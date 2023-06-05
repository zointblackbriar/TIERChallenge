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
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.tierchallenge.sampleapp.SpringBootURLShortenerRedisApplication;
import org.tierchallenge.sampleapp.controller.URLShortenerController;


/**
 * TODO DOCUMENT ME!
 *
 * @author $author$
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringBootURLShortenerRedisApplication.class)
// @WebMvcTest(URLShortenerController.class)
public class MockURLShortenerTest {

    //~ Instance fields ----------------------------------------------------------------------------------------------------------

    /**
     * TODO DOCUMENT ME!
     */
    @Autowired
    private MockMvc mockMvc;

    //~ Methods ------------------------------------------------------------------------------------------------------------------

    /**
     * TODO DOCUMENT ME!
     *
     * @throws Exception
     */
    @Test
    public void testRestControllerGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/samplemessage")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding("utf-8"));
    }

    /**
     * TODO DOCUMENT ME!
     *
     * @throws Exception
     */
    @Test
    public void testRestControllerGetURLShortener() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/c856da94110b6b612b3f34ecfafd0d1d"))
                .andExpect(status().isOk())
                .andExpect(content().string("tier.app/c856da94110b6b612b3f34ecfafd0d1d"))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}
