package com.example.activityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public final static int RESULT_CODE=1;
    private TextView secondTxt;
    private Button secondBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String str=bundle.getString("str");
        secondTxt=(TextView)findViewById(R.id.secondTxt);
        secondTxt.setText(str);

        secondBtn=(Button)findViewById(R.id.secondBtn);
        secondBtn.setOnClickListener(listener);

 }
    private View.OnClickListener listener=new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            Intent intent=new Intent();
            intent.putExtra("back", "Back Data");
            setResult(RESULT_CODE, intent);
            finish();
        }

};
}