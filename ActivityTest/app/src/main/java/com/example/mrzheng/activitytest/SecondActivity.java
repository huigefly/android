package com.example.mrzheng.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {
    private static String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();

        Intent intent = new Intent();
        intent.putExtra("second_return", "second activity is a beauty!");
        Log.d(TAG, "onBackPressed: RESULT_OK:" + RESULT_OK);
        setResult(RESULT_OK, intent);
        finish();
    }
}
