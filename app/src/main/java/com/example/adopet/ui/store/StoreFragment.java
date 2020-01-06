package com.example.adopet.ui.store;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adopet.R;

public class StoreFragment extends Fragment {

    private StoreViewModel storeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        storeViewModel = ViewModelProviders.of(this).get(StoreViewModel.class);
        View root = inflater.inflate(R.layout.fragment_store, container, false);
        final TextView textView = root.findViewById(R.id.text_store);
        storeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

}
