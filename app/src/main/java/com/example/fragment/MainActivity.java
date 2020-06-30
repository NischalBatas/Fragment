package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav= findViewById(R.id.nav_bottom_id);
        bottomNav.setOnNavigationItemSelectedListener(navListner);

        //default fragment display garcha
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_id, new HomeFrag()).commit();

    }

    BottomNavigationView.OnNavigationItemSelectedListener navListner =  new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            Fragment selectedFragment =null;
            switch (menuItem.getItemId()){
                case R.id.home_id:
                    selectedFragment =new HomeFrag();
                    break;
                case R.id.search_id:
                    selectedFragment =new SearchFrag();
                    break;
                case R.id.message_id:
                    selectedFragment =new MessageFrag();
            }
            // aba fragment lai display garnay code
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_id, selectedFragment).commit();
            return true;
        }
    };
}
