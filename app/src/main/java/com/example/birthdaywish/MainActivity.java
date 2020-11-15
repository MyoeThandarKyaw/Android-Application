package com.example.birthdaywish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    private Button btn_click_me;
    private ImageView img_view;
    static final int intMed = 1000;
    int interval = 2000;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        //setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        btn_click_me = (Button) findViewById(R.id.btn_click_me);
        img_view = (ImageView) findViewById(R.id.android_image);



        btn_click_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast toast = Toast.makeText(getApplicationContext(), "click me", Toast.LENGTH_LONG);
//                toast.show();
                new AutoPicsTask().execute();

                mp=MediaPlayer.create(getApplicationContext(),R.raw.hbty);// the song is a filename which i have pasted inside a folder **raw** created under the **res** folder.//
                //mp.stop();
                mp.start();

            }
        });


    }

    private  class AutoPicsTask extends AsyncTask<Integer, Void, Integer> {
        Integer pics[] = {
                R.drawable.dd_1,
                R.drawable.dd_2,
                R.drawable.dd_3,
                R.drawable.dd_4,
                R.drawable.dd_5,
                R.drawable.dd_6,
                R.drawable.dd_7,
                R.drawable.dd_8,
                R.drawable.dd_9,
                R.drawable.dd_10,
                R.drawable.dd_11,
                R.drawable.dd_12,
                R.drawable.dd_13,
                R.drawable.dd_14,
                R.drawable.dd_15,
                R.drawable.dd_16,
                R.drawable.dd_17,
                R.drawable.dd_18,
                R.drawable.dd_19,
                R.drawable.dd_20,
                R.drawable.dd_21,
                R.drawable.dd_22

        };
        @Override
        protected Integer doInBackground(Integer... integers) {
            for (final Integer p : pics) {
                SystemClock.sleep(interval);
                runOnUiThread(new Runnable(){
                    @Override
                    public void run() {
                        img_view.setImageResource(p);
                    }
                } );
            }
            return null;
        }




    }
}
