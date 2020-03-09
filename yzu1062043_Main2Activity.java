package com.example.a1062043tictactoe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.FileObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {

    Button btnback;
    TextView txtshow;
    TextView txtscore;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent it=new Intent(Main2Activity.this,MainActivity.class);
        startActivity(it);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences preferences=getSharedPreferences("score",0);

        txtshow=findViewById(R.id.txtshow);

        String s=preferences.getString("win"," ");
        txtshow.setText(s);
        txtshow.setTextSize(40);

        txtscore=findViewById(R.id.txtscore);

        int oscore=preferences.getInt("Oscore",0);
        int xscore=preferences.getInt("Xscore",0);
        txtscore.setText("O score : "+oscore+"\n"+"X score : "+xscore);
        txtscore.setTextSize(20);
    }


}
