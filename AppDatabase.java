package com.example.fooddelimain;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract UserDao userDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "user_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private final UserDao userDao;
        PopulateDbAsyncTask(AppDatabase instance) {
            userDao = instance.userDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            // Here you can insert initial user data
            // For example, prepopulate with a default user
            User user = new User();
            user.setUsername("default_user");
            user.setPassword("default_password");
            user.setEmail("default_email");
            user.setPhone_number("default_phone_number");

            userDao.insertUser(user);

            return null;
        }
    }
}
