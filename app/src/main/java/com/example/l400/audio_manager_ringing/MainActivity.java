package com.example.l400.audio_manager_ringing;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button checkmode,vibrate,silent,ringing;
    TextView textView;
    private AudioManager audioManager;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkmode = (Button)findViewById(R.id.checkmode);
        vibrate = (Button)findViewById(R.id.vibrate);
        silent = (Button)findViewById(R.id.silent);
        ringing = (Button)findViewById(R.id.ring);
        textView = (TextView)findViewById(R.id.textView);
        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

    }
    public void ringing(View view)
    {
     audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
    }
    public void silent(View view){
        audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
    }
    public void vibrate(View view){
        audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
    }
    public void checkmode(View view){
        int mod = audioManager.getRingerMode();
        if(mod== AudioManager.RINGER_MODE_NORMAL){
            textView.setText("current status : ringing");
        }
        if(mod== AudioManager.RINGER_MODE_SILENT){
            textView.setText("current status : silent");
        }
        if(mod==AudioManager.RINGER_MODE_VIBRATE){
            textView.setText("current mode : vibrate");
        }
    }
}
