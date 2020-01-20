package com.example.adopet.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adopet.Data.DataUser;
import com.example.adopet.R;

import java.util.List;

public class AkunAdapter extends RecyclerView.Adapter<AkunAdapter.AkunViewHolder> {

    List<DataUser> akun;

    public AkunAdapter(List<DataUser> akun) {
        this.akun = akun;
    }

    @NonNull
    @Override
    public AkunViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_akun, viewGroup, false);
        AkunViewHolder akunViewHolder = new AkunViewHolder(v);
        return akunViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AkunViewHolder akunViewHolder, int position) {
        akunViewHolder.nama.setText(akun.get(position).getNama());
        akunViewHolder.namapengguna.setText(akun.get(position).getNamapengguna());
        akunViewHolder.email.setText(akun.get(position).getEmail());
        akunViewHolder.nowa.setText(akun.get(position).getNowhatsapp());
        akunViewHolder.provinsi.setText(akun.get(position).getProvinsi());
        akunViewHolder.kabupaten.setText(akun.get(position).getKabupaten());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class AkunViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView nama, namapengguna, email, nowa,  katasandi, provinsi, kabupaten;
        ImageView foto;
        public AkunViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = (TextView) itemView.findViewById(R.id.txtnamaakun);
            namapengguna = (TextView) itemView.findViewById(R.id.txtnamapenggunaakun);
            email = (TextView) itemView.findViewById(R.id.txtemailakun);
            nowa = (TextView) itemView.findViewById(R.id.txtnowaakun);
            provinsi = (TextView) itemView.findViewById(R.id.txtprovinsiakun);
            kabupaten = (TextView) itemView.findViewById(R.id.txtkabupatenakun);
        }
    }
}
