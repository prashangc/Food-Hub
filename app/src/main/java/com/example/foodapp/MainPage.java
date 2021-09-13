package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    TabLayout tabLayout;
    ViewPager2 pager2;
    FragmentAdapter fragmentAdapter;

//    RecyclerView recyclerView;
//    LinearLayoutManager layoutManager;
//    List<ModelClass>userList;
//    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        drawer = findViewById(R.id.drawer_layout);
        final ImageView Menu = findViewById(R.id.menu);

        tabLayout = findViewById(R.id.tab_layout);
        pager2 = findViewById(R.id.view_pager2);

        FragmentManager fm = getSupportFragmentManager();
        fragmentAdapter = new FragmentAdapter(fm, getLifecycle());
        pager2.setAdapter(fragmentAdapter);

        tabLayout.addTab(tabLayout.newTab().setText("Foods"));
        tabLayout.addTab(tabLayout.newTab().setText("Drinks"));
        tabLayout.addTab(tabLayout.newTab().setText("Snacks"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_for_drawer,
//                    new ProfileFragment()).commit();
//        }

//
//        initData();
//        initRecyclerView();
    }
//
//    private void initData() {
//        userList = new ArrayList<>();
//        userList.add(new ModelClass(R.drawable.gojo, "Gojo", "10:45 AM", "How are you?", "------------------------"));
//        userList.add(new ModelClass(R.drawable.kaneki, "Kaneki", "01:30 PM", "Hi!", "------------------------"));
//        userList.add(new ModelClass(R.drawable.rin, "Rin", "9:20 AM", "Hey?", "------------------------"));
//        userList.add(new ModelClass(R.drawable.luffy, "Luffy", "07:15 AM", "Bye?", "------------------------"));
//        userList.add(new ModelClass(R.drawable.nishimiya, "Nishimiya", "12:15 AM", "Okay", "------------------------"));
//
//    }
//
//    private void initRecyclerView() {
//
//        recyclerView = findViewById(R.id.recycler_view);
//        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        adapter = new Adapter(userList);
//        recyclerView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//
//    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        final LinearLayout layout_for_main= findViewById(R.id.layout_for_main);
        switch (item.getItemId()) {
            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_for_drawer,
                        new ProfileFragment()).commit();
                        layout_for_main.setVisibility(LinearLayout.GONE);
                break;

            case R.id.notifications:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_for_drawer,
                        new NotificationFragment()).commit();
                        layout_for_main.setVisibility(LinearLayout.GONE);

                break;

            case R.id.settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_for_drawer,
                        new SettingsFragment()).commit();
                        layout_for_main.setVisibility(LinearLayout.GONE);

                break;

            case R.id.share:
                Toast.makeText(this, "Profile Shared", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}