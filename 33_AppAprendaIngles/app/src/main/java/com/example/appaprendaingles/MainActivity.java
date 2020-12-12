package com.example.appaprendaingles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.appaprendaingles.Fragments.BichosFragment;
import com.example.appaprendaingles.Fragments.NumerosFragment;
import com.example.appaprendaingles.Fragments.VogaisFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

     private SmartTabLayout smartTabLayout;
     private ViewPager viewPager;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

          smartTabLayout = findViewById(R.id.viewPagerTab);
          viewPager = findViewById(R.id.viewPager);

          //Tirando sombra da ActionBar
          getSupportActionBar().setElevation(0);

          //Configurar adapter para as abas (fragments)
          FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                  getSupportFragmentManager(),//Pega gerenciador de fragmento
                  FragmentPagerItems.with(this)//Pega contexto
                          .add(R.string.bichos, BichosFragment.class)//Titulo(strings) e fragmento para cada aba do viewPager
                          .add(R.string.numeros, NumerosFragment.class)
                          .add(R.string.vogais, VogaisFragment.class)
                          .create()
          );

          //Setando adapter
          viewPager.setAdapter(adapter);

          //Setando a viewPager que tem o adapter
          smartTabLayout.setViewPager(viewPager);
     }
}