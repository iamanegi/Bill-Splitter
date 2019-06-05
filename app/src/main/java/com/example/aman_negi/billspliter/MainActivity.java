package com.example.aman_negi.billspliter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edtnum;
    private Button btnEnter;
    int pnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtnum = findViewById(R.id.edtnum);
        btnEnter = findViewById(R.id.btnEnter);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pnum = Integer.parseInt(edtnum.getText().toString());

                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("nKey", pnum);
                startActivity(i);
                finish();
            }
        });

    }
}
