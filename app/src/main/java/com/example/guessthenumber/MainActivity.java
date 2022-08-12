package com.example.guessthenumber;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    boolean flag=false;
    int result;
    static int getRandomNumber(int max, int min)
    {
        return (int)((Math.random()
                * (max - min)) + min);
    }

    public void makeToast(String str)
    {
        Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
    }
    public void clickFunction(View view)
    {
        int userGuessing;
        EditText variable
                = findViewById(
                R.id.editId);
        userGuessing
                = Integer.parseInt(
                variable
                        .getText()
                        .toString());
        if (userGuessing < result) {

            makeToast("Think of Higher Number, Try Again");
        }
        else if (userGuessing > result) {
            makeToast("Think of Lower Number, Try Again");
        }
        else {
            makeToast(
                    "Congratulations,"+" You Got the Number");
            flag=true;
    }

        Button admin_see_questions = findViewById(R.id.button2);
        if ( flag )
        {
            admin_see_questions.setVisibility(View.VISIBLE);
            admin_see_questions.setOnClickListener(v -> {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            });
        } else admin_see_questions.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(
            Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int min = 1;
        int max = 100;
        result = getRandomNumber(min, max);
    }
}
