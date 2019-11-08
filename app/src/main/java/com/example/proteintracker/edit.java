package com.example.proteintracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class edit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Button ubahBtn = (Button)findViewById(R.id.btnUbah);
        ubahBtn.setOnClickListener(ubahBtnListeners);
    }
    private View.OnClickListener ubahBtnListeners = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(edit.this, KelolaMahasiswa.class);
            startActivity(intent);
        }
    };
}
