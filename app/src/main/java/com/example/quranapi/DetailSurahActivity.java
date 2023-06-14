package com.example.quranapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailSurahActivity extends AppCompatActivity {

    TextView textViewIDSurah;
    TextView textNama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_surah);

        String biasa = getIntent().getStringExtra("biasa");
        textNama = findViewById(R.id.tvIDSurah);
        textNama.setText("Nama Surah > " + (biasa));

        String lengkap = getIntent().getStringExtra("lengkap");
        textNama = findViewById(R.id.tvID1);
        textNama.setText("Nama Surah dengan tanda > " + (lengkap));

        int id = getIntent().getIntExtra("id", 1);
        textViewIDSurah = findViewById(R.id.tvID2);
        textViewIDSurah.setText("Surah urutan ke > " + (id));

        String arab = getIntent().getStringExtra("arab");
        textNama = findViewById(R.id.tvID3);
        textNama.setText(arab);
    }
}