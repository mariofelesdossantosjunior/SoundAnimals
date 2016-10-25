package br.mario.soundanimals.fragments;

import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.IOException;

import br.mario.soundanimals.R;
import br.mario.soundanimals.model.Animal;
import br.mario.soundanimals.util.MediaPlayer;

import static br.mario.soundanimals.activity.MainActivity.SERVER_SOUND;

/**
 * Created by mario on 07/10/16.
 */

public class GenericFragment extends Fragment implements MediaPlayer{

    private static final String LOG_TAG = GenericFragment.class.getSimpleName();
    private static final String ARG_ANIMAL= "animal";

    private ImageView imgAnimal;
    private Button btAnimal;
    private Animal animal;

    public GenericFragment() {
    }

    public static Fragment newInstance(Animal animal) {
        GenericFragment f = new GenericFragment();

        Bundle b = new Bundle();
        b.putSerializable(ARG_ANIMAL, animal);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_generic, container, false);

        animal = new Animal();
        animal = (Animal) getArguments().getSerializable(ARG_ANIMAL);

        imgAnimal = (ImageView) view.findViewById(R.id.imAnimal);
        Picasso.with(getContext()).load(animal.getUrlImage()).into(imgAnimal);

        btAnimal = (Button) view.findViewById(R.id.btSound);
        btAnimal.setBackgroundColor(animal.getColor());

        btAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(animal.getNome());
            }
        });
        return view;
    }

    @Override
    public void playSound(String nameSound) {
        android.media.MediaPlayer mediaPlayer = new android.media.MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            Log.i(LOG_TAG,"URL: "+SERVER_SOUND.concat(nameSound).concat(".mp3"));
            mediaPlayer.setDataSource(SERVER_SOUND.concat(nameSound).concat(".mp3"));
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaPlayer.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(android.media.MediaPlayer player) {
                player.start();
            }
        });
    }
}
