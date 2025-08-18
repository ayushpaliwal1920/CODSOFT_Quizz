package com.fristandroidproject.qizzz;// In MainActivity.java
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

import com.fristandroidproject.qizzz.HomeFragment;
import com.fristandroidproject.qizzz.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // activity_main.xml should have a FrameLayout

        if (savedInstanceState == null) { // Only add the fragment if not restoring from a previous state
            HomeFragment homeFragment = new HomeFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.wrapContainer, homeFragment);
            fragmentTransaction.commit();
        }
    }
}