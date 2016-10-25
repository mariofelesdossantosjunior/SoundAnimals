package br.mario.soundanimals.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import br.mario.soundanimals.fragments.GenericFragment;
import br.mario.soundanimals.model.Animal;

/**
 * Adapter to pages Animals
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    int count;
    List<Animal> lista;

    public ViewPagerAdapter(FragmentManager fm, List<Animal> lista) {
        super(fm);
        this.lista = lista;
        count = lista.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return lista.get(position).getNome();
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Fragment getItem(int position) {
        final Animal animal = lista.get(position);
        return GenericFragment.newInstance(animal);
    }

}
