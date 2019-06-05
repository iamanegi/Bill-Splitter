package com.example.aman_negi.billspliter;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    private LinearLayout linlayout3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        linlayout3 = findViewById(R.id.linlayout3);

        Bundle bundle = getIntent().getExtras();
        final int num = bundle.getInt("num");
        final String[] names = getIntent().getStringArrayExtra("strs");

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(5, 10, 5, 10);

        //TextView
        TextView text = new TextView(this);
        text.setLayoutParams(lp);
        text.setTypeface(null, Typeface.BOLD);
        text.setTextColor(getResources().getColor(R.color.textColor));
        text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        text.setTextSize(25);
        text.setText("Enter the money spend by each person separated by comma ','");
        linlayout3.addView(text);

        //EditTexts
        EditText edt;
        TextView textView;
        final ArrayList<EditText> allEdts = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            edt = new EditText(this);
            edt.setLayoutParams(lp);
            text.setTextColor(getResources().getColor(R.color.textColor));
            edt.setTextSize(20);
            edt.setHint("0.00,0.00,......");
            allEdts.add(edt);
            //Person Name
            textView = new TextView(this);
            textView.setLayoutParams(lp);
            textView.setTextColor(getResources().getColor(R.color.textColor));
            textView.setTextSize(20);
            textView.setText("Money spend by " + names[i]);
            linlayout3.addView(textView);
            linlayout3.addView(edt);
        }

        //NextButton
        final Button btnCalculate = new Button(this);
        btnCalculate.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        btnCalculate.setText("Calculate");
        btnCalculate.setTypeface(null, Typeface.BOLD);
        btnCalculate.setTextColor(getResources().getColor(R.color.textColor));
        btnCalculate.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btnCalculate.setTextSize(20);
        linlayout3.addView(btnCalculate);

        final String[] expense = new String[allEdts.size()];

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                for (int i = 0; i < allEdts.size(); i++) {
                    expense[i] = allEdts.get(i).getText().toString();
                    intent.putExtra("strs", names);
                    intent.putExtra("num", num);
                    intent.putExtra("expense", expense);
                }
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder backAlertDialog = new AlertDialog.Builder(this);
        backAlertDialog.setCancelable(false);
        backAlertDialog.setTitle("Exit");
        backAlertDialog.setMessage("Do you want to exit?");
        backAlertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity3.super.onBackPressed();
            }
        });
        backAlertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        backAlertDialog.create().show();
    }
}
