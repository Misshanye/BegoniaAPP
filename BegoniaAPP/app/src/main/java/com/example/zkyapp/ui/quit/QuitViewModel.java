package com.example.zkyapp.ui.quit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuitViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public QuitViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is quit fragment");
    }
    public LiveData<String> getText() {
        return mText;
    }
}
