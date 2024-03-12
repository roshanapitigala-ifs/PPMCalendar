package com.workwave.ppmcalendar.s4;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.workwave.ppmcalendar.R;

public class S4MonthFragment extends Fragment {

    static int sFragId;

    private int fragId;
    private GridView gridView;
    private TextView monthNameTV;

    private String monthNameStr;

    public S4MonthFragment() {
        fragId = ++sFragId;
        System.out.println("Creating Frag: " + fragId);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_gv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridView = view.findViewById(R.id.gridView);
        monthNameTV = view.findViewById(R.id.monthName);
        gridView.setAdapter(new S4GVAdapter(this.getActivity()));
        monthNameTV.setText(monthNameStr);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.err.println("Destroy Frag: " + fragId);
    }

    public void setData(String monthName) {
        monthNameStr = monthName;
        if (monthNameTV != null)
            monthNameTV.setText(monthNameStr);
    }
}

class S4GVAdapter extends BaseAdapter {

    Context context;

    S4GVAdapter(Context c){
        context = c;
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.cell_day, parent, false);
        setData(position, convertView);
        return convertView;
    }

    private void setData(int position, View cell){
        ((TextView)cell.findViewById(R.id.date)).setText((position < 9? "0" : "") + (position + 1));
    }
}