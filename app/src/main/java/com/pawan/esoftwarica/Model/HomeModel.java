package com.pawan.esoftwarica.Model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeModel extends ViewModel {
    private MutableLiveData<String> mText;

    public HomeModel()
    {
        mText=new MutableLiveData<>();
        mText.setValue("Home Fragment");
    }
    public LiveData<String> getText()
    {
        return mText;
    }
}
