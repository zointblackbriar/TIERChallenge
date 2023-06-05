/*
 * Copyright 2022-2023 Orcun Oruc
 *
 * You should have received a copy of a license with this program. 
 *
 * You may not use, copy, modify, sublicense, or distribute the Program or any
 * portion of it, except as expressly provided under the given license.
 */
package org.tierchallenge.sampleapp.dto;

import java.time.LocalDateTime;


/**
 * TODO DOCUMENT ME!
 *
 * @author $author$
 */
public class URL {

    //~ Instance fields ----------------------------------------------------------------------------------------------------------

    /**
     * TODO DOCUMENT ME!
     *
     * @author $author$
     */

    /**
     * TODO DOCUMENT ME!
     */
    private LocalDateTime created;

    /**
     * TODO DOCUMENT ME!
     */
    private String id;

    /**
     * TODO DOCUMENT ME!
     */
    private String url;

    //~ Constructors -------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new {@link URL} object.
     */
    public URL() {
    }

    /**
     * Creates a new {@link URL} object.
     *
     * @param id      id for URL
     * @param url     String part of URL
     * @param created created timestamp value for Redis
     */
    public URL(String id, String url, LocalDateTime created) {
        this.id = id;
        this.url = url;
        this.created = created;
    }

    //~ Methods ------------------------------------------------------------------------------------------------------------------

    /**
     * getter for created value.
     *
     * @return LocalDateTime value
     */
    public LocalDateTime getCreated() {
        return created;
    }

    /**
     * getter for id.
     *
     * @return id value
     */
    public String getId() {
        return id;
    }

    /**
     * get the url value.
     *
     * @return getter
     */
    public String getUrl() {
        return url;
    }

    /**
     * TODO DOCUMENT ME!
     *
     * @param created TODO DOCUMENT ME!
     */
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    /**
     * TODO DOCUMENT ME!
     *
     * @param id TODO DOCUMENT ME!
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * TODO DOCUMENT ME!
     *
     * @param url TODO DOCUMENT ME!
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
