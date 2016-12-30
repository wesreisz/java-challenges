package com.wesleyreisz.demo.bookstore.book.model;

import java.util.Date;

/**
 * Created by wesleyreisz on 12/30/16.
 */
public class ServiceResponse {
    private String message;
    private Date timestamp;

    public ServiceResponse() {
        this.timestamp = new Date();
    }

    public ServiceResponse(String message) {
        this.message = message;
        this.timestamp = new Date();
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
