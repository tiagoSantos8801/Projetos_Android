package com.cursoandroid.navigationdrawer;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Configura barra de navegação
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Cria referencia para toda a área do NavigationDrawer
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        //Cria referencia para a área de navegação
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Define configurações do NavigationDrawer (xml dos menus - layouts)
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_share, R.id.nav_send, R.id.nav_contato
        )
                .setDrawerLayout(drawer)
                .build();//Metodo que constroi de fato

        //Configura area que irá carregar os fragments - (content_main.xml )
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        //Configura menu superior de navegaçao - (Botao que e tres tracos)
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        //Configura navegacao para o NavigationView - (Navegacao propriamente dita, mudanca de fragmentos)
        NavigationUI.setupWithNavController(navigationView, navController);
    }
    //janela de Sttings retirada

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
