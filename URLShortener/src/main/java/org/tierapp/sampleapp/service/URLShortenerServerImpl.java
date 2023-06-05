/*
 * Copyright 2022-2023 Orcun Oruc
 *
 * You should have received a copy of a license with this program. 
 *
 * You may not use, copy, modify, sublicense, or distribute the Program or any
 * portion of it, except as expressly provided under the given license.
 */
package org.tierapp.sampleapp.service;

import com.google.common.hash.Hashing;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.stereotype.Service;

import org.tierchallenge.sampleapp.dto.URLDto;

import java.nio.charset.Charset;

import javax.validation.constraints.NotBlank;


/**
 * TODO DOCUMENT ME!
 *
 * @author $author$
 */
@Service
@Slf4j
public class URLShortenerServerImpl implements URLShortenerService {

    //~ Instance fields ----------------------------------------------------------------------------------------------------------

    /**
     * TODO DOCUMENT ME!
     */
    @Autowired
    private RedisTemplate<String, URLDto> redisTemplate;

    //~ Methods ------------------------------------------------------------------------------------------------------------------

    /**
     * TODO DOCUMENT ME!
     *
     * @param  key TODO DOCUMENT ME!
     *
     * @return TODO DOCUMENT ME!
     */

    @Override
    public String getUrlByKey(@NotBlank String key) {
        // TODO Auto-generated method stub
        URLDto urlDTO = redisTemplate.opsForValue().get(key);

        return "sample url";
    }

    /**
     * TODO DOCUMENT ME!
     *
     * @param  url TODO DOCUMENT ME!
     *
     * @return TODO DOCUMENT ME!
     */
    @Override
    public URLDto shortenUrl(@NotBlank String url) {
        // TODO Auto-generated method stub
        String key = Hashing.murmur3_128().hashString(url, Charset.defaultCharset()).toString();

        // URLDto shortUrlEntry = URLDto.buil
        return null;
    }
}
