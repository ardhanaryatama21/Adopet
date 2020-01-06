package com.example.adopet.ui.cari;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CariViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CariViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("INI FRAGMENT CARI");
    }

    public LiveData<String> getText() {
        return mText;
    }
}