package com.yourcompany.projectname.ui.transaction;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.yourcompany.projectname.data.local.entity.TransactionEntity;
import com.yourcompany.projectname.databinding.ItemTransactionBinding;

public class TransactionAdapter extends ListAdapter<TransactionEntity, TransactionAdapter.ViewHolder> {

    public TransactionAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<TransactionEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<TransactionEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull TransactionEntity oldItem, @NonNull TransactionEntity newItem) {
                    return oldItem.getId() == newItem.getId();
                }

                @Override
                public boolean areContentsTheSame(@NonNull TransactionEntity oldItem, @NonNull TransactionEntity newItem) {
                    return oldItem.getTitle().equals(newItem.getTitle()) &&
                           oldItem.getAmount() == newItem.getAmount() &&
                           oldItem.getDate() == newItem.getDate();
                }
            };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTransactionBinding binding = ItemTransactionBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemTransactionBinding binding;

        public ViewHolder(ItemTransactionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(TransactionEntity item) {
            binding.txtTitle.setText(item.getTitle());
            binding.txtAmount.setText(String.valueOf(item.getAmount()));
        }
    }
}
