package com.example.mrzheng.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add_item: {
                Toast.makeText(MainActivity.this, "add", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.remove_item: {
                Toast.makeText(MainActivity.this, "remove", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_exit: {
                Log.d("debug", "onOptionsItemSelected: exit");
                finish();
                break;
            }
            default: {
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        Button btnOne = (Button) findViewById(R.id.btn_one);
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "you touch me!", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);
                /*
                Intent intent = new Intent("com.example.mrzheng.activitytest.ACTION_START");
                intent.addCategory("com.example.mrzheng.activitytest.Huige_categroy");
                // startActivity(intent);
                startActivityForResult(intent, 1);
                */
            }
        });

        Button btnOpenWeb = (Button) findViewById(R.id.btn_openWeb);
        btnOpenWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: you call me!requestCode:" + requestCode);
        Log.d(TAG, "onActivityResult: you call me!resultCode:" + resultCode);

        switch (requestCode) {
            case 1: {
                if (resultCode == RESULT_OK) {
                    String sSecondReturn = data.getStringExtra("second_return");
                    Log.d(TAG, "onActivityResult: ");
                    Toast.makeText(MainActivity.this, sSecondReturn.toString(), Toast.LENGTH_SHORT).show();
                }
                break;
            }
            default: {
                break;
            }
        }
    }
}
