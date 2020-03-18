package com.example.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView result;
    EditText number_h;
    EditText number_w;
    Button action;
    float result_n=0;
    //Button author;
    boolean imperial=false;
    BmiCounter counter = new BmiCounter();

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

                    counter.n1=Integer.parseInt(number_h.getText().toString());
                    counter.n2=Integer.parseInt(number_w.getText().toString());
                        if (imperial) result_n=(float)counter.BmiCalcImperial();
                        else result_n=counter.BmiCalcMetric();
                    result.setText(String.valueOf(result_n));
                    if(result_n<18.5) result.setTextColor( getResources().getColor( R.color.blue ) );
                    else if (result_n>=18.5&&result_n<25) result.setTextColor( getResources().getColor( R.color.green ) );
                    else if (result_n>=25&&result_n<30) result.setTextColor( getResources().getColor( R.color.yellow ) );
                    else if (result_n>=30) result.setTextColor( getResources().getColor( R.color.red ) );
                }
                else {
                    result.setText("One or both values are empty!");
                    result.setTextColor( getResources().getColor( R.color.red ) );
                }


            }
        });

       /* author = (Button) findViewById(R.id.author);
        author.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAuthorActivity();
            }
        }
        );*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                number_h.setHint("Height in centimeters");
                number_w.setHint("Weight in kilograms");
                imperial=false;
                return true;
            case R.id.item2:
                number_h.setHint("Height in inches");
                number_w.setHint("Weight in stones");
                imperial=true;
                return true;
            case R.id.item3:
                openAuthorActivity();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void OpenShowInfoActivity(View v)
    {
        Intent intent = new Intent(this, ShowInfo.class);
        intent.putExtra("bmir", result_n);
        //startActivityForResult(intent, (int)result_n);
        startActivity(intent);
    }

    public void openAuthorActivity(){
        Intent intent = new Intent(this, AuthorActivity.class);
        startActivity(intent);
    }
}
