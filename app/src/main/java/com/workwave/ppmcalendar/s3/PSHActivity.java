package com.workwave.ppmcalendar.s3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.workwave.ppmcalendar.R;

public class PSHActivity extends FragmentActivity {

    RecyclerView rv;
    PSHRVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psh);
        setupCal();
    }

    private void setupCal() {
        rv = findViewById(R.id.pshrv);
        adapter = new PSHRVAdapter();
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(rv);
    }
}

class PSHRVAdapter extends RecyclerView.Adapter<PSHRVVH> {

    @NonNull
    @Override
    public PSHRVVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MonthPageView pageView = new MonthPageView();
        return new PSHRVVH(pageView, pageView.createView(LayoutInflater.from(parent.getContext()), parent));
    }

    @Override
    public void onBindViewHolder(@NonNull PSHRVVH holder, int position) {
        holder.setup();
    }

    @Override
    public int getItemCount() {
        return 12;
    }
}

class PSHRVVH extends RecyclerView.ViewHolder {

    private MonthPageView viewObj;

    public PSHRVVH(@NonNull View itemView) {
        super(itemView);
    }

    public PSHRVVH(MonthPageView obj, View view){
        this(view);
        viewObj = obj;
    }

    public void setup() {
        viewObj.setup();
    }
}
