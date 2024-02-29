package com.workwave.ppmcalendar.s1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.workwave.ppmcalendar.R;

public class MainActivity extends FragmentActivity {

    ViewPager2 vp;
    FragmentStateAdapter vpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupCal();
    }

    private void setupCal() {
        vp = findViewById(R.id.viewPager);
        vpAdapter = new VPAdapter(this);
        vp.setAdapter(vpAdapter);
//        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageSelected(int position) {
//                System.out.println("VP:" + position);
//            }
//        });
//        vp.setCurrentItem(1000);
        vp.setOffscreenPageLimit(1);
    }

    private class VPAdapter extends FragmentStateAdapter {

        public VPAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return new MonthPageFragment();
        }

        @Override
        public int getItemCount() {
            return Integer.MAX_VALUE;
        }
    }
}