package com.example.a1062043tictactoe;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    Button btn;
    TextView txt_win;

    @Override
    public void onBackPressed() {
        Intent it=new Intent(Main3Activity.this,MainActivity.class);
        startActivity(it);
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        SharedPreferences preferences=getSharedPreferences("score",0);

        btn=findViewById(R.id.btn_score);
        txt_win=findViewById(R.id.txt_win);

        String s=preferences.getString("win"," ");
        txt_win.setText(s);
        txt_win.setTextSize(40);

        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(Main3Activity.this,Main2Activity.class);
                startActivity(it);
            }
        });



    }
}
