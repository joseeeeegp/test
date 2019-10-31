package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int question;
    private TextView text_view;
    private String[] preguntas, respuestas;
    private Toast toast;
    Button next, previous,verdadero,falso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toast = Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT);
        next=(Button)findViewById(R.id.next);
        previous=(Button)findViewById(R.id.previous);
        verdadero=(Button)findViewById(R.id.truebutton);
        falso=(Button)findViewById(R.id.falsebutton);
        question=-1;
        preguntas=getResources().getStringArray(R.array.preguntas);
        respuestas=getResources().getStringArray(R.array.respuestas);
        text_view=(TextView)findViewById(R.id.textView);
        refresh();

        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                question++;
                refresh();
            }
        });

        previous.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                question--;
                refresh();
            }
        });

        verdadero.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(respuestas[question].equals("true")){
                    toast.setText("perfecto");

                }else{
                    toast.setText("error");
                }
                toast.show();
                refresh();
            }
        });
        falso.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(respuestas[question].equals("false")){
                    toast.setText("perfecto");
                }else{
                    toast.setText("error");
                }
                toast.show();
                refresh();
            }
        });

    }





    public void refresh(){

        if(question==preguntas.length){
            question=0;
        }else if(question<0) {
            question=preguntas.length-1;
        }
        text_view.setText(preguntas[question]);
    }

}
