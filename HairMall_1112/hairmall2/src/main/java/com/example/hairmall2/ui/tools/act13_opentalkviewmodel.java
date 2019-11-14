package com.example.hairmall2.ui.tools;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class act13_opentalkviewmodel extends ViewModel {

    private MutableLiveData<String> mText;

    public act13_opentalkviewmodel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is tools fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}