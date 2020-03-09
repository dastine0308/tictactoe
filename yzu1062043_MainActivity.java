package com.example.a1062043tictactoe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.wifi.aware.PublishDiscoverySession;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Button;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {
    private Button btn[][] = new Button[3][3];
    private Button btnRest;
    private boolean myTurn = true;//我方: O  對方: X
    private boolean Owin=false;
    private boolean Xwin=false;


     int Oscore=0;
     int Xscore=0;


    LinearLayout ll;
    LinearLayout []llchild=new LinearLayout[3];
    Button []b;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();

        int num=1;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                btn [i][j] = new Button(this);
                btn[i][j].setId(num);//設置對象id
                btn[i][j].setText(" ");
                btn[i][j].setOnClickListener(new myListener());//button元件的click事件用mylListener方法
                //new用來創建對象
                btn[i][j].setHeight(370);
                btn[i][j].setTextSize(100);
                btn[i][j].setWidth(370);
                llchild[i].addView(btn[i][j]);
                num++;
            }
        }


        btnRest=new Button(this);
        btnRest.setText("RESET");
        btnRest.setOnClickListener(new myListener());
        ll.addView(btnRest);
    }

    //LinearLayout
    void init()
    {
        ll=findViewById(R.id.mainLayout);

        for(int i=0;i<3;i++){
            llchild[i]=new LinearLayout(this);
            llchild[i].setOrientation(LinearLayout.HORIZONTAL);
            ll.addView(llchild[i]);//把 llchild 加到大的 linearlayout(ll) 裡面
        }
    }

    //按鈕事件(class)
    public class myListener implements OnClickListener{

        public void onClick(View v) {
            if(v.getId()==btnRest.getId())
            {
                for(int i=0;i<3;i++)
                    for(int j=0;j<3;j++){
                        btn[i][j].setText(" ");
                    }

//                //----------------------切換視窗
//                Intent it=new Intent(MainActivity.this,Main2Activity.class);
//                //---------------------切換視窗時 傳送字串 key-value
//                Bundle bundle=new Bundle();
//                bundle.putString("data1","so easy");//key-value
//                bundle.putString("data2","very easy");
//                it.putExtras(bundle);
//
//                startActivity(it);


            }
            else {
                if (myTurn&&((Button) v).getText().equals(" ")) {
                    ((Button) v).setText("O");//取得的按鈕
                    myTurn = false;
                    checkwin();
                    if(Owin){
                        Oscore++;
                        //開一個txt檔
                        SharedPreferences preferences=getSharedPreferences("score",0);
                        preferences.edit()
                                .putInt("Oscore",Oscore)
                                .putString("win","O WIN")
                                .apply();

                        //----------------------切換視窗
                        Intent it=new Intent(MainActivity.this,Main3Activity.class);
                        startActivity(it);
                        //finish();
                        Owin=false;
                    }
                } else if(!myTurn&&((Button) v).getText().equals(" ")) {
                    ((Button) v).setText("X");
                    myTurn = true;
                    checkwin();
                    if(Xwin){
                        Xscore++;
                        SharedPreferences preferences=getSharedPreferences("score",0);
                        preferences.edit()
                                .putInt("Xscore",Xscore)
                                .putString("win","X WIN")
                                .apply();

                        //----------------------切換視窗
                        Intent it=new Intent(MainActivity.this,Main3Activity.class);
                        startActivity(it);
                       // finish();
                        Xwin=false;
                    }
                }
            }
        };
    };

    //判別輸贏
    void checkwin() {

        //橫的
        for(int i=0;i<3;i++) {
            if (btn[i][0].getText().equals(btn[i][1].getText())&&btn[i][0].getText().equals(btn[i][2].getText())&&btn[i][1].getText().equals(btn[i][2].getText())){
                if(btn[i][0].getText().equals("O")){
                    new AlertDialog.Builder((MainActivity.this))
                            .setIcon(R.mipmap.ic_launcher)
                            .setMessage("O win")
                            .show();
                    Owin=true;

                }

                else if(btn[i][0].getText().equals("X")){
                    new AlertDialog.Builder((MainActivity.this))
                            .setIcon(R.mipmap.ic_launcher)
                            .setMessage("X win")
                            .show();
                    Xwin=true;

                }
            }
        }
        //直的
        for(int i=0;i<3;i++) {
            if (btn[0][i].getText().equals(btn[1][i].getText())&&btn[0][i].getText().equals(btn[2][i].getText())&&btn[1][i].getText().equals(btn[2][i].getText())){
                if(btn[0][i].getText().equals("O")){
                    new AlertDialog.Builder((MainActivity.this))
                            .setIcon(R.mipmap.ic_launcher)
                            .setMessage("O win")
                            .show();
                    Owin=true;

                }
                else if(btn[0][i].getText().equals("X")){
                    new AlertDialog.Builder((MainActivity.this))
                            .setIcon(R.mipmap.ic_launcher)
                            .setMessage("X win")
                            .show();
                    Xwin=true;

                }
            }
        }
        //斜的
        if (btn[0][0].getText().equals(btn[1][1].getText())&&btn[0][0].getText().equals(btn[2][2].getText())&&btn[1][1].getText().equals(btn[2][2].getText())){
            if(btn[0][0].getText().equals("O")){
                new AlertDialog.Builder((MainActivity.this))
                        .setIcon(R.mipmap.ic_launcher)
                        .setMessage("O win")
                        .show();
                Owin=true;
            }
            else if(btn[0][0].getText().equals("X")){
                new AlertDialog.Builder((MainActivity.this))
                        .setIcon(R.mipmap.ic_launcher)
                        .setMessage("X win")
                        .show();
                Xwin=true;
            }
        }

        if (btn[0][2].getText().equals(btn[1][1].getText())&&btn[0][2].getText().equals(btn[2][0].getText())&&btn[1][1].getText().equals(btn[2][0].getText())){
            if(btn[0][2].getText().equals("O")){
                new AlertDialog.Builder((MainActivity.this))
                        .setIcon(R.mipmap.ic_launcher)
                        .setMessage("O win")
                        .show();
                Owin=true;

            }
            else if(btn[0][2].getText().equals("X")){
                new AlertDialog.Builder((MainActivity.this))
                        .setIcon(R.mipmap.ic_launcher)
                        .setMessage("X win")
                        .show();
                Xwin=true;
            }
        }

    }

}
