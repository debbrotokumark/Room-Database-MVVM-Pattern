package com.yourcompany.projectname.ui.transaction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yourcompany.projectname.data.local.entity.TransactionEntity;
import com.yourcompany.projectname.databinding.ActivityTransactionBinding;

import java.util.List;

public class TransactionActivity extends AppCompatActivity {

    private ActivityTransactionBinding binding;
    private TransactionViewModel viewModel;
    private TransactionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        binding = ActivityTransactionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(TransactionViewModel.class);

        setupRecyclerView();
        observeData();
        setupClicks();
    }

    private void setupRecyclerView() {
        adapter = new TransactionAdapter();

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
    }

    private void observeData() {
        viewModel.getAllTransactions().observe(this, transactions -> {
            if (transactions != null) {
                adapter.submitList(transactions);
            }
        });
    }

    private void setupClicks() {
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransactionEntity item = new TransactionEntity(
                        "Lunch",
                        150.0,
                        System.currentTimeMillis()
                );
                viewModel.insert(item);

                Toast.makeText(TransactionActivity.this, "Inserted!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
