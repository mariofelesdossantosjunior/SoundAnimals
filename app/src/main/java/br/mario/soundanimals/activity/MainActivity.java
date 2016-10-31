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
        animals = Animal.listAll(Animal.class);
        if(!this.animals.isEmpty()){
            Animal.deleteAll(Animal.class);
        }

        new Animal("gato",SERVER_SOUND+"gato.mp3",SERVER_IMAGE+"gato.webp", Color.BLUE).save();
        new Animal("burro",SERVER_SOUND+"burro.mp3",SERVER_IMAGE+"burro.webp",Color.GREEN).save();
        new Animal("cachorro",SERVER_SOUND+"cachorro.mp3",SERVER_IMAGE+"cachorro.webp",Color.RED).save();
        new Animal("elefante",SERVER_SOUND+"elefante.mp3",SERVER_IMAGE+"elefante.webp",Color.DKGRAY).save();
        new Animal("galinha",SERVER_SOUND+"galinha.mp3",SERVER_IMAGE+"galinha.webp",Color.YELLOW).save();
        new Animal("leao",SERVER_SOUND+"leao.mp3",SERVER_IMAGE+"leao.webp",Color.MAGENTA).save();
        new Animal("macaco",SERVER_SOUND+"macaco.mp3",SERVER_IMAGE+"macaco.webp",Color.YELLOW).save();
        new Animal("pintinho",SERVER_SOUND+"pintinho.mp3",SERVER_IMAGE+"pintinho.webp",Color.GREEN).save();
        new Animal("porco",SERVER_SOUND+"porco.mp3",SERVER_IMAGE+"porco.webp",Color.BLACK).save();
        new Animal("vaca",SERVER_SOUND+"vaca.mp3",SERVER_IMAGE+"vaca.webp",Color.GRAY).save();
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), Animal.listAll(Animal.class));
        viewPager.setAdapter(adapter);
    }


}

