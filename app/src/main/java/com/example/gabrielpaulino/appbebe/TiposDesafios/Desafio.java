package com.example.gabrielpaulino.appbebe.TiposDesafios;

import android.widget.ImageView;

import com.example.gabrielpaulino.appbebe.R;

/**
 * Created by GabrielPaulino on 22/11/2016.
 */

public class Desafio {
    private int QuantidadeImagens;
    private int[] images;
    private String textDesafio;
    private String[] textImages;
    private String textSucesso;
    private int imageSucesso;
    private int tela;
    private int[] telas = new int[]{R.layout.tela2,R.layout.tela3,R.layout.tela4};
    private int BackgroudTela;

    Desafio(int quantidadeImagens){
        this.QuantidadeImagens = quantidadeImagens;
        images = new int[quantidadeImagens];
        textImages = new String[quantidadeImagens];
        tela = telas[quantidadeImagens-2];
    }
    public int getBackgroudTela() {
        return BackgroudTela;
    }

    public void setBackgroudTela(int backgroudTela) {
        BackgroudTela = backgroudTela;
    }

    public int getTela() {
        return tela;
    }

    public void setTela(int tela) {
        this.tela = tela;
    }

    public int getImageSucesso() {
        return imageSucesso;
    }

    public void setImageSucesso(int imageSucesso) {
        this.imageSucesso = imageSucesso;
    }

    public int getQuantidadeImagens() {
        return QuantidadeImagens;
    }

    public void setQuantidadeImagens(int quantidadeImagens) {
        QuantidadeImagens = quantidadeImagens;
    }

    public int[] getImages() {
        return images;
    }

    public void setImages(int[] images) {
        this.images = images;
    }

    public String getTextDesafio() {
        return textDesafio;
    }

    public void setTextDesafio(String textDesafio) {
        this.textDesafio = textDesafio;
    }

    public String[] getTextImages() {
        return textImages;
    }

    public void setTextImages(String[] textImages) {
        this.textImages = textImages;
    }

    public String getTextSucesso() {
        return textSucesso;
    }

    public void setTextSucesso(String textSucesso) {
        this.textSucesso = textSucesso;
    }
}