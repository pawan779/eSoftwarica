package com.pawan.esoftwarica.Model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AboutModel extends ViewModel {
    private MutableLiveData<String> mText;

    public AboutModel(){
        mText = new MutableLiveData<>();
        mText.setValue("This is AboutUs fragment");
    }
    public LiveData<String> getText() {
        return mText;
    }
}
