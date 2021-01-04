package com.example.cable.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.cable.Fragment.CurrentSubscriberFragment;
import com.example.cable.Adapter.PagerAdapter;
import com.example.cable.Fragment.PendingSubscriberFragment;
import com.example.cable.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    PagerAdapter pagerAdapter;
    ViewPager pager;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.viewPager);
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);
        setSupportActionBar(toolbar);



        Fragment[] fragments = new Fragment[2];
        fragments[0] = new CurrentSubscriberFragment();
        fragments[1] = new PendingSubscriberFragment();
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), fragments, new String[]{"Current", "Pending"}, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        pager.setAdapter(pagerAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show();
                break;
        }
            return super.onOptionsItemSelected(item);

    }


}