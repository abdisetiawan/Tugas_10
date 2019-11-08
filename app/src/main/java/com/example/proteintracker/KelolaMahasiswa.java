package com.example.proteintracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class KelolaMahasiswa extends AppCompatActivity {

    String[] mhs = {"Brayen Chanzezar Saroinsong", "Arnold Stanley Rivaldy Tato", "Verina Kristanti Wiyono",
            "Yubelince Naomi Wakum", "Hendry Masiku", "Baskoro Adi Wicaksono", "Yos Rafel Kristanto",
            "Alfadeo Melody Jeremy Bulin", "Yashinta Novita Dewi", "Yalina Hosea", "Adrian Paskalis",
            "Desta Siwi P", "Cindy Claudya", "Angkie Octovaldo Elias Wangkay", "Christian Dorra",
            "Tita Marita Simangunsong", "Angga Dwi Kaharap", "Fransiska Ayu Gloria", "Mika Havennia Sirait",
            "Marni Eva Kristina Saragih", "Aristyo Rahadian Agung Nugroho", "Laurentia Yulia Cristi",
            "Putu Abdi Setiawan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola_mahasiswa);
        String contextMenus[]={"Edit","Delete"};
        ListView lv = findViewById(R.id.lvMhs);
        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(KelolaMahasiswa.this,android.R.layout.simple_list_item_1,contextMenus);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);

        lv.setAdapter(new ArrayAdapter<String>(KelolaMahasiswa.this, android.R.layout.simple_list_item_1, mhs));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) { //int i untuk tau urutan item
                Toast.makeText(KelolaMahasiswa.this, "Anda memilih " + mhs[i], Toast.LENGTH_SHORT).show(); //length short durasi krg lbh 2 dtk
                //javascript:Alert, C#:MessageBox, JavaAndroid: Toast
            }
        });

        Button addBtn = (Button)findViewById(R.id.btnAdd);
        addBtn.setOnClickListener(addButtonListener);

        Button editBtn = (Button)findViewById(R.id.btnUpdate);
        editBtn.setOnClickListener(editButtonListener);
    }
    private View.OnClickListener addButtonListener = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            Intent intent = new Intent(KelolaMahasiswa.this,tambah.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener editButtonListener = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            Intent intent = new Intent(KelolaMahasiswa.this,edit.class);
            startActivity(intent);
        }
    };

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        menu.setHeaderTitle("silahkan memilih");
        menu.add(0,v.getId(),0,"Edit");
        menu.add(0,v.getId(),0,"Delete");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="Edit"){
            Toast.makeText(getApplicationContext(),"Edit Dipilh",Toast.LENGTH_LONG).show();
        }
        else if(item.getTitle()=="Delete"){
            Toast.makeText(getApplicationContext(),"Delete Dipilih",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu){
        getMenuInflater().inflate(R.menu.menumahasiswa,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(getApplicationContext(),"Fragment Terpilih",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(),"Add Mahasiswa Terpilih",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
