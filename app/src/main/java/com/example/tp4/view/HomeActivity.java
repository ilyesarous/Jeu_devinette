package com.example.tp4.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp4.R;
import com.example.tp4.controler.Controler;

public class HomeActivity extends AppCompatActivity {

    EditText txtPlayer1;
    EditText txtPlayer2;
    Button btnJouer;
    Controler controler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_home);
        init();
        joueur();
        controler = Controler.getInstance();
    }

    private void init()
    {
        txtPlayer1=findViewById(R.id.txtNomPlayer1);
        txtPlayer2=findViewById(R.id.txtNomPlayer2);
        btnJouer=findViewById(R.id.btnJouer);
       // txtPlayer1.setText("");
        // txtPlayer2.setText("");
    }
    private void joueur(){
        btnJouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtPlayer1.getText().toString().equals("") || txtPlayer2.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(),"Veuillez vérifier les nom des joueurs", Toast.LENGTH_SHORT).show();
                else
                {
                    activateSvante(txtPlayer1.getText().toString(), txtPlayer2.getText().toString());
                }
            }
        });
    }
    private void activateSvante(String namePlayer1, String namePlayer2)
    {
        try {
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            intent.putExtra("player1",namePlayer1);
            intent.putExtra("player2",namePlayer2);
            startActivity(intent);
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
    }
}
