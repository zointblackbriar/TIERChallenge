/*
 * Copyright 2022-2023 Orcun Oruc
 *
 * You should have received a copy of a license with this program. 
 *
 * You may not use, copy, modify, sublicense, or distribute the Program or any
 * portion of it, except as expressly provided under the given license.
 */
package org.tierchallenge.sampleapp.errormodel;

/**
 * Error Data Structure.
 *
 * @author Orcun Oruc
 */
public class Error {

    //~ Instance fields ----------------------------------------------------------------------------------------------------------

    // TODO Lombok library can be used
    /**
     * attribute for error.
     */
    private String field;

    /**
     * message for error.
     */
    private String message;

    /**
     * value for error.
     */
    private String value;

    //~ Constructors -------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new {@link Error} object.
     */
    public Error() {
    }

    /**
     * Creates a new {@link Error} object.
     *
     * @param field   Error filed
     * @param value   value field for Error data structure
     * @param message Error message
     */
    public Error(String field, String value, String message) {
        this.field = field;
        this.value = value;
        this.message = message;
    }

    //~ Methods ------------------------------------------------------------------------------------------------------------------

    /**
     * getterField.
     *
     * @return getterField
     */
    public String getField() {
        return field;
    }

    /**
     * getMessage.
     *
     * @return return a message
     */
    public String getMessage() {
        return message;
    }

    /**
     * getValue.
     *
     * @return return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * setField.
     *
     * @param field setter
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * setMessage.
     *
     * @param message setter
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * setValue.
     *
     * @param value setter
     */
    public void setValue(String value) {
        this.value = value;
    }
}
