package com.example.regitrationnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String[]name = {"Prasanjit Ram","Pratyush","Nitya"};
    private int regNo[] = {1901106313,1901106318,1901106342};
    private TextView text;
    private EditText edit;
    private Button show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView);
        edit = findViewById(R.id.editText);
        show  = findViewById(R.id.button);
        View.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show.setBackgroundColor(Color.parseColor("#FF0000"));


            }
        };

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
                int number = Integer.parseInt(edit.getText().toString());
                int color = Color.parseColor("#008000");
                show.setBackgroundColor(color);
                text.setText(getName(number));
            }
        };
        edit.setOnClickListener(listener1);
        show.setOnClickListener(listener);
    }

    private String getName(int num) {
        int count = 0;
        int c= 0;
        for(int n = 0;n<regNo.length;n++)
        {
            if(num==regNo[n]) {
                count = n;
                c++;
            }

        }
        if(c==1)
        return name[count];
        else
            return "Invalid Registration Number";
    }
}
