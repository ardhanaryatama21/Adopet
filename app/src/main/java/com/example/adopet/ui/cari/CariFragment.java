package com.example.adopet.ui.cari;

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

import com.example.adopet.R;

public class CariFragment extends Fragment {

    private CariViewModel cariViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cariViewModel =
                ViewModelProviders.of(this).get(CariViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cari, container, false);

        return root;
    }
}