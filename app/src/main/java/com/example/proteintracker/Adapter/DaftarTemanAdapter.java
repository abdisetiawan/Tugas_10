package com.example.proteintracker.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proteintracker.Model.DaftarTeman;
import com.example.proteintracker.R;

import java.util.ArrayList;

public class DaftarTemanAdapter extends RecyclerView.Adapter<DaftarTemanAdapter.ViewHolder> {

    ArrayList<DaftarTeman>DaftartemanArraylist;
    public DaftarTemanAdapter(ArrayList<DaftarTeman> daftartemanArraylist) {
        DaftartemanArraylist = daftartemanArraylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup  parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_tmn,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder Teman, int Position) {
        Teman.txtTmn.setText(DaftartemanArraylist.get(Position).getNama());
        Teman.txtNim.setText(DaftartemanArraylist.get(Position).getNim());
        Teman.txtCita.setText(DaftartemanArraylist.get(Position).getCita2());
        Teman.txtHobby.setText(DaftartemanArraylist.get(Position).getHobby());
        Teman.txtMoto.setText(DaftartemanArraylist.get(Position).getMotohidup());
        Teman.txtgender.setText(DaftartemanArraylist.get(Position).getGender());
        Teman.img1.setImageResource(DaftartemanArraylist.get(Position).getImg());
    }

    @Override
    public int getItemCount() {

        return (DaftartemanArraylist !=null) ? DaftartemanArraylist.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtTmn,txtNim,txtCita,txtHobby,txtMoto,txtgender;
        private ImageView img1;

        public ViewHolder(View view){
            super(view);
            txtTmn = view.findViewById(R.id.txt_tmn);
            txtNim = view.findViewById(R.id.txt_nimtmn);
            txtCita = view.findViewById(R.id.txt_cita2tmn);
            txtHobby = view.findViewById(R.id.txt_hbtmn);
            txtMoto = view.findViewById(R.id.txt_mttmn);
            txtgender = view.findViewById(R.id.txt_Gender);
            img1 =view.findViewById(R.id.imageView2);

        }
    }
}