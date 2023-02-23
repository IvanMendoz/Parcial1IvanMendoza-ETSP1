package com.example.parcial1ivanmendozaetsp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Principal extends AppCompatActivity {

    EditText edPeso, edEstatura;
    TextView mostrarMensaje, tvIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        edPeso = findViewById( R.id.edtPeso );
        edEstatura = findViewById( R.id.edtEstatura );
        mostrarMensaje = findViewById( R.id.txvResultado );
        tvIMC = findViewById( R.id.txvValorIMC );
    }

    public void Calcular( View view ){
        double peso = Double.parseDouble( edPeso.getText().toString() );
        double estatura = Double.parseDouble( edEstatura.getText().toString() );
        double IMC = 0.00;
        String alerta = "";

        IMC = peso / ( estatura * estatura );
        //<>
        if ( IMC < 10.5 ){
            alerta = "Criticamente bajo de peso";
        } else if ( IMC < 15.9 ) {
            alerta = "Severamente bajo de peso";
        } else if ( IMC < 18.5 ) {
            alerta = "Bajo de peso";
        } else if ( IMC < 25 ) {
            alerta = "Normal (peso saludable)";
        } else if ( IMC < 30 ) {
            alerta = "Sobrepeso";
        } else if ( IMC < 35 ) {
            alerta = "Obesidad Clase 1 - Moderadamente obeso";
        } else if ( IMC < 40 ) {
            alerta = "Obesidad Clase 2 - Severamente obeso";
        } else if ( IMC > 50 ) {
            alerta = "Obesidad Clase 3 - Criticamente Obeso";
        }


        mostrarMensaje.setText("");
        tvIMC.setText("");
        tvIMC.setText( String.valueOf( obtieneDosDecimales( IMC ) ) );
        mostrarMensaje.setText( alerta );
    }

    private String obtieneDosDecimales(double valor){
        DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(2); //Define 2 decimales.
        return format.format(valor);
    }
}