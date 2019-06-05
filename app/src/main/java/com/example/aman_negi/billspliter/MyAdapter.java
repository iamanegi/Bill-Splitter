package com.example.aman_negi.billspliter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<SingleRow> singleRowArrayList;
    private LayoutInflater inflater;
    String p, temp;

    public MyAdapter(Context context, ArrayList<SingleRow> singleRowArrayList) {
        this.context = context;
        this.singleRowArrayList = singleRowArrayList;
    }

    @Override
    public int getCount() {
        return singleRowArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return singleRowArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row_layout, parent, false);
        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtSpend = view.findViewById(R.id.txtSpend);
        TextView txtGt = view.findViewById(R.id.txtGiveOrTake);

        SingleRow s = singleRowArrayList.get(position);
        txtName.setText(s.getName());
        txtSpend.setText(s.getSpend());
        if (s.getGt().contains("-")) {
            temp = s.getGt().replace('-', ' ');
            p = "Give ₹" + temp.trim();
        } else {
            p = "Take ₹" + s.getGt();
        }
        txtGt.setText(p);
        return view;
    }
}
