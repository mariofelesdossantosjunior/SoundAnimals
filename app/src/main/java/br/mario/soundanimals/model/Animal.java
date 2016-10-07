package br.mario.soundanimals.model;

/**
 * Created by mario on 07/10/16.
 */

public class Animal {
    private String nome;
    private String urlSound;
    private String urlImage;

    public Animal() {
    }

    public Animal(String nome, String urlSound, String urlImage) {
        this.nome = nome;
        this.urlSound = urlSound;
        this.urlImage = urlImage;
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

    @Override
    public String toString() {
        return "Animal{" +
                "nome='" + nome + '\'' +
                ", urlSound='" + urlSound + '\'' +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
