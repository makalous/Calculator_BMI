package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView result;
    EditText number_h;
    EditText number_w;
    Button action;
    float n1, n2;
    float result_n;
    private Button author;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView)findViewById(R.id.result);
        number_h = (EditText)findViewById(R.id.number_height);
        number_w = (EditText)findViewById(R.id.number_weight);
        action = (Button)findViewById(R.id.action);
        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(number_h.getText().toString().trim().length() > 0 && number_w.getText().toString().trim().length() > 0){
                    n1=Integer.parseInt(number_h.getText().toString());
                    n2=Integer.parseInt(number_w.getText().toString());
                    result_n=n2/((n1/100)*(n1/100));
                    result.setText(String.valueOf(result_n));
                    if(result_n<18.5) result.setTextColor( getResources().getColor( R.color.niebieski ) );
                    else if (result_n>=18.5&&result_n<25) result.setTextColor( getResources().getColor( R.color.zielony ) );
                    else if (result_n>=25&&result_n<30) result.setTextColor( getResources().getColor( R.color.zolty ) );
                    else if (result_n>=30) result.setTextColor( getResources().getColor( R.color.czerwony ) );
                }
                else {
                    result.setText("One or both values are empty!");
                    result.setTextColor( getResources().getColor( R.color.czerwony ) );
                }


            }
        });

        author = (Button) findViewById(R.id.author);
        author.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAuthorActivity();
            }
        });
    }
    public void openAuthorActivity(){
        Intent intent = new Intent(this, AuthorActivity.class);
        startActivity(intent);
    }
}
