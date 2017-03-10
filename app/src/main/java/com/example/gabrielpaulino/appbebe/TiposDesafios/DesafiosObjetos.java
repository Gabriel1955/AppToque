package com.example.gabrielpaulino.appbebe.TiposDesafios;

import com.example.gabrielpaulino.appbebe.R;

/**
 * Created by GabrielPaulino on 23/11/2016.
 */

public class DesafiosObjetos  extends Desafios{
    public DesafiosObjetos(String Name){
        super(Name);
    }
    @Override
    protected void IniciarItens() {
        ItensList.add(gerarItem(R.drawable.cama1,"cama"));
        ItensList.add(gerarItem(R.drawable.mesa1,"mesa"));
        ItensList.add(gerarItem(R.drawable.liquidificador1,"liquidificador"));
        ItensList.add(gerarItem(R.drawable.tv1,"televisão"));
    }
}
