package com.team5.tgdd.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.team5.tgdd.R;

import java.util.Timer;
import java.util.TimerTask;

public class SlapScreenActivity extends AppCompatActivity {
    private Timer mTimer1;
    private TimerTask mTt1;
    private Handler mTimerHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slap_screen);
        startLoginActivity();
    }
    private void startLoginActivity(){
        mTimer1 = new Timer();
        mTt1 = new TimerTask() {
            public void run() {
                mTimerHandler.post(new Runnable() {
                    public void run(){
                        if (saveData()){
                            Intent intentLogin = new Intent(SlapScreenActivity.this,MainActivity.class);
                            startActivity(intentLogin);
                        }else {
                            Intent intentLogin = new Intent(SlapScreenActivity.this,LoginActivity.class);
                            startActivity(intentLogin);
                        }
                    }
                });
            }
        };
        mTimer1.schedule(mTt1, 3000);
    }
    public boolean saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        String phoneNumber = sharedPreferences.getString("phone_number",null);
        if (phoneNumber==null || phoneNumber.isEmpty()){
            return false;
        }
        return true;
    }
}