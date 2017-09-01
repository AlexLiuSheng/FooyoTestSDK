package com.allenliu.sentosa;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import sg.fooyo.sdkosp.sdk.ui.FooyoSDKMapFragment;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navi);
        init();
//        startActivity(new Intent(this, FooyoPhotoCollageSplashActivity.class));
    }

    private void init() {
        fragments = new Fragment[5];
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                Fragment fragment = new MainFragment();
                fragments[i] = fragment;
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_containers, fragment).commit();
            } else if (i == 2) {
                final FooyoSDKMapFragment mapFragment = new FooyoSDKMapFragment();
                fragments[i] = mapFragment;
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_containers, mapFragment).commit();
            } else {
                Fragment fragment = new Fragment();
                fragments[i] = fragment;
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_containers, fragment).commit();
            }

        }
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                showFragment(item.getItemId());
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.navigation_map);
    }

    private void showFragment(final int itemId) {
        for (Fragment fragment : fragments) {
            getSupportFragmentManager().beginTransaction().hide(fragment).commit();
        }
        switch (itemId) {
            case R.id.navigation_explore:
                getSupportFragmentManager().beginTransaction().show(fragments[0]).commit();
                break;
            case R.id.navigation_plan:
                getSupportFragmentManager().beginTransaction().show(fragments[1]).commit();
                break;
            case R.id.navigation_map:
                getSupportFragmentManager().beginTransaction().show(fragments[2]).commit();
                break;
            case R.id.navigation_cart:
                getSupportFragmentManager().beginTransaction().show(fragments[3]).commit();
                break;
            case R.id.navigation_more:
                getSupportFragmentManager().beginTransaction().show(fragments[4]).commit();

                break;

        }
    }

}