package com.example.gabrielpaulino.appbebe.TiposDesafios;

import com.example.gabrielpaulino.appbebe.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by GabrielPaulino on 22/11/2016.
 */

public abstract class Desafios {
    List<Item> ItensList = ItensList = new ArrayList<>();
    protected List<Desafio> desafiosList = new ArrayList<>();
    protected String NameUser;
    protected Random random = new Random();
    final protected int maxImages =4;
    public String[] TiposDesafios = new String[]{"Animais","Comidas","Cores","Figuras","Frutas","Letras"
            ,"Numeros","Objetos","Veiculos"};
    public int[] ImagesDesafios = new int[]{R.drawable.gato1,R.drawable.c_feijao1,R.drawable.cores,R.drawable.f_cubo1,R.drawable.banana1,
            R.drawable.la1,R.drawable.n_dois1,R.drawable.liquidificador1,R.drawable.v_carro1
    };
    protected Desafios(){
    }
    protected Desafios(String Name){
        NameUser = Name;
        IniciarItens();
        IniciarLista();
    }
    protected abstract void IniciarItens();
    protected  void IniciarLista(){
        for(int i=0;i<50;i++){
            int itensQuantidade = random.nextInt(maxImages-1)+2;
            //int itensQuantidade = 4;
            int itemProcuradoId = random.nextInt(itensQuantidade);
            List<Integer> itensId = gerarSeguencia(itensQuantidade,ItensList.size());
            int[] itensImagens = new int[itensQuantidade];
            String[] itensText = new String[itensQuantidade];
            for(int j=0;j<itensQuantidade;j++){
                itensImagens[j]=ItensList.get(itensId.get(j)).getImage();
                itensText[j]=textItem(ItensList.get(itensId.get(j)).getName());
            }
            String itemProcuradoName = ItensList.get(itensId.get(itemProcuradoId)).getName();
            desafiosList.add(CriarDesafio(itensQuantidade,saudacao(itemProcuradoName),itensImagens,itensText,textHit(itemProcuradoName),itemProcuradoId,R.color.Branco));
        }
    }
    public Desafio CriarDesafio(int quantidadeDeImages,String textDesafio,int[] images,
                                String[] textImages,String textSucesso,int imageSucesso, int BackgroudTela){
        Desafio desafio = new Desafio(quantidadeDeImages);
        desafio.setTextDesafio(textDesafio);
        desafio.setImages(images);
        desafio.setTextImages(textImages);
        desafio.setTextSucesso(textSucesso);
        desafio.setImageSucesso(imageSucesso);
        desafio.setBackgroudTela(BackgroudTela);
        return desafio;
    }
    public Desafio get(int i){
        return desafiosList.get(i);
    }
    public int getSize(){
        return desafiosList.size();
    }
    protected List<Integer> gerarSeguencia(int quantidade, int maior){
        List<Integer> seguencia = new ArrayList<>();
        for(int i=0;i<quantidade;i++){
            int aux = random.nextInt(maior);
            while(seguencia.contains(aux)){
                aux++;
                if(aux>=maior){aux=0;}
            }
            seguencia.add(aux);
        }
        return seguencia;
    }
    protected String saudacao(String procurado){
        String[] saudacoes = new String[]{
                "Olá "+NameUser+", mostre onde está "+procurado,
                NameUser+", mostre onde está "+procurado
        };
        return saudacoes[random.nextInt(saudacoes.length)];
    }
    protected String textItem(String itemName){
        String[] textsItem = new String[]{
                "não "+NameUser+", este é "+itemName,
                NameUser+", isto é "+itemName
        };
        return textsItem[random.nextInt(textsItem.length)];
    }
    protected String textHit(String itemName){
        String[] textsHit = new String[]{
                "parabens "+NameUser+", este é "+itemName,
                 "muito bem "+NameUser+", isto é "+itemName
        };
        return textsHit[random.nextInt(textsHit.length)];
    }
    protected Item gerarItem(int image, String name){
        Item item = new Item();
        item.setImage(image);
        item.setName(name);
        return item;
    }


}
