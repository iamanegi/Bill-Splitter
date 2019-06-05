package com.example.aman_negi.billspliter;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {
    TextView textView;
    private ListView lv;
    private SingleRow singleRow;
    private ArrayList<SingleRow> singleRowArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Bundle bundle = getIntent().getExtras();
        int num = bundle.getInt("num");
        String[] names = getIntent().getStringArrayExtra("strs");
        String[] expense = getIntent().getStringArrayExtra("expense");
        textView = findViewById(R.id.textView);
        lv = findViewById(R.id.listView);
        //calculations
        float[] individualSpend = new float[num];
        float[] giveOrTake = new float[num];
        for (int i = 0; i < num; i++) {
            individualSpend[i] = sumStringToInt(expense[i]);
        }

        float totalExpense = 0;
        for (float f : individualSpend) {
            totalExpense += f;
        }
        float individualExpense = totalExpense / num;

        for (int i = 0; i < num; i++) {
            giveOrTake[i] = individualSpend[i] - individualExpense;
        }

        //creating data source for listView
        singleRowArrayList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            singleRow = new SingleRow(names[i], individualSpend[i], giveOrTake[i]);
            singleRowArrayList.add(singleRow);
        }

        //setting data to views
        MyAdapter adapter = new MyAdapter(this, singleRowArrayList);
        lv.setAdapter(adapter);
        textView.append(String.valueOf(individualExpense));

    }

    private float sumStringToInt(String s) {
        float sum = 0;
        String[] t = s.split(",");
        //convert string array to float array
        for (int i = 0; i < t.length; i++) {
            if (!t[i].trim().equals(""))
                sum += Float.parseFloat(t[i].trim());
        }
        return sum;
    }
}
