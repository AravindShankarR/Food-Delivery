package com.example.fooddelimain;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    LiveData<User> getUserByUsernamePassword(String username, String password);

    @Query("SELECT * FROM users")
    LiveData<List<User>> getAllUsers();


}
