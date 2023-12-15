package com.example.zkyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class DialogActivity extends AppCompatActivity {

    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        back=findViewById(R.id.back);
        DialogActivityListener dalis=new DialogActivityListener();
        back.setOnClickListener(dalis);
    }
    class  DialogActivityListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.back)
            {
              dismissDialog(R.id.registerAtivity);
            }
        }
    }
}