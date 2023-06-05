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

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.tierapp.sampleapp.service.URLShortenerService;

import org.tierchallenge.sampleapp.dto.URLDto;

import javax.validation.constraints.NotBlank;


/**
 * TODO DOCUMENT ME!
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
    private URLShortenerService urlShortenerService;

    //~ Constructors -------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new {@link URLShortenerController} object.
     *
     * @param urlShortenerService TODO DOCUMENT ME!
     */
    @Autowired
    public URLShortenerController(URLShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    //~ Methods ------------------------------------------------------------------------------------------------------------------

    /**
     * TODO DOCUMENT ME!
     *
     * @param  key TODO DOCUMENT ME!
     *
     * @return TODO DOCUMENT ME!
     */
    @RequestMapping(value = "/{key}", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<String> getNewUrl(@PathVariable String key) {
        String url = urlShortenerService.getUrlByKey(key);

        return ResponseEntity.ok(url);
    }

    /**
     * TODO DOCUMENT ME!
     *
     * @param  url input TODO DOCUMENT ME!
     *
     * @return TODO DOCUMENT ME!
     */
    @RequestMapping(value = "/urlshort", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<URLDto> shortenURLFunc(@NotBlank @PathVariable String url) {
        URLDto shortenedUrl = urlShortenerService.shortenUrl(url);

        return ResponseEntity.ok(shortenedUrl);
    }
}
