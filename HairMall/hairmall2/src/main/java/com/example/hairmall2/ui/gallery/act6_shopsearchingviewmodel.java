package com.example.hairmall2.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class act6_shopsearchingviewmodel extends ViewModel {

    private MutableLiveData<String> mText;

    public act6_shopsearchingviewmodel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}