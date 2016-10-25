package br.mario.soundanimals.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import br.mario.soundanimals.R;
import br.mario.soundanimals.adapters.ViewPagerAdapter;
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

    }

    private void initListAnimals(){
        animals.add(new Animal("gato",SERVER_SOUND+"gato.mp3",SERVER_IMAGE+"gato.png", Color.BLUE));
        animals.add(new Animal("burro",SERVER_SOUND+"burro.mp3",SERVER_IMAGE+"burro.png",Color.GREEN));
        animals.add(new Animal("cachorro",SERVER_SOUND+"cachorro.mp3",SERVER_IMAGE+"cachorro.png",Color.RED));
        //animals.add(new Animal("cavalo",SERVER_SOUND+"cavalo.mp3",SERVER_IMAGE+"cavalo.png"));
        animals.add(new Animal("elefante",SERVER_SOUND+"elefante.mp3",SERVER_IMAGE+"elefante.png",Color.DKGRAY));
        animals.add(new Animal("galinha",SERVER_SOUND+"galinha.mp3",SERVER_IMAGE+"galinha.png",Color.YELLOW));
        animals.add(new Animal("leao",SERVER_SOUND+"leao.mp3",SERVER_IMAGE+"leao.png",Color.MAGENTA));
        animals.add(new Animal("macaco",SERVER_SOUND+"macaco.mp3",SERVER_IMAGE+"macaco.png",Color.YELLOW));
        //animals.add(new Animal("ovelha",SERVER_SOUND+"ovelha.mp3",SERVER_IMAGE+"ovelha.png"));
        //animals.add(new Animal("pato",SERVER_SOUND+"pato.mp3",SERVER_IMAGE+"pato.png"));
        animals.add(new Animal("pintinho",SERVER_SOUND+"pintinho.mp3",SERVER_IMAGE+"pintinho.png",Color.GREEN));
        animals.add(new Animal("porco",SERVER_SOUND+"porco.mp3",SERVER_IMAGE+"porco.png",Color.BLACK));
        //animals.add(new Animal("sapo",SERVER_SOUND+"sapo.mp3",SERVER_IMAGE+"sapo.png"));
        animals.add(new Animal("vaca",SERVER_SOUND+"vaca.mp3",SERVER_IMAGE+"vaca.png",Color.GRAY));
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), animals);
        viewPager.setAdapter(adapter);
    }


}

