package com.example.filedemo.exception;

public class FileStorageException extends RuntimeException {

    public FileStorageException(String message){
        super(message);
    }

    public FileStorageException(String s, Exception ex) {
        super(s,ex);
    }
}
