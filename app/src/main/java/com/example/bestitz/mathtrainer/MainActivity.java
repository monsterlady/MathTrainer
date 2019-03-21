package com.example.bestitz.mathtrainer;

import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView num1,num2,opreator,numofE;
    EditText answerScreen;
    //Button checkanswer;
    Button next;
    static int number1= 0,number2 =0,index =0;
    String []  opreators = {"+","-","*"};
    boolean isCorrect;
    static boolean isStrated = false;
    static int correctlyAnswere = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isCorrect = false;
        num1 = findViewById(R.id.NUM1);
        num2 = findViewById(R.id.NUM2);
        numofE =findViewById(R.id.NUMOFE);
        opreator = findViewById(R.id.OPREATOR);
        answerScreen = (EditText) findViewById(R.id.INPUT);
        next = findViewById(R.id.NextSum);
        if(isStrated){
            initView();
        }else{
            setRandomNum();
            initView();
        }


    }
    @Override
    public void onConfigurationChanged(Configuration newConfig){
        //System.out.println("waw.....");
        super.onConfigurationChanged(newConfig);
    }

    public void setRandomNum(){
        number1 = (int)(Math.random() * 9);
        number2 = (int)(Math.random() * 9);
        index = (int)(Math.random() * opreators.length);
        isStrated = true;
    }
    public void check(View view) {
        //isStrated = true;
        String answer = answerScreen.getText().toString();
        if(opreator.getText().toString().equals("+")){
            if(answer.equals(Integer.toString(number1 + number2))){
                correctlyAnswere++;
                answerScreen.setBackgroundColor(Color.GREEN);
                isCorrect = true;
            } else {
                answerScreen.setBackgroundColor(Color.RED);
            }
        } else if (opreator.getText().toString().equals("-")){
            if(answer.equals(Integer.toString(number1 - number2))){
                answerScreen.setBackgroundColor(Color.GREEN);
                correctlyAnswere++;
                isCorrect = true;
            } else {
                answerScreen.setBackgroundColor(Color.RED);
            }
        } else{
            if(answer.equals(Integer.toString(number1 * number2))){
                answerScreen.setBackgroundColor(Color.GREEN);
                correctlyAnswere++;
                isCorrect = true;
            }else {
                answerScreen.setBackgroundColor(Color.RED);
            }
        }
        initView();
    }
    public void initView(){
        //setRandomNum();
        num1.setText(Integer.toString(number1));
        num2.setText(Integer.toString(number2));
        opreator.setText(opreators[index]);
        if(isCorrect){
            next.setVisibility(View.VISIBLE);
            next.setText(R.string.button_next);
            next.setOnClickListener(this::nextSum);
        } else {
            //checkanswer.setVisibility(View.VISIBLE);
            next.setText(R.string.button_check);
            next.setOnClickListener(this::check);
            //next.setVisibility(View.GONE);
        }
        numofE.setText(String.format(String.format(getString(R.string.accieve) + " " + Integer.toString(correctlyAnswere) +" "+ getString(R.string.NumofE))));
    }
    public void nextSum(View view) {
        isCorrect = false;
        answerScreen.setText("");
        answerScreen.setBackgroundColor(Color.WHITE);
        setRandomNum();
        initView();
    }
}
