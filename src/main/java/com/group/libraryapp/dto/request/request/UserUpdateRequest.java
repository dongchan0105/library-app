package com.group.libraryapp.dto.request.request;

public class UserUpdateRequest {

    private String name;
    private int id;

    public UserUpdateRequest(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}
