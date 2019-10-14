package com.thiennd.maytinhcamtay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String upContent;
    String downContent;
    String currentOps;
    final String ADD = "+";
    final String SUB = "-";
    final String MULTI = "*";
    final String DIV = "/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setOnClick();
    }

    @Override
    public void onClick(View v) {
        Log.d("ONCLICK: ", "ID" + v.getId());
        switch (v.getId()) {
            case R.id.btnAC:
                Log.d("BUTTON: ", "AC");
                upContent = "0";
                downContent = "";
                currentOps = ADD;
                break;
            case R.id.btnC:
                Log.d("BUTTON: ", "C");
                downContent = "";
                break;
            case R.id.btnBC:
                Log.d("BUTTON: ", "BC");
                if (downContent.length() >= 1)
                    downContent = downContent.substring(0, downContent.length() - 1);
                break;
            case R.id.btnAdd:
                Log.d("BUTTON: ", "+");
                currentOps = ADD;
                operator(ADD);
                break;
            case R.id.btnSub:
                Log.d("BUTTON: ", "-");
                currentOps = SUB;
                operator(SUB);
                break;
            case R.id.btnMulti:
                Log.d("BUTTON: ", "*");
                currentOps = MULTI;
                operator(MULTI);
                break;
            case R.id.btnDivision:
                Log.d("BUTTON: ", "/");
                currentOps = DIV;
                operator(DIV);
                break;
            case R.id.btnEqual:
                Log.d("BUTTON: ", "=");
                calculate();
                break;
            case R.id.btnFloat:
                Log.d("BUTTON: ", ".");
                if (downContent.contains(".")) downContent = downContent.replace(".", "");
                else downContent += ".";
                break;
            case R.id.btnNegative:
                Log.d("BUTTON: ", "-/+" + downContent);
                if (downContent.contains("-")) downContent = downContent.replace("-", "");
                else downContent = "-" + downContent;
                break;
            case R.id.btnOne:
                clickNumberButton(1);
                break;
            case R.id.btnTwo:
                clickNumberButton(2);
                break;
            case R.id.btnThree:
                clickNumberButton(3);
                break;
            case R.id.btnFour:
                clickNumberButton(4);
                break;
            case R.id.btnFive:
                clickNumberButton(5);
                break;
            case R.id.btnSix:
                clickNumberButton(6);
                break;
            case R.id.btnSeven:
                clickNumberButton(7);
                break;
            case R.id.btnEight:
                clickNumberButton(8);
                break;
            case R.id.btnNine:
                clickNumberButton(9);
                break;
            case R.id.btnZero:
                clickNumberButton(0);
                break;


            default:
                Log.d("ONCLICK", "Not found");
                break;
        }
        upContent = remakeUpContent(upContent);
        upText.setText(upContent);
        downText.setText(downContent);
    }

    private void calculate() {
        float ans;
        switch (currentOps) {
            case ADD:
                ans = Float.valueOf(upContent) + Float.valueOf(downContent);
                upContent = ans + "";
                downContent = "";
                break;
            case SUB:
                ans = Float.valueOf(upContent) - Float.valueOf(downContent);
                upContent = ans + "";
                downContent = "";
                break;
            case MULTI:
                ans = Float.valueOf(upContent) * Float.valueOf(downContent);
                upContent = ans + "";
                downContent = "";
                break;
            case DIV:
                ans = Float.valueOf(upContent) / Float.valueOf(downContent);
                upContent = ans + "";
                downContent = "";
                break;
            default:
                break;
        }
        currentOps = "";
    }

    private void operator(String ops) {
        if (upContent == "" && downContent != "") {
            upContent = downContent;
            downContent = "";
        } else if (upContent != "" && downContent != "") {
            calculate();
            currentOps = ops;
        } else {
            currentOps = ops;
        }


    }

    private void clickNumberButton(int input) {
        Log.d("BUTTON: ", "" + input);
        if (downContent.length() < 10) {

            downContent += String.valueOf(input);
        } else {
            Log.d("OVERSIZE", downContent + " and " + input);
        }
    }

    private String remakeUpContent(String content) {
        float f;
        try{
            f = Float.valueOf(content);
        } catch (Exception e){
            return "";
        }
        if (f == (int) f) {
            return (int) f + "";
        } else return f + "";
    }

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;

    Button btnC;
    Button btnAC;
    Button btnBC;

    Button btnAdd;
    Button btnSub;
    Button btnMulti;
    Button btnDiv;

    Button btnFloat;
    Button btnEqual;
    Button btnNegative;
    TextView upText;
    TextView downText;

    private void setOnClick() {
        upContent = "0";
        downContent = "";
        currentOps = ADD;
        btn1 = findViewById(R.id.btnOne);
        btn2 = findViewById(R.id.btnTwo);
        btn3 = findViewById(R.id.btnThree);
        btn4 = findViewById(R.id.btnFour);
        btn5 = findViewById(R.id.btnFive);
        btn6 = findViewById(R.id.btnSix);
        btn7 = findViewById(R.id.btnSeven);
        btn8 = findViewById(R.id.btnEight);
        btn9 = findViewById(R.id.btnNine);
        btn0 = findViewById(R.id.btnZero);

        btnC = findViewById(R.id.btnC);
        btnAC = findViewById(R.id.btnAC);
        btnBC = findViewById(R.id.btnBC);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMulti = findViewById(R.id.btnMulti);
        btnDiv = findViewById(R.id.btnDivision);

        btnFloat = findViewById(R.id.btnFloat);
        btnEqual = findViewById(R.id.btnEqual);
        btnNegative = findViewById(R.id.btnNegative);

        upText = findViewById(R.id.upText);
        downText = findViewById(R.id.downText);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);

        btnC.setOnClickListener(this);
        btnAC.setOnClickListener(this);
        btnBC.setOnClickListener(this);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnFloat.setOnClickListener(this);
        btnNegative.setOnClickListener(this);

    }

}
