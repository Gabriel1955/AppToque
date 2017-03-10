package com.example.gabrielpaulino.appbebe.TiposDesafios;

import com.example.gabrielpaulino.appbebe.R;

/**
 * Created by GabrielPaulino on 23/11/2016.
 */

public class DesafiosNumeros extends Desafios {
    public DesafiosNumeros(String Name){
        super(Name);
    }
    @Override
    protected void IniciarItens() {
        ItensList.add(gerarItem(R.drawable.n_um1,"numero um"));
        ItensList.add(gerarItem(R.drawable.n_dois1,"numero dois"));
        ItensList.add(gerarItem(R.drawable.n_tres1,"numero tres"));
        ItensList.add(gerarItem(R.drawable.n_quatro1,"numero quatro"));
    }
}
