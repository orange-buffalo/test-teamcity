package com.example.api;

import com.example.core.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserApi {

    private final List<String> users = new ArrayList<>();

    public void addUser(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("User name must not be blank");
        }
        users.add(StringUtils.capitalize(name));
    }

    public List<String> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public boolean userExists(String name) {
        if (name == null) {
            return false;
        }
        return users.contains(StringUtils.capitalize(name));
    }

    public int getUserCount() {
        return users.size();
    }
}
