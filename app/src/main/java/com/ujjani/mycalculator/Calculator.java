package com.ujjani.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Calculator extends Activity implements View.OnClickListener {

    private TextView txtResults, txtCalculations;

    private enum OPERATOR{
        PLUS, SUBTRACT, MULTIPLY, DIVIDE, EQUAL
    }
    //iNSTANCE VARIABLE
    private  String currentNumber;
    private String stringNumberAtRight;
    private String stringNumberAtLeft;
    private OPERATOR currentOperator;
    private int calculationResult;

    private String calculationsString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        currentNumber = "";
        calculationResult = 0;

        calculationsString = "";

        txtCalculations = findViewById(R.id.txtCalculations);
        txtResults = findViewById(R.id.txtResults);

        findViewById(R.id.btnEqual).setOnClickListener(Calculator.this);
        findViewById(R.id.btn7).setOnClickListener(Calculator.this);
        findViewById(R.id.btn8).setOnClickListener(Calculator.this);
        findViewById(R.id.btn9).setOnClickListener(Calculator.this);
        findViewById(R.id.btnPlus).setOnClickListener(Calculator.this);
        findViewById(R.id.btn4).setOnClickListener(Calculator.this);
        findViewById(R.id.btn5).setOnClickListener(Calculator.this);
        findViewById(R.id.btn6).setOnClickListener(Calculator.this);
        findViewById(R.id.btnSubtract).setOnClickListener(Calculator.this);
        findViewById(R.id.btn1).setOnClickListener(Calculator.this);
        findViewById(R.id.btn2).setOnClickListener(Calculator.this);
        findViewById(R.id.btn3).setOnClickListener(Calculator.this);
        findViewById(R.id.btnMultiply).setOnClickListener(Calculator.this);
        findViewById(R.id.btnClear).setOnClickListener(Calculator.this);
        findViewById(R.id.btn0).setOnClickListener(Calculator.this);
        findViewById(R.id.btnDivide).setOnClickListener(Calculator.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEqual:

                operatorIsTapped(OPERATOR.EQUAL);

                break;
            case R.id.btn7:
                numberIsTapped(7);
                break;
            case R.id.btn8:
                numberIsTapped(8);
                break;
            case R.id.btn9:
                numberIsTapped(9);
                break;
            case R.id.btnPlus:
                operatorIsTapped(OPERATOR.PLUS);
                calculationsString += " + ";
                break;
            case R.id.btn4:
                numberIsTapped(4);
                break;
            case R.id.btn5:
                numberIsTapped(5);
                break;
            case R.id.btn6:
                numberIsTapped(6);
                break;
            case R.id.btnSubtract:
                operatorIsTapped(OPERATOR.SUBTRACT);
                calculationsString += " - ";
                break;
            case R.id.btn1:
                numberIsTapped(1);
                break;
            case R.id.btn2:
                numberIsTapped(2);
                break;
            case R.id.btn3:
                numberIsTapped(3);
                break;
            case R.id.btnMultiply:
                operatorIsTapped(OPERATOR.MULTIPLY);
                calculationsString += " * ";
                break;
            case R.id.btnClear:

                clearTapped();

                break;
            case R.id.btn0:
                numberIsTapped(0);
                break;
            case R.id.btnDivide:
                operatorIsTapped(OPERATOR.DIVIDE);
                calculationsString += "/";
                break;

        }
        txtCalculations.setText(calculationsString);

    }
    private void numberIsTapped(int tappedNumber){

        currentNumber = currentNumber + String.valueOf(tappedNumber);//bere number type maddaga pakka baroke ex:12345
        txtResults.setText(currentNumber);

        calculationsString = currentNumber;
        txtCalculations.setText(calculationsString);
    }
    private void operatorIsTapped(OPERATOR tappedOperator){
        if(currentOperator != null ) {
            if (currentNumber != "") {


                stringNumberAtRight = currentNumber;
                currentNumber = "";

                switch (currentOperator) {

                    case PLUS:
                        calculationResult = Integer.parseInt(stringNumberAtLeft) + Integer.parseInt(stringNumberAtRight);
                        break;
                    case SUBTRACT:
                        calculationResult = Integer.parseInt(stringNumberAtLeft) - Integer.parseInt(stringNumberAtRight);
                        break;
                    case MULTIPLY:
                        calculationResult = Integer.parseInt(stringNumberAtLeft) * Integer.parseInt(stringNumberAtRight);
                        break;
                    case DIVIDE:
                        calculationResult = Integer.parseInt(stringNumberAtLeft) / Integer.parseInt(stringNumberAtRight);
                        break;


                }
                stringNumberAtLeft = String.valueOf(calculationResult);// 5 * 2 , without pressing equalOperator and also if we press other operator we need an answer in Left side
                // and pressed operator is for currentOperator

                txtResults.setText(stringNumberAtLeft);

                calculationsString = stringNumberAtLeft;
            }
        }else{
            stringNumberAtLeft = currentNumber;
            currentNumber = "";
        }
        currentOperator = tappedOperator;

    }
    private void clearTapped(){
        stringNumberAtLeft = "";
        stringNumberAtRight= "";
        calculationResult = 0;
        currentOperator = null ;
        txtResults.setText("0");
        calculationsString = "0";

    }
}