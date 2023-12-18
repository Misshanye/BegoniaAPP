package com.example.zkyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.os.Message;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.LogRecord;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.widget.Toast;


public class otherSignUpActivity extends AppCompatActivity {
    //退回登陆界面
    ImageButton quit;
    //选择服务说明书
    RadioButton choice;
    //查看服务说明书
    TextView check, id, password;
    int flag = 1;
    private final static int LOGIN_JUDGE = 1;
    private int RequestCode = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_sing_up);
        quit = findViewById(R.id.quit);
        choice = findViewById(R.id.choice);
        check = findViewById(R.id.check);
        id = findViewById(R.id.id);
        password = findViewById(R.id.password);

        Listener lis = new Listener();
        quit.setOnClickListener(lis);
        check.setOnClickListener(lis);
        choice.setOnClickListener(lis);
        id.setOnClickListener(lis);
        password.setOnClickListener(lis);
    }

    class Listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.quit) {
                startActivity(new Intent(otherSignUpActivity.this, MainActivity.class));
            } else if (view.getId() == R.id.check) {
                Intent it = new Intent(otherSignUpActivity.this, DialogActivity.class);
                startActivity(it);
            } else if (view.getId() == R.id.choice) {
                if (flag == 1)
                    choice.setChecked(true);
                else
                    choice.setChecked(false);
                flag = -flag;
            }
            else if(view.getId()==R.id.login)
            {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //使用下面类里的函数，连接servlet，返回一个result，使用handler处理这个result
                        String result = HttpLogin.LoginByPost(id.getText().toString(),password.getText().toString());
                        Bundle bundle = new Bundle();
                        bundle.putString("result",result);
                        Message message = new Message();
                        message.setData(bundle);
                        message.what = LOGIN_JUDGE;
                        handler.sendMessage(message);
                    }
                }).start();
            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            id.setText(data.getStringExtra("id"));
            password.setText(data.getStringExtra("password"));
        }
    }
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            switch (msg.what){
                case LOGIN_JUDGE:{
                    Bundle bundle = new Bundle();
                    bundle = msg.getData();
                    String result = bundle.getString("result");
                    //Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
                    try {
                        if (result.equals("success")) {
                            Intent it = new Intent(otherSignUpActivity.this, EventOrderActivity.class);
                            startActivity(it);
                        }
                    }catch (NullPointerException e){
                        e.printStackTrace();
                    }
                }
                break;
            }
        }
    };

}