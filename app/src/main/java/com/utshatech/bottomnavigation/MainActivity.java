package com.utshatech.bottomnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.utshatech.bottomnavigation.fragments.DashboardFragment;
import com.utshatech.bottomnavigation.fragments.HomeFragment;
import com.utshatech.bottomnavigation.fragments.NotificationFragment;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        new FragmentSwitcher().switchToHomeFragment();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentSwitcher fragmentSwitcher = new FragmentSwitcher();

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragmentSwitcher.switchToHomeFragment();
                return true;
            case R.id.navigation_dashboard:
                fragmentSwitcher.switchToDashboardFragment();
                return true;
            case R.id.navigation_notifications:
                fragmentSwitcher.switchToNotificationFragment();
                return true;
        }
        return false;
    }


    private class FragmentSwitcher {
        private FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        void switchToHomeFragment() {
            fragmentTransaction.replace(R.id.fragment, new HomeFragment());
            fragmentTransaction.commit();
        }

        void switchToDashboardFragment() {
            fragmentTransaction.replace(R.id.fragment, new DashboardFragment());
            fragmentTransaction.commit();
        }

        void switchToNotificationFragment() {
            fragmentTransaction.replace(R.id.fragment, new NotificationFragment());
            fragmentTransaction.commit();
        }
    }
}
