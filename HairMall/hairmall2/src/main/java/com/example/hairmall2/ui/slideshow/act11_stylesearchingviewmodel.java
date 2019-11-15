package com.example.hairmall2.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class act11_stylesearchingviewmodel extends ViewModel {

    private MutableLiveData<String> mText;

    public act11_stylesearchingviewmodel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}