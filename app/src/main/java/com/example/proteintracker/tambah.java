package com.example.proteintracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tambah extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        Button simpanBtn = (Button)findViewById(R.id.btnSimpan);
        simpanBtn.setOnClickListener(simpanBtnListener);
    }
    private View.OnClickListener simpanBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(tambah.this, KelolaMahasiswa.class);
            startActivity(intent);
        }
    };
}
