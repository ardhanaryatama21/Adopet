package com.example.adopet.ui.pet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PetViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public PetViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("INI FRAGMENT PET");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
