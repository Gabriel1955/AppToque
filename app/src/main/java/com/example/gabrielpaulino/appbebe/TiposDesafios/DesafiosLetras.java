package com.example.gabrielpaulino.appbebe.TiposDesafios;

import com.example.gabrielpaulino.appbebe.R;

/**
 * Created by GabrielPaulino on 23/11/2016.
 */

public class DesafiosLetras extends Desafios {
    public DesafiosLetras(String Name){
        super(Name);
    }
    @Override
    protected void IniciarItens() {
        ItensList.add(gerarItem(R.drawable.la1,"letra a"));
        ItensList.add(gerarItem(R.drawable.lb1,"letra b"));
        ItensList.add(gerarItem(R.drawable.lc1,"letra c"));
        ItensList.add(gerarItem(R.drawable.ld1,"letra d"));
        ItensList.add(gerarItem(R.drawable.le1,"letra e"));

    }
}
