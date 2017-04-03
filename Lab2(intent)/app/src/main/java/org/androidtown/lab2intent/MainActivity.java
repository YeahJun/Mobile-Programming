package org.androidtown.lab2intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText Name;
    EditText Age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Activity_main의 위젯들과 연동
        btn = (Button)findViewById(R.id.btn);
        Name = (EditText)findViewById(R.id.editText1);
        Age = (EditText)findViewById(R.id.editText2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //입력된 값들을 outName, outAge라는 string 변수에 저장
                String outName = Name.getText().toString();
                String outAge = Age.getText().toString();
                //새로운 activity(new.java)에게 값을 전달할 intent생성
                Intent intent = new Intent(getApplicationContext(), New.class);
                //outName과 outAge값을 intent의 name과 age에 전달
                intent.putExtra("name", outName);
                intent.putExtra("age", outAge);
                //intent값을 전달하여 activity 시작
                startActivity(intent);
            }
        });
    }
}
