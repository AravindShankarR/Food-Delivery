package com.example.fooddelimain;

import android.content.Context;
import androidx.lifecycle.LiveData;
import java.util.List;

public class UserRepository {
    private UserDao userDao;
    private LiveData<List<User>> allUsers;

    public UserRepository(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        userDao = database.userDao();
        allUsers = userDao.getAllUsers();
    }

    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public LiveData<User> getUserByUsernamePassword(String username, String password) {
        return userDao.getUserByUsernamePassword(username, password);
    }
}

