package com.example.parcial1ivanmendozaetsp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText edUser, edPass;
    Button btAlerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edUser = findViewById( R.id.edtUsuario );
        edPass = findViewById( R.id.edtPass );
        btAlerta = findViewById( R.id.btnAlerta );

    }

    public void login( View view){
        String usuario = edUser.getText().toString(),
                contra = edPass.getText().toString();

        if ( usuario.equals("parcialETps1") && contra.equals("p4rC14l#tp$") ){
            btAlerta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intento =new Intent( getApplicationContext(), Principal.class );
                    startActivity( intento );
                }
            });
        }else{

            btAlerta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast toastp = new Toast( getApplicationContext());
                    LayoutInflater inflater = getLayoutInflater();
                    View layout =inflater.inflate( R.layout.toast_layout, ( ViewGroup ) findViewById(R.id.lyMensaje) );

                    TextView txtMensaje = ( TextView ) layout.findViewById( R.id.txvAlerta );
                    toastp.setDuration( Toast.LENGTH_LONG );
                    toastp.setView( layout );
                    toastp.show();
                }
            });
        }
    }

    public void pantalla( View view ) {
        Intent intento = new Intent( this, Principal.class);
        startActivity( intento );

    }
}