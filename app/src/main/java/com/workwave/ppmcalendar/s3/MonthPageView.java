package com.workwave.ppmcalendar.s3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.workwave.ppmcalendar.R;

public class MonthPageView {

    static volatile int sMonthId;

    private volatile int monthId;
    private View view;
    private GridView gv;
    private GVAdapter adapter;

    public MonthPageView() {
        monthId = ++sMonthId;
        System.out.println("Creating Month: " + monthId);
    }

    public void setup(){
        gv.setAdapter(adapter);
        ((TextView) view.findViewById(R.id.monthName)).setText(("Month " + monthId));
    }

    public View createView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        view = inflater.inflate(R.layout.gview_month, container, false);
        gv = view.findViewById(R.id.gvDates);
        adapter = new GVAdapter(inflater);
        return view;
    }
}

class GVAdapter extends BaseAdapter {

    LayoutInflater inflater;

    public GVAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return 42;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.cell_day, parent, false);

        ((TextView)convertView.findViewById(R.id.date)).setText(String.valueOf(++position));
        return convertView;
    }
}