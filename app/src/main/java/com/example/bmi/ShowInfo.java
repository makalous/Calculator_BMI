package com.example.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowInfo extends AppCompatActivity {

    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);

        Bundle extras = getIntent().getExtras();
        float bmi_result=extras.getFloat("bmir");
        tv1 = (TextView)findViewById(R.id.textView1);
        tv2 = (TextView)findViewById(R.id.textView2);

        if (bmi_result != 0) {
            tv1.setText(String.valueOf(bmi_result));

            if (bmi_result < 18.5) {
                tv1.setTextColor(getResources().getColor(R.color.blue));
                tv2.setText("Your weight is too small. You need to eat more!");
            } else if (bmi_result >= 18.5 && bmi_result < 25) {
                tv1.setTextColor(getResources().getColor(R.color.green));
                tv2.setText("Your weight is OK. Good for You!");
            } else if (bmi_result >= 25 && bmi_result < 30) {
                tv1.setTextColor(getResources().getColor(R.color.yellow));
                tv2.setText("Your weight is slightly too big. You need to be careful, control your meals!");
            } else if (bmi_result >= 30) {
                tv1.setTextColor(getResources().getColor(R.color.red));
                tv2.setText("Your weight is seriously too big. You need to start strictly control your diet!");
            }
        }
        else tv1.setText("There is no result");

        Button backed = (Button) findViewById(R.id.backed);
        backed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivityTv();
            }
        });

    }
    public void openMainActivityTv(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
