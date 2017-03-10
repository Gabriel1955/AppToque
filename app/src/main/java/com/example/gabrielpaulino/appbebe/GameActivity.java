package com.example.gabrielpaulino.appbebe;

import android.app.Dialog;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.gabrielpaulino.appbebe.TiposDesafios.Desafio;
import com.example.gabrielpaulino.appbebe.TiposDesafios.Desafios;
import com.example.gabrielpaulino.appbebe.TiposDesafios.DesafiosAcoes;
import com.example.gabrielpaulino.appbebe.TiposDesafios.DesafiosAnimais;
import com.example.gabrielpaulino.appbebe.TiposDesafios.DesafiosComidas;
import com.example.gabrielpaulino.appbebe.TiposDesafios.DesafiosCores;
import com.example.gabrielpaulino.appbebe.TiposDesafios.DesafiosFiguras;
import com.example.gabrielpaulino.appbebe.TiposDesafios.DesafiosFrutas;
import com.example.gabrielpaulino.appbebe.TiposDesafios.DesafiosLetras;
import com.example.gabrielpaulino.appbebe.TiposDesafios.DesafiosNumeros;
import com.example.gabrielpaulino.appbebe.TiposDesafios.DesafiosObjetos;
import com.example.gabrielpaulino.appbebe.TiposDesafios.DesafiosVeiculos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class GameActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private TextToSpeech tts;
    private ImageView[] imageView;
    private Desafios desafios;
    private Desafio desafioAux;
    private int[] imagens = new int[]{R.id.image1,R.id.image2,R.id.image3,R.id.image4};
    private boolean Primeirafalar = true;
    private LinearLayout layoutBackgroud;
    private Bundle bundle;
    private int idDesafio = -1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getIntent().getExtras();
        tts = new TextToSpeech(this,this);
    }
    public void gerarDesafio(){
        idDesafio++;
        if(idDesafio>=desafios.getSize()){
            idDesafio = 0;
        }
        desafioAux = desafios.get(idDesafio);
        setContentView(desafioAux.getTela());

        layoutBackgroud = (LinearLayout) findViewById(R.id.LayoutBackgroud);
        layoutBackgroud.setBackgroundResource(desafioAux.getBackgroudTela());

        imageView = new ImageView[desafioAux.getQuantidadeImagens()];


        for(int i=0;i<desafioAux.getQuantidadeImagens();i++){
            imageView[i] = (ImageView) findViewById(imagens[i]);
            imageView[i].setImageResource(desafioAux.getImages()[i]);
        }
        speakOut(desafioAux.getTextDesafio());
    }
    public void repetirMensagem(View view){
        if(!tts.isSpeaking()) {
            speakOut(desafioAux.getTextDesafio());
        }
    }
    public void click(View view){
        if(tts.isSpeaking()){return;}
        int i=0;
        while(view.getId()!=imageView[i].getId()){i++;}
        if(desafioAux.getImageSucesso()==i) {
            speakOut(desafioAux.getTextSucesso());
            while (tts.isSpeaking()){} //colocar animação de um desafio para o outro
            gerarDesafio();
        }
        else {
           speakOut(desafioAux.getTextImages()[i]);
        }
    }
    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
    @Override
    public void onInit(int status){
        if (status == TextToSpeech.SUCCESS) {

           int result = tts.setLanguage(new Locale(Locale.getDefault().getLanguage()));

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                Log.e("TTS","OK");
                SelecionarTipo(bundle.getInt("id"));
            }
        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }
    private void speakOut(String text) {
        if(!tts.isSpeaking() || Primeirafalar){
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            Primeirafalar = false;
        }
    }
    public void MenuList(View view){
        final List<Map<String,Object>> ListTiposDesafios= new ArrayList<>();
        for(int i=0;i<desafios.TiposDesafios.length;i++){
            Map<String, Object> mapAux = new HashMap<String, Object>();
            mapAux.put("name",desafios.TiposDesafios[i]);
            mapAux.put("image",desafios.ImagesDesafios[i]);
            ListTiposDesafios.add(mapAux);
        }
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.menu_desafios);
        ListView listView = (ListView) dialog.findViewById(R.id.menuList);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, ListTiposDesafios,R.layout.item_list,
                new String[]{"image","name"}, new int[]{R.id.item_list_image,R.id.item_list_text});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SelecionarTipo(position);
                dialog.cancel();
            }
        });
        dialog.show();
    }
    private void SelecionarTipo(int position) {
        switch (position){
            case 0:
                desafios = new DesafiosAnimais(bundle.getString("name"));

                break;
            case 1:
                desafios = new DesafiosComidas(bundle.getString("name"));
                break;
            case 2:
                desafios = new DesafiosCores(bundle.getString("name"));
                break;
            case 3:
                desafios = new DesafiosFiguras(bundle.getString("name"));
                break;
            case 4:
                desafios = new DesafiosFrutas(bundle.getString("name"));
                break;
            case 5:
                desafios = new DesafiosLetras(bundle.getString("name"));
                break;
            case 6:
                desafios = new DesafiosNumeros(bundle.getString("name"));
                break;
            case 7:
                desafios = new DesafiosObjetos(bundle.getString("name"));
                break;
            case 8:
                desafios = new DesafiosVeiculos(bundle.getString("name"));
                break;
            default:
                break;
        }
        gerarDesafio();
    }
}