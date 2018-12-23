package com.example.jinhui.popwindow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.popwindow.listviewpop.LvPopUpWindowActivity;

/**
 * PopUpwindow 温习下
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_lvPopUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_lvPopUp = findViewById(R.id.bt_lvPopUp);
        bt_lvPopUp = findViewById(R.id.bt_lvPopUp);

        bt_lvPopUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_lvPopUp:
                startActivity(new Intent(this, LvPopUpWindowActivity.class));
                break;
        }
    }
}
