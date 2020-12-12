package com.example.navigationdrawer.ui.email;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationdrawer.R;

public class emailFragment extends Fragment {

     public emailFragment() {
          // Required empty public constructor
     }

     @Override
     public View onCreateView(
             LayoutInflater inflater,
             ViewGroup container,
             Bundle savedInstanceState) {

          // Inflate the layout for this fragment
          return inflater.inflate(R.layout.fragment_email, container, false);
     }
}