package com.workwave.ppmcalendar.s1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.workwave.ppmcalendar.R;

public class MonthPageFragment extends Fragment {

    static int sMonthId;

    private int monthId;
    private View view;
    private RecyclerView rv;

    public MonthPageFragment() {
        monthId = ++sMonthId;
        System.out.println("Creating Month: " + monthId);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_month, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv = view.findViewById(R.id.fragMonthRV);
        rv.setAdapter(new RVAdapter());
        rv.setLayoutManager(new GridLayoutManager(view.getContext(), 7));

        ((TextView) view.findViewById(R.id.monthName)).setText(("Month " + monthId));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.err.println("Destroy Month: " + monthId);
    }
}

class RVAdapter extends RecyclerView.Adapter<RVVH> {

    private int date = 1;

    @NonNull
    @Override
    public RVVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RVVH(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_day, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RVVH holder, int position) {
        holder.setData(date++);
    }

    @Override
    public int getItemCount() {
        return 42;
    }
}

class RVVH extends RecyclerView.ViewHolder{

    private TextView dateTV;

    public RVVH(@NonNull View itemView) {
        super(itemView);
        dateTV = itemView.findViewById(R.id.date);
    }

    public void setData(int date){
        dateTV.setText(String.valueOf(date));
    }
}
