package com.example.adopet.ui.akun;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.adopet.PengaturanAkun;
import com.example.adopet.R;
import com.example.adopet.Register;

public class AkunFragment extends Fragment {
    private Button btnpengaturan;
    private AkunViewModel akunViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        akunViewModel = ViewModelProviders.of(this).get(AkunViewModel.class);
        View root = inflater.inflate(R.layout.fragment_akun, container, false);
        Button btnpengaturan = root.findViewById(R.id.btnpengaturan);
                btnpengaturan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PengaturanAkun.class);
                startActivity(intent);
            }
        });
        return root;
    }
}