package com.example.activityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mainBtn=null;
    private final static int REQUEST_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBtn=(Button)findViewById(R.id.mainBtn);
        mainBtn.setOnClickListener(listener);

    }
    private View.OnClickListener listener=new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            Intent intent=new Intent();
            intent.setClass(MainActivity.this, SecondActivity.class);
            intent.putExtra("str", "Pass Data.");
            startActivityForResult(intent, REQUEST_CODE);

        }

    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == SecondActivity.RESULT_CODE) {
                Bundle bundle = data.getExtras();
                String str = bundle.getString("back");
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
            }
        }
    }

}