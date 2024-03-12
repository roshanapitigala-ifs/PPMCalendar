package com.workwave.ppmcalendar.s4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.workwave.ppmcalendar.R;

import java.util.ArrayList;

public class S4Activity extends FragmentActivity {

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
        vpAdapter = new S4VPAdapter(this);
        vp.setAdapter(vpAdapter);
//        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageSelected(int position) {
//                System.out.println("VP:" + position);
//            }
//        });
        vp.setCurrentItem(1);
        vp.setOffscreenPageLimit(1);
    }

    private class S4VPAdapter extends FragmentStateAdapter {

        ArrayList<S4MonthFragment> pages = new ArrayList<>();

        public S4VPAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            pages.add(null);
            pages.add(null);
            pages.add(null);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            if (pages.get(position) == null) {
                S4MonthFragment monthFrag = new S4MonthFragment();
                monthFrag.setData((position < 9 ? "Month 0" : "Month") + (position+1));
                pages.set(position, monthFrag);
            }
            return pages.get(position);
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }
}