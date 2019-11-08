package com.example.proteintracker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ProteinTrackerApp extends AppCompatActivity {
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protein_tracker_app);
        String contextMenus[]={"Protein","Vitamin","Mineral"};
        ListView lv = (ListView) findViewById(R.id.listViewMenu);
        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(ProteinTrackerApp.this,android.R.layout.simple_list_item_1,contextMenus);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);
        Button settingBtn = (Button)findViewById(R.id.btnSetting);
        settingBtn.setOnClickListener(settingButtonListener);
        SharedPreferences prefs = ProteinTrackerApp.this.getSharedPreferences("prefs_file",MODE_PRIVATE);
        String statusLogin = prefs.getString("isLogin",null);
        Button btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(myBtnLoginClick);
        if (statusLogin != null){
            btnLogin.setText("Logout");
        }else{
            btnLogin.setText("Login"); }
        Button resetBtn = (Button) findViewById(R.id.btnReset);
        resetBtn.setOnClickListener(rstButtonListener);
        progressDialog = new ProgressDialog(ProteinTrackerApp.this);
        progressDialog.setMessage("Melakukan sesuatu ...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    }

    private View.OnClickListener rstButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final Dialog dialog = new Dialog(ProteinTrackerApp.this);
            dialog.setContentView(R.layout.custom_dialog);
            dialog.setTitle("Custom Dialog");

            Button btnCustom = (Button) dialog.findViewById(R.id.btnCustom);
            btnCustom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
//            AlertDialog.Builder builder = new AlertDialog.Builder(ProteinTrackerApp.this);
//            builder.setMessage("Apakah anda yakin untuk mereset nilai protein?")
//                    .setNegativeButton("No", new DialogInterface.OnClickListener(){
//                        public void onClick(DialogInterface dialog, int which) {
//                            Toast.makeText(ProteinTrackerApp.this, "Tidak jadi reset",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//                    })
//                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialog, int which) {
//                    Toast.makeText(ProteinTrackerApp.this, "Melakukan RESET !!",
//                            Toast.LENGTH_SHORT).show();
//                    Thread thread = new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            try {
//                                Thread.sleep(3000);
//                                handler.sendEmptyMessage(0);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    });
//                    thread.start();
//                    progressDialog.show();
//                }
//            });
//            AlertDialog dialog = builder.create();
//            dialog.show();
//        }
//        private Handler handler = new Handler(){
//            public void handleMessage(android.os.Message msg){
//                progressDialog.dismiss();
//            }
//        };
    };

        private View.OnClickListener settingButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ProteinTrackerApp.this, SettingsActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener myBtnLoginClick = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            SharedPreferences prefs = ProteinTrackerApp.this.getSharedPreferences("prefs_file",MODE_PRIVATE);
            String statusLogin = prefs.getString("isLogin",null);
            SharedPreferences.Editor edit = prefs.edit();
            Button btnLogin = (Button)findViewById(R.id.btnLogin);
            if (statusLogin != null){
                edit.putString("isLogin",null);
                btnLogin.setText("Login");
            }else{
                edit.putString("isLogin","Admin");
                btnLogin.setText("Logout");
            }
            edit.commit();
        }
    };
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        menu.setHeaderTitle("silahkan memilih");
        menu.add(0,v.getId(),0,"Simpan");
        menu.add(0,v.getId(),0,"Tidak");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="Simpan"){
            Toast.makeText(getApplicationContext(),"Sedang Menyimpan, Harap Tunggu",Toast.LENGTH_LONG).show();
        }
        else if(item.getTitle()=="Tidak"){
            Toast.makeText(getApplicationContext(),"Tidak Jadi Menyimpan",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(getApplicationContext(),"Item 1 Terpilih",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(),"Item 2 Terpilih",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item3:
                Toast.makeText(getApplicationContext(),"Item 3 Terpilih",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
