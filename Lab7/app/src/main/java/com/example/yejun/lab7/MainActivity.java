package com.example.yejun.lab7;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.example.yejun.lab7.R.id.audio1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout layout1 = (LinearLayout) findViewById(audio1);
        String tag1 = (String) layout1.getTag();
        final int id_audio1 = getResources().getIdentifier(tag1, "raw", getPackageName()); //raw 폴더 안에 tag1과 같은 이름의 파일을 불러온다

        final LinearLayout layout2 = (LinearLayout) findViewById(R.id.audio2);
        String tag2 = (String) layout2.getTag();
        final int id_audio2 = getResources().getIdentifier(tag2, "raw", getPackageName());

        MediaPlayer mp1 = new MediaPlayer();
        mp1 = MediaPlayer.create(getApplication(), id_audio1);

        MediaPlayer mp2 = new MediaPlayer();
        mp2 = MediaPlayer.create(getApplication(), id_audio2);

        final MediaPlayer finalMp1 = mp1;
        final MediaPlayer finalMp2 = mp2;

        finalMp1.start();
        finalMp1.pause();
        finalMp2.start();
        finalMp2.pause();

        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    layout2.setBackgroundColor(Color.TRANSPARENT);
                    finalMp2.pause();
                    finalMp1.start();
                    Toast.makeText(getApplication(), "음악 파일 재생 시작됨", Toast.LENGTH_LONG).show();
                    layout1.setBackgroundColor(Color.GRAY);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    layout1.setBackgroundColor(Color.TRANSPARENT);
                    finalMp1.pause();
                    finalMp2.start();
                    Toast.makeText(getApplication(), "음악 파일 재생 시작됨", Toast.LENGTH_LONG).show();
                    layout2.setBackgroundColor(Color.GRAY);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}