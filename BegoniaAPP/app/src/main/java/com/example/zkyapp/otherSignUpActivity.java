package com.example.zkyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class otherSignUpActivity extends AppCompatActivity {
    //退回登陆界面
    ImageButton quit;
    //选择服务说明书
    RadioButton choice;
    //查看服务说明书
    TextView check;
    int flag=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_sing_up);
        quit=findViewById(R.id.quit);
        choice=findViewById(R.id.choice);
        check=findViewById(R.id.check);

        Listener lis=new Listener();
        quit.setOnClickListener(lis);
        check.setOnClickListener(lis);
        choice.setOnClickListener(lis);
    }
    class Listener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.quit)
            {
                startActivity(new Intent(otherSignUpActivity.this,MainActivity.class));
            }
            else if (view.getId()==R.id.check) {
                Intent it = new Intent(otherSignUpActivity.this, DialogActivity.class);
                startActivity(it);
            }
            else if (view.getId()==R.id.choice) {
                if(flag==1)
                    choice.setChecked(true);
                else
                    choice.setChecked(false);
                flag=-flag;
            }
        }
    }
}