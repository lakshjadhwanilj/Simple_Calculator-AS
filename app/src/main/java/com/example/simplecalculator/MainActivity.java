package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnClear, btnPercent, btnDivision, btnMultiply, btnMinus, btnPlus, btnDot, btnEqual;
    TextView tvInput, tvOutput;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnClear = findViewById(R.id.btnClear);
        btnDot = findViewById(R.id.btnDot);
        btnEqual = findViewById(R.id.btnEqual);

        btnPercent = findViewById(R.id.btnPercent);
        btnDivision = findViewById(R.id.btnDivision);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);

        tvInput = findViewById(R.id.tvInput);
        tvOutput = findViewById(R.id.tvOutput);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btnDot.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnPercent.setOnClickListener(this);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText("");
                tvOutput.setText("");
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                result = tvInput.getText().toString();

                result = result.replaceAll("×","*");
                result = result.replaceAll("%","/100");
                result = result.replaceAll("÷","/");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalResult = "";

                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,result,"javascript",1,null).toString();
                } catch (Exception e) {
                    finalResult = "0";
                }

                tvOutput.setText(finalResult);

            }
        });
    }
    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btn0:
                result = tvInput.getText().toString();
                tvInput.setText(result + "0");
                break;
            case R.id.btn1:
                result = tvInput.getText().toString();
                tvInput.setText(result + "1");
                break;
            case R.id.btn2:
                result = tvInput.getText().toString();
                tvInput.setText(result + "2");
                break;
            case R.id.btn3:
                result = tvInput.getText().toString();
                tvInput.setText(result + "3");
                break;
            case R.id.btn4:
                result = tvInput.getText().toString();
                tvInput.setText(result + "4");
                break;
            case R.id.btn5:
                result = tvInput.getText().toString();
                tvInput.setText(result + "5");
                break;
            case R.id.btn6:
                result = tvInput.getText().toString();
                tvInput.setText(result + "6");
                break;
            case R.id.btn7:
                result = tvInput.getText().toString();
                tvInput.setText(result + "7");
                break;
            case R.id.btn8:
                result = tvInput.getText().toString();
                tvInput.setText(result + "8");
                break;
            case R.id.btn9:
                result = tvInput.getText().toString();
                tvInput.setText(result + "9");
                break;
            case R.id.btnDot:
                result = tvInput.getText().toString();
                tvInput.setText(result + ".");
                break;
            case R.id.btnPlus:
                result = tvInput.getText().toString();
                tvInput.setText(result + "+");
                break;
            case R.id.btnMinus:
                result = tvInput.getText().toString();
                tvInput.setText(result + "-");
                break;
            case R.id.btnMultiply:
                result = tvInput.getText().toString();
                tvInput.setText(result + "×");
                break;
            case R.id.btnDivision:
                result = tvInput.getText().toString();
                tvInput.setText(result + "÷");
                break;
            case R.id.btnPercent:
                result = tvInput.getText().toString();
                tvInput.setText(result + "%");
                break;
        }
    }
}