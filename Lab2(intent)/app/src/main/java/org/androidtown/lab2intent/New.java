package org.androidtown.lab2intent;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.view.*;

public class New extends AppCompatActivity {

    Button nbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        //activity_new의 newbtn과 연동
        nbtn = (Button)findViewById(R.id.newbtn);
        //mainactivity에서 전달받은 값을 위한 intent
        Intent passedIntent = getIntent();

        if (passedIntent != null) {
            //string 타입으로 받아온 두 값을 loginName과 loginAge라는 변수에 각각 저장
            String loginName = passedIntent.getStringExtra("name");
            String loginAge = passedIntent.getStringExtra("age");
            //받아온 값을 저장하여 toast message로 띄워준다
            Toast.makeText(getApplicationContext(), "Student info : "
                    + loginName + ", " + loginAge, Toast.LENGTH_SHORT).show();
        }
        //nbtn을 클릭하였을 때 activity_new창은 종료시켜준다
        nbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}