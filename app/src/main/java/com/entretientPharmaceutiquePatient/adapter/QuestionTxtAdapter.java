package com.entretientPharmaceutiquePatient.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.entretientPharmaceutiquePatient.R;

import org.jetbrains.annotations.NotNull;

public class QuestionTxtAdapter extends RecyclerView.Adapter<QuestionTxtAdapter.ViewHolder>{

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull QuestionTxtAdapter.ViewHolder holder, int position) {
        viewHolder.getTextView().setText(localDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.title_short_question);
        }

        public TextView getTextView() {
            return textView;
        }
    }




}
