package com.example.calculator;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Stack;

import static com.example.calculator.R.drawable.*;
import static com.example.calculator.R.id.*;
import static com.example.calculator.R.id.color_btn;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView editText;
    TextView answer;

    private BigDecimal summ = BigDecimal.valueOf(0);
    private BigDecimal current = BigDecimal.valueOf(0);

    private int foo = 0;
    private boolean iswriting = true;
    private boolean flag = true;
    private boolean dotChecker = false;


    /*private Stack<Double> numbers = new Stack<>();*/
    private LinearLayout mainLayout;


    @TargetApi(Build.VERSION_CODES.KITKAT)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* Objects.requireNonNull(getSupportActionBar()).hide();*/

        editText = findViewById(R.id.editText);
        answer = findViewById(R.id.answer);

        final Button ZERO = findViewById(button0);
        final Button ONE = findViewById(button1);
        final Button TWO = findViewById(button2);
        final Button THREE = findViewById(button3);
        final Button FOUR = findViewById(button4);
        final Button FIVE = findViewById(button5);
        final Button SIX = findViewById(button6);
        final Button SEVEN = findViewById(button7);
        final Button EIGHT = findViewById(button8);
        final Button NINE = findViewById(button9);

        final Button PLUS = findViewById(buttonPLUS);
        final Button MINUS = findViewById(buttonMINUS);
        final Button EQUAL = findViewById(buttonEQUAL);
        final Button DEL = findViewById(buttonDEL);
        final Button DIV = findViewById(buttonDIV);
        final Button MUL = findViewById(buttonMUL);
        final Button PM = findViewById(buttonPLUSMINUS);
        final Button DellLastSymbol = findViewById(buttonDellLastSymbol);
        final Button BAN = findViewById(buttonDellLastNumber);
        final Button DOT = findViewById(buttonDOT);
        final Button color_btn = findViewById(R.id.color_btn);

        mainLayout = findViewById(R.id.mainLayout);


        ZERO.setOnClickListener(this);
        ONE.setOnClickListener(this);
        TWO.setOnClickListener(this);
        THREE.setOnClickListener(this);
        FOUR.setOnClickListener(this);
        FIVE.setOnClickListener(this);
        SIX.setOnClickListener(this);
        SEVEN.setOnClickListener(this);
        EIGHT.setOnClickListener(this);
        NINE.setOnClickListener(this);

        EQUAL.setOnClickListener(this);
        PLUS.setOnClickListener(this);
        MINUS.setOnClickListener(this);
        DEL.setOnClickListener(this);
        BAN.setOnClickListener(this);
        DIV.setOnClickListener(this);
        MUL.setOnClickListener(this);
        PM.setOnClickListener(this);
        DellLastSymbol.setOnClickListener(this);
        DOT.setOnClickListener(this);
        color_btn.setOnClickListener(this);

        color_btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                mainLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary2));
                ZERO.setBackground(getDrawable(button_standart));
                ONE.setBackground(getDrawable(button_standart));
                TWO.setBackground(getDrawable(button_standart));
                THREE.setBackground(getDrawable(button_standart));
                FOUR.setBackground(getDrawable(button_standart));
                FIVE.setBackground(getDrawable(button_standart));
                SIX.setBackground(getDrawable(button_standart));
                SEVEN.setBackground(getDrawable(button_standart));
                EIGHT.setBackground(getDrawable(button_standart));
                NINE.setBackground(getDrawable(button_standart));
                PM.setBackground(getDrawable(button_standart));
                DOT.setBackground(getDrawable(button_standart));

                color_btn.setBackground(getDrawable(button_numbers));
                EQUAL.setBackground(getDrawable(button_numbers));
                PLUS.setBackground(getDrawable(button_numbers));
                MINUS.setBackground(getDrawable(button_numbers));
                DEL.setBackground(getDrawable(button_numbers));
                DIV.setBackground(getDrawable(button_numbers));
                BAN.setBackground(getDrawable(button_numbers));
                MUL.setBackground(getDrawable(button_numbers));
                DellLastSymbol.setBackground(getDrawable(button_numbers));


            }
        });

    }

    public void Check()
    {
        String str = answer.getText().toString().trim();
        if (str.length() != 0) {
            str = str.substring(0, 1);
        }
        if(flag || ((str.equals("0"))&&(answer.length()==1)))  {
            answer.setText("");
            flag = false;
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {

        if (iswriting) {
            answer.setText("");
            iswriting = false;
        }

        switch (v.getId()) {
            case button0:
                Check();
                answer.setText(answer.getText() + "0");
                break;
            case button1:
                Check();
                answer.setText(answer.getText() + "1");
                break;
            case button2:
                Check();
                answer.setText(answer.getText() + "2");
                break;
            case button3:
                Check();
                answer.setText(answer.getText() + "3");
                break;
            case button4:
                Check();
                answer.setText(answer.getText() + "4");
                break;
            case button5:
                Check();
                answer.setText(answer.getText() + "5");
                break;
            case button6:
                Check();
                answer.setText(answer.getText() + "6");
                break;
            case button7:
                Check();
                answer.setText(answer.getText() + "7");
                break;
            case button8:
                Check();
                answer.setText(answer.getText() + "8");
                break;
            case button9:
                Check();
                answer.setText(answer.getText() + "9");
                break;


            case buttonPLUS:
                somefoo(foo);
                foo = 1;
                editText.setText(editText.getText() + " + ");
                break;
            case buttonMINUS:
                somefoo(foo);
                foo = 2;
                editText.setText(editText.getText() + " - ");
                break;
            case buttonMUL:
                somefoo(foo);
                foo = 3;
                editText.setText(editText.getText() + " × ");
                break;
            case buttonDIV:
                somefoo(foo);
                foo = 4;
                editText.setText(editText.getText() + " ÷ ");
                break;


            case buttonEQUAL:
                somefoo(foo);
                foo = 0;
                flag = true;
                editText.setText("");
                iswriting = false;
                break;
            case buttonDEL:
                foo = 0;
                summ = BigDecimal.valueOf(0);
                iswriting = true;
                editText.setText("");
                answer.setText("0");
                break;
            case buttonPLUSMINUS:
                somefoo(5);
                break;
            case buttonDellLastSymbol:
                    String str = answer.getText().toString();
                    if (str.length() != 0) {
                        str = str.substring(0, str.length() - 1);
                        answer.setText(str);
                    }
                if(answer.length() == 0) {
                    answer.setText("0");
                }
                break;

            case buttonDellLastNumber:
                    answer.setText("0");
                break;

            case buttonDOT:
                if(!dotChecker) {
                    dotChecker = true;
                    answer.setText(answer.getText() + ".");
                }
                break;

        }
    }

    @SuppressLint("SetTextI18n")
    private void Print(BigDecimal summ, BigDecimal current)
    {
        if(summ.doubleValue() == summ.intValue())
            answer.setText(String.valueOf(summ.intValue()));
        else answer.setText(String.valueOf(summ));

        if(current.doubleValue() == current.intValue())
            editText.setText(editText.getText() + String.valueOf(current.intValue()));
        else editText.setText(editText.getText() + String.valueOf(current));

        iswriting = true;
    }

    private void somefoo(int foo)
    {
        /*if(answer.getText().toString().equals(""))
            answer.setText("0");*/

        dotChecker = false;

        try {
            current = BigDecimal.valueOf(Double.parseDouble(answer.getText().toString()));}
        catch (Exception e){
            answer.setText("0");
            current = BigDecimal.valueOf(Double.parseDouble(answer.getText().toString()));
            Toast toast3 = Toast.makeText(getApplicationContext(),"Сработало исключение",Toast.LENGTH_SHORT);
            toast3.show();
        }



        switch (foo) {
            case 0:
                summ = current;
                Print(summ, current);
                break;
            case 1://plus
                summ = summ.add(current);
                Print(summ, current);
                break;
            case 2://minus
                summ = summ.subtract(current);
                Print(summ, current);
                break;
            case 3://multiple
                summ = summ.multiply(current);
                Print(summ, current);
                break;
            case 4://div
                try{
                summ = (summ.divide(current, 10, BigDecimal.ROUND_FLOOR));}
                catch(Exception e) {
                    Toast toast4 = Toast.makeText(getApplicationContext(),"Где-то поперхнулась одна \nЛобова Елена Алексеевна",Toast.LENGTH_SHORT);
                    toast4.show();
                }
                Print(summ, current);
                break;
            case 5://plus/minus
                current = current.multiply(BigDecimal.valueOf(-1));
                if(current.doubleValue() == current.intValue())
                    answer.setText(String.valueOf(current.intValue()));
                else answer.setText(String.valueOf(current));
                break;
            default:
                summ = summ.add(current);
                break;
        }
    }

}
