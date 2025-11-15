package com.yourcompany.projectname.ui.transaction;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.yourcompany.projectname.data.local.entity.TransactionEntity;
import com.yourcompany.projectname.data.repository.TransactionRepository;

import java.util.List;

public class TransactionViewModel extends AndroidViewModel {

    private final TransactionRepository repository;

    public TransactionViewModel(@NonNull Application application) {
        super(application);
        repository = new TransactionRepository(application);
    }

    public LiveData<List<TransactionEntity>> getAllTransactions() {
        return repository.getAllTransactions();
    }

    public void insert(TransactionEntity transaction) {
        repository.insert(transaction);
    }

    public void update(TransactionEntity transaction) {
        repository.update(transaction);
    }

    public void delete(TransactionEntity transaction) {
        repository.delete(transaction);
    }
}
