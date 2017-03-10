package com.example.gabrielpaulino.appbebe.TiposDesafios;

import com.example.gabrielpaulino.appbebe.R;

/**
 * Created by GabrielPaulino on 23/11/2016.
 */

public class DesafiosCores extends Desafios {
    public DesafiosCores(String Name){
        super(Name);
    }
    @Override
    protected void IniciarItens() {
        ItensList.add(gerarItem(R.color.Branco,"branco"));
        ItensList.add(gerarItem(R.color.Verde,"Verde"));
        ItensList.add(gerarItem(R.color.Azul,"azul"));
        ItensList.add(gerarItem(R.color.Preto,"preto"));
        ItensList.add(gerarItem(R.color.Vermelho,"vermelho"));
    }
}
