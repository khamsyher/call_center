package com.example.call_center;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.call_center.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Toolbar toolbar;
    private static  final int PERMISSION_REQUEST_CODE=200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer=(DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView=(NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        int id=item.getItemId();
        FragmentTransaction ft;
        String strTittle="";
        if (id == R.id.nav_aboutme) {
            fm_aboutme fm=new fm_aboutme();
            strTittle="About me";
            if(fm != null){
                ft=getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.maincontent,fm);
                ft.commit();
                toolbar.setTitle(strTittle);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatemaentWithEmptybody")
    @Override
    public boolean onNavigationItemSelected( MenuItem item) {
        Fragment fm=null;
        FragmentTransaction ft;
        String strTittle="";
        switch (item.getItemId()){
            case  R.id.nav_main:
                fm=new fm_main();
                strTittle="Main";
                break;
            case R.id.nav_emergency:
                fm=new fm_emergency();
                strTittle="Emergency";
                break;
            case R.id.nav_aboutme:
                fm=new fm_aboutme();
                strTittle="About me";
                break;
            case R.id.nav_help:
                fm=new fm_help();
                strTittle="Help me";
                break;
            case R.id.nav_facebook:
                try{
                    String url="http://www.facebook.com";
                    Intent it=new Intent(Intent.ACTION_VIEW);
                    it.setData(Uri.parse(url));
                    startActivity(it);
                    break;
                }catch (NullPointerException e){
                    break;
                }
        }
        if(fm != null){
            ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.maincontent,fm);
            ft.commit();
            toolbar.setTitle(strTittle);
        }
        DrawerLayout drawer=(DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}