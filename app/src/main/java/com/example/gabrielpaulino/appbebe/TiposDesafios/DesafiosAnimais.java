package com.example.gabrielpaulino.appbebe.TiposDesafios;

import com.example.gabrielpaulino.appbebe.R;

/**
 * Created by GabrielPaulino on 23/11/2016.
 */

public class DesafiosAnimais  extends Desafios {
    public DesafiosAnimais(String Name){
        super(Name);
    }

    @Override
    protected void IniciarItens() {
        ItensList.add(gerarItem(R.drawable.cachorro1,"cachorro"));
        ItensList.add(gerarItem(R.drawable.gato1,"gato"));
        ItensList.add(gerarItem(R.drawable.leao1,"leão"));
        ItensList.add(gerarItem(R.drawable.papagaio1,"papagaio"));
    }

}
