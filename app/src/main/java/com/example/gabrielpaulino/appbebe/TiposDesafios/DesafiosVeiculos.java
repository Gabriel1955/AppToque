package com.example.gabrielpaulino.appbebe.TiposDesafios;

import com.example.gabrielpaulino.appbebe.R;

/**
 * Created by GabrielPaulino on 23/11/2016.
 */

public class DesafiosVeiculos extends Desafios{
    public DesafiosVeiculos(String Name){
        super(Name);
    }
    @Override
    protected void IniciarItens() {
        ItensList.add(gerarItem(R.drawable.v_bicicleta1,"bicicleta"));
        ItensList.add(gerarItem(R.drawable.v_carro1,"carro"));
        ItensList.add(gerarItem(R.drawable.v_moto1,"moto"));
        ItensList.add(gerarItem(R.drawable.v_onibus1,"ônibus"));
    }
}
