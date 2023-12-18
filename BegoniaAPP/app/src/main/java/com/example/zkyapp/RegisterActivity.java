package com.example.zkyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    //退回登陆界面
    ImageButton quit;
    //选择服务说明书
    RadioButton choice;
    //查看服务说明书
    TextView check;
    EditText id, psw_1, psw_2, phoneNum;
    int flag = 1;
    private int ResultCode = 2;
    private final static int REGISTER_JUDGE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        quit = findViewById(R.id.quit);
        choice = findViewById(R.id.choice);
        check = findViewById(R.id.check);
        psw_1 = (EditText) findViewById(R.id.password_edit);
        psw_2 = (EditText) findViewById(R.id.password_edit1);
        phoneNum = (EditText) findViewById(R.id.phoneNum);

        RegisterListener lis = new RegisterListener();
        quit.setOnClickListener(lis);
        check.setOnClickListener(lis);
        choice.setOnClickListener(lis);
        psw_1.setOnClickListener(lis);
        psw_2.setOnClickListener(lis);
        phoneNum.setOnClickListener(lis);
    }

    class RegisterListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.quit) {
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            } else if (view.getId() == R.id.check) {
                Intent it = new Intent(RegisterActivity.this, DialogActivity.class);
                startActivity(it);
            } else if (view.getId() == R.id.choice) {
                if (flag == 1)
                    choice.setChecked(true);
                else
                    choice.setChecked(false);
                flag = -flag;
            } else if (view.getId() == R.id.signUp) {
                if (!psw_1.getText().toString().equals(psw_2.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "两次密码不一致！", Toast.LENGTH_LONG).show();
                } else {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            String result = HttpLogin.RegisterByPost(id.getText().toString(),
                                    psw_1.getText().toString(), phoneNum.getText().toString());
                            Bundle bundle = new Bundle();
                            bundle.putString("result", result);
                            Message msg = new Message();
                            msg.what = REGISTER_JUDGE;
                            msg.setData(bundle);
                            handler.sendMessage(msg);
                        }
                    }).start();
                }
            }
        }

        @SuppressLint("HandlerLeak")
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case REGISTER_JUDGE: {
                        Bundle bundle = new Bundle();
                        bundle = msg.getData();
                        String result = bundle.getString("result");
                        //Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
                        try {
                            if (result.equals("success")) {
                                Intent intent = new Intent();
                                intent.putExtra("id", id.getText().toString());
                                intent.putExtra("password", psw_1.getText().toString());
                                setResult(ResultCode, intent);//向上一级发送数据
                                finish();
                            }
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                }
            }
        };
    }
}