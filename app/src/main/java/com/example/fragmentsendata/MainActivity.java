package com.example.fragmentsendata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mbtnsenddata;
    TextView mtxtgetdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtnsenddata = findViewById(R.id.btnsendataAC);
        mtxtgetdata = findViewById(R.id.tvData);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        AndroidFragment androidFragment = new AndroidFragment();
        transaction.add(R.id.container, androidFragment);

        final IOSFragment iosFragment = new IOSFragment();
        transaction.add(R.id.container, iosFragment);

        transaction.commit();
        androidFragment.getDataChange(new FragmentListener() {
            @Override
            public void onInputAsent(String data) {
                mtxtgetdata.setText(data);
                iosFragment.txtReceive.setText(data);
            }
        });


    }


}