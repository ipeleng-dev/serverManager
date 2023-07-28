package com.example.server.enumeration;

public enum Status {
    SERVER_UP("SERVER_UP"),
    SERVER_DOWN("SERVER_DOWN");

    private String status;

    Status(Status status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }
}
