package com.example.proteintracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MahasiswaActivity extends AppCompatActivity
        implements Mahasiswa1Fragment.SendMessage{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Mahasiswa1Fragment mhs = Mahasiswa1Fragment.newInstance("Hai", "");
        ft.replace(R.id.mhsFrame, mhs);
        ft.commit();
    }

    public void SendData(String Message) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Mahasiswa2Fragment mahasiswa2Fragment = Mahasiswa2Fragment.newInstance(Message, "");
        ft.replace(R.id.mhsFrame, mahasiswa2Fragment);
        ft.commit();
    }

}
