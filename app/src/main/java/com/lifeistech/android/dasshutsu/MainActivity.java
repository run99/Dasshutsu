package com.lifeistech.android.dasshutsu;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //フィールド変数
    private boolean hasKey;
    private boolean isOpened;
    private Button buttonKey;
    private Button buttonDoor;

    //アプリが起動した時に呼ばれるメソッド
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //アプリを起動したときには鍵を持っていない
        hasKey = false;
        //ドアが閉まっている
        isOpened = false;

        buttonDoor = (Button)findViewById(R.id.buttonDoor);
        buttonKey = (Button)findViewById(R.id.buttonKey);
    }

    //鍵を押したときに呼ばれるメソッド
    public void clickKey(View v){
        //一時的に文章を表示
        Toast.makeText(this, "鍵を手に入れたよ！", Toast.LENGTH_SHORT).show();

        //鍵を手に入れたfalse→true
        hasKey = true;

        //鍵を非表示にする
        buttonKey.setVisibility(View.INVISIBLE);
    }

    //ドアを押したときに呼ばれるメソッド
    public void clickDoor(View v) {

        if (isOpened) {//ドアが開いたあとの処理
            //画面遷移
            Intent intent = new Intent(this, Stage2Activity.class);//(移動元のActivity、移動先のActivity）
            startActivity(intent);

        }else {//ドアが閉まったまま
            //鍵があるかどうか
            if(hasKey){
                //鍵があるならドアをあける　
                buttonDoor.setBackgroundResource(R.drawable.door2);
                isOpened = true;
                //文を一時的に表示
                Toast.makeText(this, "ドアが開いたよ！", Toast.LENGTH_SHORT).show();

            }else{//鍵がない
                Toast.makeText(this,"鍵がないよ！",Toast.LENGTH_SHORT).show();

            }

        }
    }
}