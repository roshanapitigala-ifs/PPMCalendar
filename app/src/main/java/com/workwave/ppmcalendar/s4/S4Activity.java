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
    S4VPAdapter vpAdapter;

    int currentMonth;

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
        vp.setCurrentItem(1, false);
        currentMonth = 6;
        vp.setOffscreenPageLimit(1);
        vpAdapter.setMonth(currentMonth, 1);

        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager2.SCROLL_STATE_IDLE) {
                    if (vp.getCurrentItem() == 0 && currentMonth == 1) // at the left edge, scrolling left
                        return;
                    if (vp.getCurrentItem() == 2 && currentMonth == 12) // at the right edge, scrolling right
                        return;

                    if (vp.getCurrentItem() == 1 && currentMonth == 1) // scrolled out of left edge
                        executeScrolledAction(true, false);
                    if (vp.getCurrentItem() == 1 && currentMonth == 12) // scrolled out of right edge
                        executeScrolledAction(true, true);
                    else if (vp.getCurrentItem() != 1) // scrolled
                        executeScrolledAction(false, false);
                }
            }

            private void executeScrolledAction(boolean fromAnEdge, boolean fromRightEdge){
                if ((fromAnEdge && fromRightEdge) || isLeftScrolled())
                    currentMonth--;
                else
                    currentMonth++;

                if (currentMonth > 1 && currentMonth < 12) {
                    vp.setCurrentItem(1, false);
                    vpAdapter.setMonth(currentMonth, 1);
                } else
                    vpAdapter.setMonth(currentMonth, vp.getCurrentItem());
            }

            private boolean isLeftScrolled(){
                return vp.getCurrentItem() == 0;
            }
        });
    }

    private class S4VPAdapter extends FragmentStateAdapter {

        ArrayList<S4MonthFragment> pages = new ArrayList<>();

        public S4VPAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            pages.add(new S4MonthFragment());
            pages.add(new S4MonthFragment());
            pages.add(new S4MonthFragment());
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return pages.get(position);
        }

        @Override
        public int getItemCount() {
            return 3;
        }

        public void setMonth(int month, int position){
            pages.get(position).setData((month < 10 ? "Month 0" : "Month ") + month);
        }
    }
}