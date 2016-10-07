package br.mario.soundanimals;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.io.IOException;

/**
 * @autor Mario feles dos Santos Junior
 * @email mario_feles@live.com
 * @since 07-10-2016
 */
public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String SERVER_SOUND = "http://mariofelesdossantosjunior.890m.com/sounds/";

    private int[] buttonsIds = {R.id.btCat};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initButtons();
    }

    private void initButtons(){
        for( int id : buttonsIds ){
            setOnClickListinner( id );
        }
    }

    private void setOnClickListinner( int viewId ){
        findViewById( viewId ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btCat:
                        playSoundAnimal("gato");
                        break;
                }
            }
        });
    }



    void playSoundAnimal(String animal) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(SERVER_SOUND.concat(animal).concat(".mp3"));
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer player) {
                player.start();
            }
        });
    }
}

