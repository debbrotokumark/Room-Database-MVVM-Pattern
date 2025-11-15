package com.yourcompany.projectname.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.yourcompany.projectname.data.local.dao.TransactionDao;
import com.yourcompany.projectname.data.local.database.AppDatabase;
import com.yourcompany.projectname.data.local.entity.TransactionEntity;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TransactionRepository {

    private final TransactionDao transactionDao;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public TransactionRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        transactionDao = db.transactionDao();
    }

    public LiveData<List<TransactionEntity>> getAllTransactions() {
        return transactionDao.getAllTransactions();
    }

    public void insert(TransactionEntity transaction) {
        executor.execute(() -> transactionDao.insert(transaction));
    }

    public void update(TransactionEntity transaction) {
        executor.execute(() -> transactionDao.update(transaction));
    }

    public void delete(TransactionEntity transaction) {
        executor.execute(() -> transactionDao.delete(transaction));
    }
}
