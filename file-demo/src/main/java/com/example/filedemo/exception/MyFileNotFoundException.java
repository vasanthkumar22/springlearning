package com.example.filedemo.exception;

import java.net.MalformedURLException;

public class MyFileNotFoundException extends RuntimeException {
    public MyFileNotFoundException(String message) {
        super(message);
    }

    public MyFileNotFoundException(String s, Exception e) {
        super(s, e);
    }
}
