package com.example.tablayoutsample;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    VPAdapter vpAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.viewpager);
        vpAdapter =new VPAdapter(getSupportFragmentManager());
        //Add Fragment Here

        vpAdapter.addFragment(new Fragment1(),"");
        vpAdapter.addFragment(new Fragment2(),"");

        viewPager.setAdapter(vpAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.grid);
        tabLayout.getTabAt(1).setIcon(R.drawable.person_pin);

        //Remove Shadow From the action bar

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }
}