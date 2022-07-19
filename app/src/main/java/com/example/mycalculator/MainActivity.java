package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity
{
    TextView workingTV;
    TextView resultsTV;

    String workings = "";
    String formula = "";
    String tempFormula = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }

    private void initTextViews()
    {
        workingTV = (TextView)findViewById(R.id.workingTextView);
        resultsTV = (TextView)findViewById(R.id.resultTextView);
    }

    private void setWorkings(String givenValue)
    {
        workings = workings + givenValue;
        workingTV.setText(workings);
    }

    public void equalsOnClick(View view)
    {
        ScriptEngine engine = new ScriptEngineManager(.getEngineByName("rhino"));
        try {
            Double result = (double) engine.eval(formula);
        } catch (ScriptException e)
        {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }
        if(resultsTV != null)
            resultsTV.setText(String.valueOf(resultsTV.double()));
    }

    public void clearOnClick(View view)
    {
        workingTV.setText("");
        workings = "";
        resultsTV.setText("");
    }

    public void sevenOnClick(View view)
    {
        setWorkings("7");
    }

    public void eightOnClick(View view)
    {
        setWorkings("8");
    }

    public void nineOnClick(View view)
    {
        setWorkings("9");
    }

    public void plusOnClick(View view)
    {
        setWorkings("+");
    }

    public void fourOnClick(View view)
    {
        setWorkings("4");
    }

    public void fiveOnClick(View view)
    {
        setWorkings("5");
    }

    public void sixOnClick(View view)
    {
        setWorkings("6");
    }

    public void minusOnClick(View view)
    {
        setWorkings("-");
    }

    public void oneOnClick(View view)
    {
        setWorkings("1");
    }

    public void twoOnClick(View view)
    {
        setWorkings("2");
    }

    public void threeOnClick(View view)
    {
        setWorkings("3");
    }

    public void timeOnClick(View view)
    {
        setWorkings("X");
    }

    public void zeroOnClick(View view)
    {
        setWorkings("0");
    }

    public void divisionOnClick(View view)
    {
        setWorkings("/");
    }
}