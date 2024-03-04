package com.workwave.ppmcalendar.s2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.HorizontalGridView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.workwave.ppmcalendar.R;
import com.workwave.ppmcalendar.s1.MainActivity;

public class GVActivity extends FragmentActivity {

    HorizontalGridView gv;
    HGVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gv);
        setupCal();
    }

    private void setupCal() {
        gv = findViewById(R.id.gridView);
        adapter = new HGVAdapter();
        gv.setAdapter(adapter);
        gv.setNumRows(6);
    }
}
class HGVAdapter extends RecyclerView.Adapter<HGVH> {

    private int date = 1;

    @NonNull
    @Override
    public HGVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HGVH(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_day, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HGVH holder, int position) {
        holder.setData(date++);
    }

    @Override
    public int getItemCount() {
        return 100;
    }
}

class HGVH extends RecyclerView.ViewHolder{

    private TextView dateTV;

    public HGVH(@NonNull View itemView) {
        super(itemView);
        dateTV = itemView.findViewById(R.id.date);
    }

    public void setData(int date){
        dateTV.setText(String.valueOf(date));
    }
}