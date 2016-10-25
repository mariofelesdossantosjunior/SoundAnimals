package br.mario.soundanimals.model;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by mario on 07/10/16.
 */

public class Animal extends SugarRecord implements Serializable {
    private String nome;
    private String urlSound;
    private String urlImage;
    private int color;

    public Animal() {
    }

    public Animal(String nome, String urlSound, String urlImage, int color) {
        this.nome = nome;
        this.urlSound = urlSound;
        this.urlImage = urlImage;
        this.color = color;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlSound() {
        return urlSound;
    }

    public void setUrlSound(String urlSound) {
        this.urlSound = urlSound;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nome='" + nome + '\'' +
                ", urlSound='" + urlSound + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", color=" + color +
                '}';
    }
}
