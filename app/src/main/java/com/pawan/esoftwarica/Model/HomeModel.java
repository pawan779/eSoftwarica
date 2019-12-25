package com.pawan.esoftwarica.Model;

import androidx.lifecycle.MutableLiveData;

public class HomeModel {
    private MutableLiveData<String> mText;

    public HomeModel()
    {
        mText=new MutableLiveData<>();
        mText.setValue("Home Fragment");
    }
    public
}
