package com.frajo91.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txt1, txt2;
    private String display="";
    private int point=0;
    private Button ce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1=(TextView) findViewById(R.id.txt1);
        txt2=(TextView) findViewById(R.id.txt2);
        ce=(Button) findViewById(R.id.bce);
        ce.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(display.length()==0){
                    display="";
                    txt2.setText(display);
                }else{
                    display="";
                    txt1.setText(display);
                    point=0;
                }
                return true;
            }
        });

    }
// coloca los numeros de cada boton en el textview
    public void number(View view){
        Button b =(Button) view;
        display=display + b.getText();
        txt1.setText(display);
    }
//configurar el punto decimal, que no se pueda usar mas e una vez en el mismo numero
    public void decimal(View view){
        Button b =(Button) view;
        if(point==0){
            display=display + b.getText();
            txt1.setText(display);
            point=1;
        }else{
            Toast.makeText(this,"No puede insertar dos separadores de decimal en un mismo numero",Toast.LENGTH_LONG).show();
        }
    }
//boton borrado, borrar numero por numero
    public void del(View view){
        if(display.length()!=0) {
            if(display.substring(display.length()-1,display.length()).equals(".")){
                point=0;
            }
            display = display.substring(0, display.length() - 1);
            txt1.setText(display);
        }
    }




}

