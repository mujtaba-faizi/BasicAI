package com.example.mujtaba.basicai.Improving_Techniques;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mujtaba.basicai.R;

public class SGD extends AppCompatActivity {
    private TextView I1;
    private TextView I2;
    private TextView I3;
    private TextView W1;
    private TextView W2;
    private TextView W3;
    private TextView Accuracy;
    private TextView label;
    private Button accbutton;

    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sgd);

        I1=(TextView) findViewById(R.id.input1);
        I2=(TextView) findViewById(R.id.input2);
        I3=(TextView) findViewById(R.id.input3);
        W1=(TextView) findViewById(R.id.weight1);
        W2=(TextView) findViewById(R.id.Weight2);
        W3=(TextView) findViewById(R.id.Weight3);
        Accuracy=(TextView) findViewById(R.id.Acc);
        label=(TextView)findViewById(R.id.label);


    }
    public void CalculateAccuracy(View v){

        a = Integer.parseInt(I1.getText().toString());
        b = Integer.parseInt(I2.getText().toString());
        c = Integer.parseInt(I3.getText().toString());
        d = Integer.parseInt(W1.getText().toString());
        e = Integer.parseInt(W2.getText().toString());
        f = Integer.parseInt(W3.getText().toString());
        g = Integer.parseInt(label.getText().toString());
        int acc= (((a*c)+(b*d)+(c*e))-g)^2;
        String u=Integer.toString(acc);
        Accuracy.setText(u);
    }
}
