package com.ecommerce.onlinebookshop.exception;

public class InvalidAdminException extends Exception{
    private String msg;

    public InvalidAdminException(String msg) {
        this.msg = msg;
    }
}
