package com.example.viewpage.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewpage.R;

public class InscricoesFragment extends Fragment {

     public InscricoesFragment() {
          // Required empty public constructor
     }

     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
          // Inflate the layout for this fragment
          return inflater.inflate(R.layout.fragment_inscricoes, container, false);
     }
}