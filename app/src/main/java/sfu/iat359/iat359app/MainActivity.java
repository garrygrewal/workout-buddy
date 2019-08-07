package sfu.iat359.iat359app;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {

    private static final String DEBUG_TAG = "MyFirstAppLogging";
    private MediaPlayer mp; //declare a member variable for the MediaPlayer object



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(DEBUG_TAG, "in the onCreate() method");

        playMusicFromWeb();
    }


    public void playMusicFromWeb() {
        try {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.song);
            mp.start();
        }
        catch (Exception e) {
            Log.e(DEBUG_TAG, "Player failed", e);
        }
    }

    @Override
    protected void onStop() {
        if (mp != null) {
            mp.stop();
            mp.release();
        }
        super.onStop();
    }


}
