package com.example.yejun.lab6;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    EditText txtUIData;

    Button btn1, btn2, btn3, btn4;
    String str;

    File sdCard = Environment.getExternalStorageDirectory();
    File directory = new File(sdCard.getAbsolutePath() + "/MyFiles");
    File file = new File(directory, "textfile.txt");
    FileOutputStream fOut = null;
    OutputStreamWriter osw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUIData = (EditText) findViewById(R.id.txtData);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);

        try {
            fOut = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Write SD file
        btn1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                directory.mkdirs();
                try {
                    fOut = new FileOutputStream(file);

                    PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(fOut));
                    printWriter.println(txtUIData.getText().toString());
                    printWriter.flush(); //txtUIData의 string을 printWriter에 쓴다

                    Toast.makeText(getApplicationContext(), "file write", Toast.LENGTH_SHORT).show();
                    fOut.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //Clear screen
        btn2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                txtUIData.setText("");
                if (file.exists()) {
                    Toast.makeText(getApplicationContext(), "file exist", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Read SD file
        btn3.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                try {
                    Toast.makeText(MainActivity.this, "read file", Toast.LENGTH_SHORT).show();
                    FileInputStream fIn;
                    BufferedReader bfReader;

                    //Read file
                    fIn = new FileInputStream(file);
                    bfReader = new BufferedReader(new FileReader(file));
                    StringBuilder buf = new StringBuilder();

                    while ((str = bfReader.readLine()) != null) {
                        buf.append(str + "\n"); //append string into buffer
                    }
                    fIn.close();

                    txtUIData.setText(buf.toString()); //Write on the txtUIData

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Exception : " + e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

            //Finish app
        btn4.setOnClickListener(new Button.OnClickListener() {
                public void onClick (View v){
                    finish();
                }
            });
        }
    }