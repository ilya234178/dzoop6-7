package org.example.Note.model;

import java.util.List;

public interface Repository {
    List<User> getAllUsers();
    String CreateUser(User user);
    void  updateUser(User user);

    void deleteById(String inputID);

    void deleteByID(String inputId);
}
