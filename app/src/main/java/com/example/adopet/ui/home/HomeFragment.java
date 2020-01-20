package com.example.adopet.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adopet.DeskripsiAdopsi;
import com.example.adopet.Menu_utama;
import com.example.adopet.R;
import com.example.adopet.appvar;

import java.util.HashMap;

public class HomeFragment extends Fragment {
    private RecyclerView rchome;
    private HomeViewModel homeViewModel;
    private String JSON_STRING;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        rchome = root.findViewById(R.id.rchome);
        rchome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(getContext(), DeskripsiAdopsi.class);
                HashMap<String,String> map =(HashMap)parent.getItemAtPosition(position);
                String empId = map.get(appvar.KEY_ID).toString();
                intent.putExtra(appvar.EMP_ID,empId);
                startActivity(intent);*/
            }
        });
        return root;
    }
}