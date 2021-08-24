package com.example.funmath;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ToggleButton tg1, tg2, tg3, tg4;
    private EditText e1;
    private Button b1, b2;
    private TextView textview,textwrite;
    private ArrayList<String> arrayList;
    private Random rand, rand2;
    private int randnumber, randoper;
    private int count = 0;
    private int answer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<>();
        tg1 = findViewById(R.id.toggleButton);
        tg2 = findViewById(R.id.toggleButton2);
        tg3 = findViewById(R.id.toggleButton3);
        tg4 = findViewById(R.id.toggleButton4);
        e1 = findViewById(R.id.editTextTextPersonName);
        textview = findViewById(R.id.textView5);
        textwrite=findViewById(R.id.textView6);
        b2 = findViewById(R.id.button6);
        b1 = findViewById(R.id.button5);
        rand = new Random();
        rand2 = new Random();

        tg1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    arrayList.add("+");
                } else {
                    arrayList.remove("+");
                }
            }
        });
        tg2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    arrayList.add("*");
                } else {
                    arrayList.remove("*");
                }
            }
        });
        tg3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    arrayList.add("/");
                } else {
                    arrayList.remove("/");
                }
            }
        });
        tg4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    arrayList.add("-");
                } else {
                    arrayList.remove("-");
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (arrayList.size() > 0) {
                    count++;
                    String operand, answer = "";


                    int a = QuestiondigitMaker();

                    int b = QuestiondigitMaker();

                    int c = QuestionoperMaker();

                    operand = arrayList.get(c);

                    answer += a + " " + arrayList.get(c) + " " + b;


                    textview.setText(answer);
                    answer1 = calculate(a, b, operand);

                } else {
                    textview.setText("Please Choose Operator");
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String checking=e1.getText().toString();
                if(!TextUtils.isEmpty(checking)){
                    int eded=Integer.parseInt(e1.getText().toString());
                   if(eded==answer1){
                       textwrite.setText("You are True");

                   }
                   else{
                       textwrite.setText("You are False");
                   }

                }
                else{
                    textwrite.setText("EDED DAXIL EDIN!!!!");


                }

            }
        });



    }
        public int QuestiondigitMaker () {
            randnumber = rand.nextInt(10) + 1;
            return randnumber;
        }

        public int QuestionoperMaker () {
            randoper = rand2.nextInt(arrayList.size());
            return randoper;
        }

        public int calculate ( int a, int b, String c){
            switch (c) {
                case "+":
                    return a + b;
                case "-":
                    return a - b;
                case "/":
                    return a / b;
                case "*":
                    return a * b;
            }
            return 0;
        }
    }