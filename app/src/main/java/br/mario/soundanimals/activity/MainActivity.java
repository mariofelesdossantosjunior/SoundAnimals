package br.mario.soundanimals.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import br.mario.soundanimals.R;
import br.mario.soundanimals.fragments.GenericFragment;
import br.mario.soundanimals.model.Animal;

/**
 * @autor Mario feles dos Santos Junior
 * @email mario_feles@live.com
 * @since 07-10-2016
 */
public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String SERVER_SOUND = "http://mariofelesdossantosjunior.890m.com/sounds/";
    public static final String SERVER_IMAGE = "http://mariofelesdossantosjunior.890m.com/images/";

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    List<Animal> animals = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initListAnimals();

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        //initButtons();
    }

    private void initListAnimals(){
        animals.add(new Animal("gato",SERVER_SOUND+"gato.mp3",SERVER_IMAGE+"gato.jpg"));
        animals.add(new Animal("cachorro",SERVER_SOUND+"cachorro.mp3",SERVER_IMAGE+"cachorro.jpg"));
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        for(Animal animal : animals){
            adapter.addFragment(new GenericFragment(), animal.getNome());
        }

        viewPager.setAdapter(adapter);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    /**
     * Metodo responsavel por iniciar os botoes
     * implementando os id
     *//*
    private void initButtons(){
        for( int id : buttonsIds ){
            setOnClickListinner( id );
        }
    }

    *//**
     * Metodo responsavel pela ação do click
     * dos botoes de forma generica
     * @param viewId R.id.???
     *//*
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

    *//**
     * Metodo responsavel pela Sound Player
     * @param animal Nome Animal
     *//*
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
    }*/
}

