package com.example.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserApiTest {

    private UserApi userApi;

    @BeforeEach
    void setUp() {
        userApi = new UserApi();
    }

    @Test
    void addUserIncreasesCount() {
        userApi.addUser("alice");
        assertEquals(1, userApi.getUserCount());
    }

    @Test
    void addUserCapitalizesName() {
        userApi.addUser("alice");
        assertTrue(userApi.userExists("alice"));
        assertTrue(userApi.userExists("Alice"));
    }

    @Test
    void addNullUserThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> userApi.addUser(null));
    }

    @Test
    void addBlankUserThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> userApi.addUser("  "));
    }

    @Test
    void getUsersReturnsUnmodifiableList() {
        userApi.addUser("bob");
        assertThrows(UnsupportedOperationException.class, () -> userApi.getUsers().add("eve"));
    }

    @Test
    void userExistsReturnsFalseForNull() {
        assertFalse(userApi.userExists(null));
    }

    @Test
    void userExistsReturnsFalseWhenNotFound() {
        assertFalse(userApi.userExists("charlie"));
    }
}
