package com.example.navigationdrawer.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends ViewModel {

     private MutableLiveData<String> mText;

     public SlideshowViewModel() {
          mText = new MutableLiveData<>();
          mText.setValue("Fragmento do Slideshow");
     }

     public LiveData<String> getText() {
          return mText;
     }
}