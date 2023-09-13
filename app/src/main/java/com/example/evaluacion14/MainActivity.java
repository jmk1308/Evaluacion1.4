package com.example.evaluacion14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Button btn1,btn2,btn4;
    private RadioButton rdb1,rdb2;
    private CheckBox cb1,cb2;
    private ProgressBar pb1;
    int contador;
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private RatingBar rb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //llamado de variables
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn4 = (Button) findViewById(R.id.btn4);
        rdb1 = (RadioButton) findViewById(R.id.rdb1);
        rdb2 = (RadioButton) findViewById(R.id.rdb2);
        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        pb1 = (ProgressBar) findViewById(R.id.pb1);
        rb1 = (RatingBar) findViewById(R.id.rb1);
        //llamado de metodos
        comprobarRdb1();
        comprobarRdb2();
        progr();

        //llamado de recycler view
        recyclerView = (RecyclerView) findViewById(R.id.reclyclerView);
        itemAdapter = new ItemAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        itemAdapter.setData(getData());
        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        //boton de regreso
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

    }

    private List<Item> getData() {
        List<Item> List = new ArrayList<>();
        List.add(new Item(R.drawable.iconoinstagram, "Instagram"));
        List.add(new Item(R.drawable.iconotwitter, "Twitter"));
        List.add(new Item(R.drawable.iconotwitch, "Twitch"));
        return List;
    }

    public void progr(){
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Timer t = new Timer();
                TimerTask tt = new TimerTask() {
                    @Override
                    public void run() {
                        contador++;
                        pb1.setProgress(contador);
                        if (contador == 100){
                            t.cancel();
                        }
                    };
                };
                t.schedule(tt,0,100);
            }
        });
    }
    public void comprobarRdb1(){
        rdb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tipo = rdb1.getText().toString();
                Toast.makeText(MainActivity.this, "El radio seleccionado fue: " + tipo, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void comprobarRdb2(){
        rdb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tipo = rdb2.getText().toString();
                Toast.makeText(MainActivity.this, "El radio seleccionado fue: " + tipo, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void comprobarCbox(View v) {
        String comprobarCB1 = "";
        String comprobarCB2 = "";
        String etiqueta = "";

        if (cb1.isChecked() == true)
            comprobarCB1 = cb1.getText().toString();
        if (cb2.isChecked() == true)
            comprobarCB2 = cb2.getText().toString();
        if (comprobarCB1 == "" && comprobarCB2 == "")
            Toast.makeText(MainActivity.this, "No has seleccionado ninguna opción!", Toast.LENGTH_SHORT).show();
        else {
            etiqueta = (comprobarCB1 + " " + comprobarCB2 + " ");
            Toast.makeText(MainActivity.this, "Las opciones seleccionadas son: " + etiqueta, Toast.LENGTH_SHORT).show();
        }
    }

    public void cuantasEstrellas(View v){
        Toast.makeText(MainActivity.this, "Usted ha otorgado: " + rb1.getRating() + " estrellas!", Toast.LENGTH_SHORT).show();
    }




}