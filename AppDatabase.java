package com.yourcompany.projectname.data.local.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import com.yourcompany.projectname.data.local.dao.TransactionDao;
import com.yourcompany.projectname.data.local.entity.TransactionEntity;

@Database(entities = {TransactionEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase instance;

    public abstract TransactionDao transactionDao();

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "transaction_db"
                    ).build();
                }
            }
        }
        return instance;
    }
}
