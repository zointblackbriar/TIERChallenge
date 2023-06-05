/*
 * Copyright 2022-2023 Orcun Oruc
 *
 * You should have received a copy of a license with this program. 
 *
 * You may not use, copy, modify, sublicense, or distribute the Program or any
 * portion of it, except as expressly provided under the given license.
 */
package org.tierchallenge.sampleapp.controller;
///*
// * Copyright 2022-2023 Orcun Oruc
// *
// * You should have received a copy of a license with this program.
// *
// * You may not use, copy, modify, sublicense, or distribute the Program or any
// * portion of it, except as expressly provided under the given license.
// */

import com.google.common.hash.Hashing;

import org.apache.commons.validator.routines.UrlValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import org.tierchallenge.sampleapp.dto.URL;
import org.tierchallenge.sampleapp.errormodel.Error;

import java.nio.charset.Charset;

import java.time.LocalDateTime;

import java.util.concurrent.TimeUnit;

import javax.validation.constraints.NotNull;


/**
 * Controller for the API - RESTController.
 *
 * @author $author$
 */
@RequestMapping(value = "/api/v1")
@RestController
public class URLShortenerController {

    //~ Instance fields ----------------------------------------------------------------------------------------------------------

    /**
     * TODO DOCUMENT ME!
     */
    private RedisTemplate<String, URL> redisTemplate;

    /**
     * TODO DOCUMENT ME!
     */
    @Value("${redis.ttl}")
    private long ttl;

    //~ Constructors -------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new {@link URLShortenerController} object.
     *
     * @param redisTemplate TODO DOCUMENT ME!
     */
    @Autowired
    public URLShortenerController(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    //~ Methods ------------------------------------------------------------------------------------------------------------------

    /**
     * Simple test for REST Controller.
     *
     * @return String value
     */
    @GetMapping("/samplemessage")
    public String getAMessageFromServer() {
        String message = "Server is working";

        return message;
    }

    /**
     * Fetch from the database.
     *
     * @param  id for database search
     *
     * @return exact result from the database
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getURLFromRedis(@PathVariable String id) {
        // get from redis
        URL url = redisTemplate.opsForValue().get(id);

        if (url == null) {
            Error error = new Error("id", id, "No such key exists");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }

        return ResponseEntity.ok(url);
    }

    /**
     * shortenURLFunc for the main purpose of URL Shortener.
     *
     * @param  url URL parameter of URL Model
     *
     * @return TODO DOCUMENT ME!
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity shortenURLFunc(@NotNull @RequestBody URL url) {
        UrlValidator validator = new UrlValidator(new String[] {"http", "https"});

        // if invalid url, return error
        if (!validator.isValid(url.getUrl())) {
            Error error = new Error("url", url.getUrl(), "Invalid URL");

            return ResponseEntity.badRequest().body(error);
        }

        String id = Hashing.murmur3_128().hashString(url.getUrl(), Charset.defaultCharset()).toString();
        url.setId("tier.app/" + id);
        url.setCreated(LocalDateTime.now());

        // store in redis
        redisTemplate.opsForValue().set(url.getId(), url, ttl, TimeUnit.SECONDS);

        return ResponseEntity.ok(url);
    }
}
