package org.androidtown.lab4;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText edittxt;
    RadioGroup radiogrp;
    RadioButton man;
    RadioButton woman;
    CheckBox ch1;
    CheckBox ch2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.register_btn);
        edittxt = (EditText)findViewById(R.id.name);
        radiogrp = (RadioGroup)findViewById(R.id.radiogrp);
        man = (RadioButton)findViewById(R.id.man);
        woman = (RadioButton)findViewById(R.id.woman);
        ch1 = (CheckBox)findViewById(R.id.chckbx1);
        ch2 = (CheckBox)findViewById(R.id.chckbx2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Second class로 이동하는 intent 생성
                Intent intent = new Intent(getApplicationContext(), Second.class);
                Bundle myBundle = new Bundle();

                //name 값을 bundle에 put
                myBundle.putString("name", edittxt.getText().toString());

                //gender 값을 bundle에 put
                int radioId = radiogrp.getCheckedRadioButtonId();
                if(man.getId() == radioId)
                    myBundle.putString("gender", "man");
                if(woman.getId() == radioId)
                    myBundle.putString("gender", "woman");

                //receive type 값을 bundle에 put
                String str = "";
                if(ch1.isChecked() && ch2.isChecked())
                    str = str + "SMS / e-mail";
                else if(ch1.isChecked())
                    str = str + "SMS";
                else if(ch2.isChecked())
                    str = str + "e-mail";
                else
                str = str + "Noting";

                myBundle.putString("type", str);
                //bundle을 intent에 put
                intent.putExtras(myBundle);
                //intent값을 전달하여 activity 실행
                startActivity(intent);
            }

        });
    }
}
