package com.example.gabrielpaulino.appbebe.TiposDesafios;

import com.example.gabrielpaulino.appbebe.R;

/**
 * Created by GabrielPaulino on 23/11/2016.
 */

public class DesafiosFiguras extends Desafios {
    public DesafiosFiguras(String Name){
        super(Name);
    }
    @Override
    protected void IniciarItens() {
        ItensList.add(gerarItem(R.drawable.f_circulo1,"circulo"));
        ItensList.add(gerarItem(R.drawable.f_quadrado1,"quadrado"));
        ItensList.add(gerarItem(R.drawable.f_triangulo1,"triângulo"));
        ItensList.add(gerarItem(R.drawable.f_cubo1,"cubo"));
    }
}
