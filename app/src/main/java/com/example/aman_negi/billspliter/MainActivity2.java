package com.example.aman_negi.billspliter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private LinearLayout linlayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        linlayout2 = findViewById(R.id.linlayout2);

        //getting the num of person from activity1
        Bundle bundle = getIntent().getExtras();
        final int num = bundle.getInt("nKey");

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(5, 10, 5, 10);

        //TextView
        TextView text = new TextView(this);
        text.setLayoutParams(lp);
        text.setTypeface(null, Typeface.BOLD);
        text.setTextColor(getResources().getColor(R.color.textColor));
        text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        text.setTextSize(30);
        text.setText("Enter the " + String.valueOf(num) + " names");
        linlayout2.addView(text);

        //EditTexts
        EditText edt;
        final ArrayList<EditText> allEdts = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            edt = new EditText(this);
            edt.setLayoutParams(lp);
            edt.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            text.setTextColor(getResources().getColor(R.color.textColor));
            edt.setTextSize(30);
            edt.setHint("Enter Name " + (i + 1));
            allEdts.add(edt);
            linlayout2.addView(edt);
        }

        //NextButton
        final Button nbtn = new Button(this);
        nbtn.setText("NEXT");
        nbtn.setTypeface(null, Typeface.BOLD);
        nbtn.setTextColor(getResources().getColor(R.color.textColor));
        nbtn.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        nbtn.setTextSize(25);
        linlayout2.addView(nbtn);

        //BackButton
        Button bbtn = new Button(this);
        bbtn.setText("Back");
        bbtn.setTypeface(null, Typeface.BOLD);
        bbtn.setTextColor(getResources().getColor(R.color.textColor));
        bbtn.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        bbtn.setTextSize(25);
        linlayout2.addView(bbtn);

        bbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
                finish();
            }
        });

        nbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Getting names from EditTexts
                boolean flag = false;
                String[] names = new String[allEdts.size()];
                for (int y = 0; y < allEdts.size(); y++) {
                    if (!allEdts.get(y).getText().toString().matches("")) {
                        names[y] = allEdts.get(y).getText().toString().trim();
                    } else {
                        flag = true;
                        Toast.makeText(MainActivity2.this, "All names not entered", Toast.LENGTH_SHORT).show();
                    }
                }
                if (!flag) {
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    intent.putExtra("strs", names);
                    intent.putExtra("num", num);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
}
