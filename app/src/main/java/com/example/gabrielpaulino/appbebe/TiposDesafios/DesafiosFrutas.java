package com.example.gabrielpaulino.appbebe.TiposDesafios;

import android.util.Log;

import com.example.gabrielpaulino.appbebe.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GabrielPaulino on 23/11/2016.
 */

public class DesafiosFrutas extends Desafios {

    public DesafiosFrutas(String Name) {
        super(Name);
    }

    @Override
    public void IniciarItens(){
        ItensList.add(gerarItem(R.drawable.abacaxi1,"abacaxi"));
        ItensList.add(gerarItem(R.drawable.abacate1,"abacate"));
        ItensList.add(gerarItem(R.drawable.laranja1,"laranja"));
        ItensList.add(gerarItem(R.drawable.acerola1,"acerola"));
        ItensList.add(gerarItem(R.drawable.acai2,"açaí"));
        ItensList.add(gerarItem(R.drawable.banana1,"banana"));
        ItensList.add(gerarItem(R.drawable.caju1,"caju"));
        ItensList.add(gerarItem(R.drawable.goiaba1,"goiba"));
        ItensList.add(gerarItem(R.drawable.graviola1,"graviola"));
        ItensList.add(gerarItem(R.drawable.jaca1,"jaca"));
        ItensList.add(gerarItem(R.drawable.kiwi1,"kiwi"));
        ItensList.add(gerarItem(R.drawable.limao1,"limão"));
        ItensList.add(gerarItem(R.drawable.maca1,"maçã verde"));
        ItensList.add(gerarItem(R.drawable.maca2,"maçã vermelha"));
        ItensList.add(gerarItem(R.drawable.mamao1,"mamão"));
        ItensList.add(gerarItem(R.drawable.manga1,"manga"));
        ItensList.add(gerarItem(R.drawable.maracujar1,"maracujar"));
        ItensList.add(gerarItem(R.drawable.melancia1,"melancia"));
        ItensList.add(gerarItem(R.drawable.tangirina1,"tangirina"));
        ItensList.add(gerarItem(R.drawable.uva1,"uva roxa"));
        ItensList.add(gerarItem(R.drawable.uva2,"uva verde"));
    }

}