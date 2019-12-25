package com.pawan.esoftwarica.Model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AddModel()
    {
        mText=new MutableLiveData<>();
        mText.setValue("Add Student");
    }
    public LiveData<String> getText()
    {
        return mText;
    }

}
