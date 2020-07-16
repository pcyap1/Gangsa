package com.example.a198_try;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Context;
import android.gesture.Gesture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * This class manages the Playing page.
 */

public class activity_play extends AppCompatActivity implements View.OnTouchListener {

    private ImageView button;
    private GestureDetectorCompat mGestureDetector;
    Spinner spinner;
    private SoundPool soundPool;
    private int sound_ghd1, sound_ghr1, sound_ghs1;
    private int sound_ghd2, sound_ghr2, sound_ghs2;
    private int sound_ghd3, sound_ghr3, sound_ghs3;
    private int sound_ghd4, sound_ghr4, sound_ghs4;
    private int sound_ghd5, sound_ghr5, sound_ghs5;
    private int sound_ghd6, sound_ghr6, sound_ghs6;
    private int sound_gsd1, sound_gsr1;
    private int sound_gsd2, sound_gsr2;
    private int sound_gsd3, sound_gsr3;
    private int sound_gsd4, sound_gsr4;
    private int sound_gsd5, sound_gsr5;
    private int sound_gsd6, sound_gsr6;





/*
    MediaPlayer player_gangsa1_hand_r, player_gangsa1_stick_r,
            player_gangsa2_hand_r, player_gangsa2_stick_r,
            player_gangsa3_hand_r, player_gangsa3_stick_r,
            player_gangsa4_hand_r, player_gangsa4_stick_r,
            player_gangsa5_hand_r, player_gangsa5_stick_r,
            player_gangsa6_hand_r, player_gangsa6_stick_r;
    MediaPlayer player_gangsa1_hand_d, player_gangsa1_stick_d,
            player_gangsa2_hand_d, player_gangsa2_stick_d,
            player_gangsa3_hand_d, player_gangsa3_stick_d,
            player_gangsa4_hand_d, player_gangsa4_stick_d,
            player_gangsa5_hand_d, player_gangsa5_stick_d,
            player_gangsa6_hand_d, player_gangsa6_stick_d;
    MediaPlayer player_gangsa1_hand_s,
            player_gangsa2_hand_s,
            player_gangsa3_hand_s,
            player_gangsa4_hand_s,
            player_gangsa5_hand_s,
            player_gangsa6_hand_s;
    View v;
*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // SET APP TO FULL SCREEN
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_play);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            soundPool = new SoundPool.Builder().setMaxStreams(5).build();
        } else {
            soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0 );
        }
        sound_ghd1 = soundPool.load(this, R.raw.ghd1_synth, 1);
        sound_ghd2 = soundPool.load(this, R.raw.ghd2_synth, 1);
        sound_ghd3 = soundPool.load(this, R.raw.ghd3_synth, 1);
        sound_ghd4 = soundPool.load(this, R.raw.ghd4_synth, 1);
        sound_ghd5 = soundPool.load(this, R.raw.ghd5_synth, 1);
        sound_ghd6 = soundPool.load(this, R.raw.ghd6_synth, 1);
        sound_ghr1 = soundPool.load(this, R.raw.ghr1_synth, 1);
        sound_ghr2 = soundPool.load(this, R.raw.ghr2_synth, 1);
        sound_ghr3 = soundPool.load(this, R.raw.ghr3_synth, 1);
        sound_ghr4 = soundPool.load(this, R.raw.ghr4_synth, 1);
        sound_ghr5 = soundPool.load(this, R.raw.ghr5_synth, 1);
        sound_ghr6 = soundPool.load(this, R.raw.ghr6_synth, 1);
        sound_ghs1 = soundPool.load(this, R.raw.ghs1_synth, 1);
        sound_ghs2 = soundPool.load(this, R.raw.ghs2_synth, 1);
        sound_ghs3 = soundPool.load(this, R.raw.ghs3_synth, 1);
        sound_ghs4 = soundPool.load(this, R.raw.ghs4_synth, 1);
        sound_ghs5 = soundPool.load(this, R.raw.ghs5_synth, 1);
        sound_ghs6 = soundPool.load(this, R.raw.ghs6_synth, 1);
        sound_gsd1 = soundPool.load(this, R.raw.gsd1_synth, 1);
        sound_gsd2 = soundPool.load(this, R.raw.gsd2_synth, 1);
        sound_gsd3 = soundPool.load(this, R.raw.gsd3_synth, 1);
        sound_gsd4 = soundPool.load(this, R.raw.gsd4_synth, 1);
        sound_gsd5 = soundPool.load(this, R.raw.gsd5_synth, 1);
        sound_gsd6 = soundPool.load(this, R.raw.gsd6_synth, 1);
        sound_gsr1 = soundPool.load(this, R.raw.gsr1_synth, 1);
        sound_gsr2 = soundPool.load(this, R.raw.gsr2_synth, 1);
        sound_gsr3 = soundPool.load(this, R.raw.gsr3_synth, 1);
        sound_gsr4 = soundPool.load(this, R.raw.gsr4_synth, 1);
        sound_gsr5 = soundPool.load(this, R.raw.gsr5_synth, 1);
        sound_gsr6 = soundPool.load(this, R.raw.gsr6_synth, 1);


        /*------------------------SPINNER / DROPDOWN MENU ---------------------------------------*/

        // The following section of code manages the spinner (aka dropdown menu) contents.

        // DROPDOWN ITEM LABEL
        final String str[] = {
                "Gangsa 1 using Hand", "Gangsa 1 using Stick",
                "Gangsa 2 using Hand", "Gangsa 2 using Stick",
                "Gangsa 3 using Hand", "Gangsa 3 using Stick",
                "Gangsa 4 using Hand", "Gangsa 4 using Stick",
                "Gangsa 5 using Hand", "Gangsa 5 using Stick",
                "Gangsa 6 using Hand", "Gangsa 6 using Stick"};

        spinner = findViewById(R.id.spinner1);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.custom_spinner,
                getResources().getStringArray(R.array.options)
        );
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        spinner.setAdapter(adapter);

        // SET GANGSA IMAGE CORRESPONDING TO THE SELECTED SPINNER ITEM
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(str[0].equals(spinner.getItemAtPosition(position).toString())){
                    button.setImageResource(R.drawable.gangsa1);
                } else if(str[1].equals(spinner.getItemAtPosition(position).toString())){
                    button.setImageResource(R.drawable.gangsa1);
                } else if(str[2].equals(spinner.getItemAtPosition(position).toString())){
                    button.setImageResource(R.drawable.gangsa2);
                } else if(str[3].equals(spinner.getItemAtPosition(position).toString())) {
                    button.setImageResource(R.drawable.gangsa2);
                } else if(str[4].equals(spinner.getItemAtPosition(position).toString())) {
                    button.setImageResource(R.drawable.gangsa3);
                } else if(str[5].equals(spinner.getItemAtPosition(position).toString())) {
                    button.setImageResource(R.drawable.gangsa3);
                } else if(str[6].equals(spinner.getItemAtPosition(position).toString())){
                    button.setImageResource(R.drawable.gangsa4);
                } else if(str[7].equals(spinner.getItemAtPosition(position).toString())){
                    button.setImageResource(R.drawable.gangsa4);
                } else if(str[8].equals(spinner.getItemAtPosition(position).toString())){
                    button.setImageResource(R.drawable.gangsa5);
                } else if(str[9].equals(spinner.getItemAtPosition(position).toString())) {
                    button.setImageResource(R.drawable.gangsa5);
                } else if(str[10].equals(spinner.getItemAtPosition(position).toString())) {
                    button.setImageResource(R.drawable.gangsa6);
                } else if(str[11].equals(spinner.getItemAtPosition(position).toString())) {
                    button.setImageResource(R.drawable.gangsa6);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /*---------------------------------------------------------------------------------------*/

        // DECLARATIONS FOR THE NEXT SECTION OF CODE (ON GESTURES DETECTION)
        button = findViewById(R.id.button_gangsa);
        button.setOnTouchListener((View.OnTouchListener) this);
        mGestureDetector = new GestureDetectorCompat(this, new GestureListener());
    }

    /*-------------------- ON TOUCH LISTENER & GESTURE DETECTOR ---------------------------------*/

    // The following section of code manages gesture detection (touch listener and gesture detector).

    // LISTEN FOR TOUCH EVENTS (FOR WHEN THE USER TOUCHES THE SCREEN)
    @Override
    public boolean onTouch (View v, MotionEvent event){
        mGestureDetector.onTouchEvent(event);

        return false;
    }

    // LISTEN FOR GESTURES (FOR WHEN THE USER PERFORMS ANY OF THE THREE(3) GESTURES:
    // SINGLE TAP, LONG PRESS, OR FLING
    private class GestureListener extends GestureDetector.SimpleOnGestureListener {

        // SET CORRESPONDING ACTION FOR WHEN THE USER PERFORMS A LONG PRESS ON THE SCREEN
        @Override
        public void onLongPress(MotionEvent e) {
            Toast.makeText(activity_play.this,
                    "long press", Toast.LENGTH_SHORT).show();    // GESTURE CONFIRMATORY TEXT

            if(("Gangsa 1 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsd1, 1,1,0,0,1);
            } else if(("Gangsa 2 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsd2, 1,1,0,0,1);
            } else if(("Gangsa 3 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsd3, 1,1,0,0,1);
            } else if(("Gangsa 4 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsd4, 1,1,0,0,1);
            } else if(("Gangsa 5 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsd5, 1,1,0,0,1);
            } else if(("Gangsa 6 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsd6, 1,1,0,0,1);
            } else if(("Gangsa 1 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghd1, 1,1,0,0,1);
            } else if(("Gangsa 2 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghd2, 1,1,0,0,1);
            } else if(("Gangsa 3 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghd3, 1,1,0,0,1);
            } else if(("Gangsa 4 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghd4, 1,1,0,0,1);
            } else if(("Gangsa 5 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghd5, 1,1,0,0,1);
            } else if(("Gangsa 6 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghd6, 1,1,0,0,1);
            }

            super.onLongPress(e);
        }

        // SET CORRESPONDING ACTION FOR WHEN THE USER PERFORMS A FLING ON THE SCREEN
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Toast.makeText(activity_play.this,
                    "fling", Toast.LENGTH_SHORT).show();    // GESTURE CONFIRMATORY TEXT

        if(("Gangsa 1 using Hand").equals(spinner.getSelectedItem().toString())){
            soundPool.play(sound_ghs1, 1,1,0,0,1);
        } else if(("Gangsa 2 using Hand").equals(spinner.getSelectedItem().toString())){
            soundPool.play(sound_ghs2, 1,1,0,0,1);
        } else if(("Gangsa 3 using Hand").equals(spinner.getSelectedItem().toString())){
            soundPool.play(sound_ghs3, 1,1,0,0,1);
        } else if(("Gangsa 4 using Hand").equals(spinner.getSelectedItem().toString())){
            soundPool.play(sound_ghs4, 1,1,0,0,1);
        } else if(("Gangsa 5 using Hand").equals(spinner.getSelectedItem().toString())){
            soundPool.play(sound_ghs5, 1,1,0,0,1);
        } else if(("Gangsa 6 using Hand").equals(spinner.getSelectedItem().toString())){
            soundPool.play(sound_ghs6, 1,1,0,0,1);
        }

            //playHandSliding(v);    // AUDIO PLAYBACK

            return super.onFling(e1, e2, velocityX, velocityY);
        }

        // SET CORRESPONDING ACTION FOR WHEN THE USER PERFORMS A SINGLE TAP ON THE SCREEN
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Toast.makeText(activity_play.this,
                    "single tap", Toast.LENGTH_SHORT).show();   // GESTURE CONFIRMATORY TEXT

            if(("Gangsa 1 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsr1, 1,1,0,0,1);
            } else if(("Gangsa 2 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsr2, 1,1,0,0,1);
            } else if(("Gangsa 3 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsr3, 1,1,0,0,1);
            } else if(("Gangsa 4 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsr4, 1,1,0,0,1);
            } else if(("Gangsa 5 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsr5, 1,1,0,0,1);
            } else if(("Gangsa 6 using Stick").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_gsr6, 1,1,0,0,1);
            } else if(("Gangsa 1 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghr1, 1,1,0,0,1);
            } else if(("Gangsa 2 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghr2, 1,1,0,0,1);
            } else if(("Gangsa 3 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghr3, 1,1,0,0,1);
            } else if(("Gangsa 4 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghr4, 1,1,0,0,1);
            } else if(("Gangsa 5 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghr5, 1,1,0,0,1);
            } else if(("Gangsa 6 using Hand").equals(spinner.getSelectedItem().toString())){
                soundPool.play(sound_ghr6, 1,1,0,0,1);
            }

            return super.onSingleTapConfirmed(e);
        }
    }

    /*-------------------------------------------------------------------------------------------*/


    /*--------------------------------- AUDIO PLAYBACK ------------------------------------------

    // The following section of code manages audio playback.

    //
    public void playStickRinging1 (View v){
        if (player_gangsa1_stick_r == null) {
            player_gangsa1_stick_r = MediaPlayer.create(this, R.raw.gsr1_synth);


        }
        //sp.play(sound1, 1.0f, 1.0f, 0,0,10f);
        //player_gangsa1_stick_r.start();
    }

    public void playStickRinging2 (View v){
        if (player_gangsa2_stick_r == null) {
            player_gangsa2_stick_r = MediaPlayer.create(this, R.raw.gsr2_synth);
        }

        player_gangsa2_stick_r.start();
    }

    public void playStickRinging3 (View v){
        if (player_gangsa3_stick_r == null) {
            player_gangsa3_stick_r = MediaPlayer.create(this, R.raw.gsr3_synth);
        }

        player_gangsa3_stick_r.start();
    }

    public void playStickRinging4 (View v){
        if (player_gangsa4_stick_r == null) {
            player_gangsa4_stick_r = MediaPlayer.create(this, R.raw.gsr4_synth);
        }

        player_gangsa4_stick_r.start();
    }

    public void playStickRinging5 (View v){
        if (player_gangsa5_stick_r == null) {
            player_gangsa5_stick_r = MediaPlayer.create(this, R.raw.gsr5_synth);
        }

        player_gangsa5_stick_r.start();
    }

    public void playStickRinging6 (View v){
        if (player_gangsa6_stick_r == null) {
            player_gangsa6_stick_r = MediaPlayer.create(this, R.raw.gsr6_synth);
        }

        player_gangsa6_stick_r.start();
    }

    public void playHandRinging1 (View v){
        if (player_gangsa1_hand_r == null) {
            player_gangsa1_hand_r = MediaPlayer.create(this, R.raw.ghr1_synth);
        }

        player_gangsa1_hand_r.start();
    }

    public void playHandRinging2 (View v){
        if (player_gangsa2_hand_r == null) {
            player_gangsa2_hand_r = MediaPlayer.create(this, R.raw.ghr2_synth);
        }

        player_gangsa2_hand_r.start();
    }

    public void playHandRinging3 (View v){
        if (player_gangsa3_hand_r == null) {
            player_gangsa3_hand_r = MediaPlayer.create(this, R.raw.ghr3_synth);
        }

        player_gangsa3_hand_r.start();
    }

    public void playHandRinging4 (View v){
        if (player_gangsa4_hand_r == null) {
            player_gangsa4_hand_r = MediaPlayer.create(this, R.raw.ghr4_synth);
        }

        player_gangsa4_hand_r.start();
    }

    public void playHandRinging5 (View v){
        if (player_gangsa5_hand_r == null) {
            player_gangsa5_hand_r = MediaPlayer.create(this, R.raw.ghr5_synth);
        }

        player_gangsa5_hand_r.start();
    }

    public void playHandRinging6 (View v){
        if (player_gangsa6_hand_r == null) {
            player_gangsa6_hand_r= MediaPlayer.create(this, R.raw.ghr6_synth);
        }

        player_gangsa6_hand_r.start();
    }

    //

    public void playStickDamping1 (View v){
        if (player_gangsa1_stick_d == null) {
            player_gangsa1_stick_d = MediaPlayer.create(this, R.raw.gsd1_synth);
        }

        player_gangsa1_stick_d.start();
    }

    public void playStickDamping2 (View v){
        if (player_gangsa2_stick_d == null) {
            player_gangsa2_stick_d = MediaPlayer.create(this, R.raw.gsd2_synth);
        }

        player_gangsa2_stick_d.start();
    }

    public void playStickDamping3 (View v){
        if (player_gangsa3_stick_d == null) {
            player_gangsa3_stick_d = MediaPlayer.create(this, R.raw.gsd3_synth);
        }

        player_gangsa3_stick_d.start();
    }

    public void playStickDamping4 (View v){
        if (player_gangsa4_stick_d == null) {
            player_gangsa4_stick_d = MediaPlayer.create(this, R.raw.gsd4_synth);
        }

        player_gangsa4_stick_d.start();
    }

    public void playStickDamping5 (View v){
        if (player_gangsa5_stick_d == null) {
            player_gangsa5_stick_d = MediaPlayer.create(this, R.raw.gsd5_synth);
        }

        player_gangsa5_stick_d.start();
    }

    public void playStickDamping6 (View v){
        if (player_gangsa6_stick_d == null) {
            player_gangsa6_stick_d = MediaPlayer.create(this, R.raw.gsd6_synth);
        }

        player_gangsa6_stick_d.start();
    }

    public void playHandDamping1 (View v){
        if (player_gangsa1_hand_d == null) {
            player_gangsa1_hand_d = MediaPlayer.create(this, R.raw.ghd1_synth);
        }

        player_gangsa1_hand_d.start();
    }

    public void playHandDamping2 (View v){
        if (player_gangsa2_hand_d == null) {
            player_gangsa2_hand_d = MediaPlayer.create(this, R.raw.ghd2_synth);
        }

        player_gangsa2_hand_d.start();
    }

    public void playHandDamping3 (View v){
        if (player_gangsa3_hand_d == null) {
            player_gangsa3_hand_d = MediaPlayer.create(this, R.raw.ghd3_synth);
        }

        player_gangsa3_hand_d.start();
    }

    public void playHandDamping4 (View v){
        if (player_gangsa4_hand_d == null) {
            player_gangsa4_hand_d = MediaPlayer.create(this, R.raw.ghd4_synth);
        }

        player_gangsa4_hand_d.start();
    }

    public void playHandDamping5 (View v){
        if (player_gangsa5_hand_d == null) {
            player_gangsa5_hand_d = MediaPlayer.create(this, R.raw.ghd5_synth);
        }

        player_gangsa5_hand_d.start();
    }

    public void playHandDamping6 (View v){
        if (player_gangsa6_hand_d == null) {
            player_gangsa6_hand_d= MediaPlayer.create(this, R.raw.ghd6_synth);
        }

        player_gangsa6_hand_d.start();
    }

    //

    public void playHandSliding1 (View v){
        if (player_gangsa1_hand_s == null) {
            player_gangsa1_hand_s = MediaPlayer.create(this, R.raw.ghs1_synth);
        }

        player_gangsa1_hand_s.start();
    }

    public void playHandSliding2 (View v){
        if (player_gangsa2_hand_s == null) {
            player_gangsa2_hand_s = MediaPlayer.create(this, R.raw.ghs2_synth);
        }

        player_gangsa2_hand_s.start();
    }
    public void playHandSliding3 (View v){
        if (player_gangsa3_hand_s == null) {
            player_gangsa3_hand_s = MediaPlayer.create(this, R.raw.ghs3_synth);
        }

        player_gangsa3_hand_s.start();
    }
    public void playHandSliding4 (View v){
        if (player_gangsa4_hand_s == null) {
            player_gangsa4_hand_s = MediaPlayer.create(this, R.raw.ghs4_synth);
        }

        player_gangsa4_hand_s.start();
    }
    public void playHandSliding5 (View v){
        if (player_gangsa5_hand_s == null) {
            player_gangsa5_hand_s = MediaPlayer.create(this, R.raw.ghs5_synth);
        }

        player_gangsa5_hand_s.start();
    }
    public void playHandSliding6 (View v){
        if (player_gangsa6_hand_s == null) {
            player_gangsa6_hand_s = MediaPlayer.create(this, R.raw.ghs6_synth);
        }

        player_gangsa6_hand_s.start();
    }
*/
}
