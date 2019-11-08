package com.example.proteintracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.proteintracker.Model.DaftarTeman;
import com.example.proteintracker.Model.DaftartemanAdapter;

import java.util.ArrayList;

public class DaftarTemanActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DaftartemanAdapter daftartemanAdapter;
    private ArrayList<DaftarTeman> Daftartemanarrylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_teman);
        addData();
        recyclerView = findViewById(R.id.RecTeman);
        daftartemanAdapter = new DaftartemanAdapter(Daftartemanarrylist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DaftarTemanActivity.this);
        recyclerView .setLayoutManager(layoutManager);
        recyclerView .setAdapter( daftartemanAdapter );
    }
    private  void addData(){
        Daftartemanarrylist =  new ArrayList<>();
        Daftartemanarrylist.add(new DaftarTeman("Alfadeo Bulin","72170106","main layangan","pengacara","sing penting yakin","Laki-Laki", R.drawable.deo));
        Daftartemanarrylist.add(new DaftarTeman("Christian Dorra","72170148","Makan","Terbang","tetap kuat seperti larry","Laki-Laki", R.drawable.dorra));
        Daftartemanarrylist.add(new DaftarTeman("Adrian Paskalis","72170125","cukur","Barber","yang penting makan","Laki Laki", R.drawable.adrian));
        Daftartemanarrylist.add(new DaftarTeman("Desta Siwi Prabawan","72170126","olahraga","nikah","beyond limit","Laki-laki", R.drawable.desta));
    }
}
