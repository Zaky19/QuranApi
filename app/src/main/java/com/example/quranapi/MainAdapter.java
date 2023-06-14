package com.example.quranapi;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranapi.model.ChaptersItem;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    private List<ChaptersItem> result;

    public MainAdapter(List<ChaptersItem> result) {
        this.result = result;
    }

    @NonNull
    @Override
    public MainAdapter.MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.MainViewHolder holder, int position) {
        final ChaptersItem chapters = result.get(position);

        holder.textViewSurahLatin.setText(chapters.getNameSimple());
        holder.textViewTerjemahanSurah.setText(chapters.getTranslatedName().getName());
        holder.textViewSurahArab.setText(chapters.getNameArabic());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailSurahActivity.class);
                intent.putExtra("id", chapters.getId());
                intent.putExtra("biasa", chapters.getNameSimple());
                intent.putExtra("arab", chapters.getNameArabic());
                intent.putExtra("lengkap", chapters.getNameComplex());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        TextView textViewSurahLatin, textViewTerjemahanSurah, textViewSurahArab;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewSurahLatin = itemView.findViewById(R.id.tvSurahLatin);
            textViewTerjemahanSurah = itemView.findViewById(R.id.tvTerjemahanSurah);
            textViewSurahArab = itemView.findViewById(R.id.tvSurahArab);
        }
    }

    public void setData(List<ChaptersItem> data){
        result.clear();
        result.addAll(data);
        notifyDataSetChanged();
    }
}
