package com.example.hairmall2.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class act6_mainpageviewmodel extends ViewModel {

    private MutableLiveData<String> mText;

    public act6_mainpageviewmodel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}