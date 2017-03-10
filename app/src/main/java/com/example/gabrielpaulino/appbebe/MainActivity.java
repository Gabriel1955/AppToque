package com.example.gabrielpaulino.appbebe;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gabrielpaulino.appbebe.TiposDesafios.Desafios;

/**
 * Created by GabrielPaulino on 23/11/2016.
 */

public class MainActivity extends AppCompatActivity {
    private ImageView[] imageView = new ImageView[9];
    private TextView[] textViews = new TextView[9];
    private EditText editText;
    private Desafios desafios;
    Database database = new Database(this);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        desafios = new Desafios() {
            @Override
            protected void IniciarItens() {
            }
        };
        editText = (EditText) findViewById(R.id.editText);
        if(database.getNameUser()!=null){
            editText.setText(database.getNameUser());
        }
        else {
            IniciarDatabase();
        }
        imageView[0] = (ImageView) findViewById(R.id.img1);imageView[1] = (ImageView) findViewById(R.id.img2);
        imageView[2] = (ImageView) findViewById(R.id.img3);imageView[3] = (ImageView) findViewById(R.id.img4);
        imageView[4] = (ImageView) findViewById(R.id.img5);imageView[5] = (ImageView) findViewById(R.id.img6);
        imageView[6] = (ImageView) findViewById(R.id.img7);imageView[7] = (ImageView) findViewById(R.id.img8);
        imageView[8] = (ImageView) findViewById(R.id.img9);
        textViews[0] = (TextView) findViewById(R.id.text1);textViews[1] = (TextView) findViewById(R.id.text2);
        textViews[2] = (TextView) findViewById(R.id.text3);textViews[3] = (TextView) findViewById(R.id.text4);
        textViews[4] = (TextView) findViewById(R.id.text5);textViews[5] = (TextView) findViewById(R.id.text6);
        textViews[6] = (TextView) findViewById(R.id.text7);textViews[7] = (TextView) findViewById(R.id.text8);
        textViews[8] = (TextView) findViewById(R.id.text9);


        for(int i=0;i<9;i++){
            imageView[i].setImageResource(desafios.ImagesDesafios[i]);
            textViews[i].setText(desafios.TiposDesafios[i]);

        }
    }
    public void OnClick(View view){
        database.setNameUser(editText.getText().toString());
        int i=0;
        while(view.getId()!=imageView[i].getId()){i++;}
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("name",editText.getText().toString());
        intent.putExtra("id",i);
        startActivity(intent);

    }
    private void IniciarDatabase(){
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name","");
        db.insert("user",null,contentValues);
    }
}
