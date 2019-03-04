package com.example.bestitz.mathtrainer;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView num1,num2,opreator;
    EditText answerScreen;
    int number1,number2;
    String []  opreators = {"+","-","*"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.NUM1);
        num2 = findViewById(R.id.NUM2);
        opreator = findViewById(R.id.OPREATOR);
        answerScreen = (EditText) findViewById(R.id.INPUT);
        setRandomNum();
    }
    public void setRandomNum(){
        number1 = (int)(Math.random() * 9);
        number2 = (int)(Math.random() * 9);
        num1.setText(Integer.toString(number1));
        num2.setText(Integer.toString(number2));
        int index = (int)(Math.random() * opreators.length);
        opreator.setText(opreators[index]);
    }
    public void check(View view) {
        String answer = answerScreen.getText().toString();
        if(opreator.getText().toString().equals("+")){
            if(answer.equals(Integer.toString(number1 + number2))){
                answerScreen.setBackgroundColor(Color.GREEN);
            } else {
                answerScreen.setBackgroundColor(Color.RED);
            }
        } else if (opreator.getText().toString().equals("-")){
            if(answer.equals(Integer.toString(number1 - number2))){
                answerScreen.setBackgroundColor(Color.GREEN);
            } else {
                answerScreen.setBackgroundColor(Color.RED);
            }
        } else{
            if(answer.equals(Integer.toString(number1 * number2))){
                answerScreen.setBackgroundColor(Color.GREEN);
            }else {
                answerScreen.setBackgroundColor(Color.RED);
            }
        }
    }
    public void nextSum(View view) {
        answerScreen.setText("");
        answerScreen.setBackgroundColor(Color.WHITE);
        setRandomNum();
    }
}
