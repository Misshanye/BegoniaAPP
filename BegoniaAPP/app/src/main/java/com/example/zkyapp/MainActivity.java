package com.example.zkyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.material3.SnackbarKt;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    public static final String TAG="MainActivity 登陆界面";
    Button getCode,signUp,switchActivity;
    TextView check,switchSignActivity,otherSignUp;
    EditText ed;
    RadioButton choice;
    ImageView userImage;
    int flag=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        setContentView(R.layout.activity_main);
        //验证码获取
        getCode=findViewById(R.id.getCode);
        signUp=findViewById(R.id.signUp);
        //查看协议
        check=findViewById(R.id.check);
        //监控是否勾选协议
        choice=findViewById(R.id.choice);
        userImage=findViewById(R.id.userImage);
        //注册跳转
        switchSignActivity=findViewById(R.id.switchRegisterActivity);
        otherSignUp=findViewById(R.id.otherSignUp);


        MyListener lis=new MyListener();
        getCode.setOnClickListener(lis);
        signUp.setOnClickListener(lis);
        switchSignActivity.setOnClickListener(lis);
        check.setOnClickListener(lis);
        choice.setOnClickListener(lis);
        otherSignUp.setOnClickListener(lis);
    }
    class  MyListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
          if(view.getId()==R.id.getCode)
          {
              Toast.makeText(MainActivity.this, "已发送", Toast.LENGTH_LONG).show();
          }
          else if(view.getId()==R.id.signUp)
            {
               if(choice.isChecked())
               {
                Intent it = new Intent(MainActivity.this, EventOrderActivity.class);
                startActivity(it);
               }
               else
                   Toast.makeText(MainActivity.this,"请先阅读并勾选用户隐私服务说明书",Toast.LENGTH_LONG).show();
            }
          else if (view.getId()==R.id.check) {
                  Intent it = new Intent(MainActivity.this, DialogActivity.class);
                  startActivity(it);
          }
          else if (view.getId()==R.id.choice) {
             if(flag==1)
                 choice.setChecked(true);
             else
                 choice.setChecked(false);
              flag=-flag;
          }
          else if(view.getId()==R.id.switchRegisterActivity)
          {
              Intent it = new Intent(MainActivity.this, RegisterActivity.class);
              startActivity(it);
          }
          else if(view.getId()==R.id.otherSignUp)
          {
              Intent it = new Intent(MainActivity.this, otherSignUpActivity.class);
              startActivity(it);
          }
        }
    }
    @Override
    protected void onStart()
    {
        super.onStart();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putString("key1",ed.getText().toString());111
    }
}
