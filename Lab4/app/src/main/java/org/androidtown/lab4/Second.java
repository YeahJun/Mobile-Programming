package org.androidtown.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Second extends AppCompatActivity {
    Button btn;
    Bundle bndl;
    TextView txt1, txt2, txt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //Mainactivity에서 전달한 intent를 get하기 위한 intent 생성
        Intent intent2 = getIntent();
        //intent안의 bundle을 받기 위한 bundle 생성
        bndl = intent2.getExtras();

        txt1 = (TextView)findViewById(R.id.stxt1);
        txt2 = (TextView)findViewById(R.id.stxt2);
        txt3 = (TextView)findViewById(R.id.stxt3);
        btn = (Button)findViewById(R.id.back_btn);

        //받아온 bundle의 값을 각각 꺼낸다
        txt1.setText(bndl.getString("name"));
        txt2.setText(bndl.getString("gender"));
        txt3.setText(bndl.getString("type"));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //버튼 클릭 시 second activity 종료
                finish();
            }
        });
    }
}
