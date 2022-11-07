package com.example.tp4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tp4.R;
import com.example.tp4.controler.Controler;


public class MainActivity extends AppCompatActivity {

    private EditText txtNbre;
    private TextView txtResultat;
    private TextView txtTurnPlayer1, txtTurnPlayer2;
    private Button btnComparer;
    private Button btnRetour;
    Controler controler = Controler.getInstance();
    private String namePlayer1;
    private String namePlayer2;
    private int valeurAchercher;
    private int playerTurn = 1;
    private String resultat ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getPlayersNames();
        txtTurnPlayer2.setText(namePlayer2);
        txtTurnPlayer1.setText(namePlayer1);
        ecouteComparer();
        ecouteRetour();
    }

    private void getPlayersNames() {
        Intent intent = getIntent();
        namePlayer1 = intent.getStringExtra("player1");
        namePlayer2 = intent.getStringExtra("player2");
    }
    private void init()
    {
        txtNbre =findViewById(R.id.txtNombre);
        txtResultat=findViewById(R.id.txtResultat);
        btnComparer=findViewById(R.id.btnComparer);
        btnRetour=findViewById(R.id.btnRetour);
        txtTurnPlayer1=findViewById(R.id.txtTurnPlayer1);
        txtTurnPlayer2=findViewById(R.id.txtTurnPlayer2);


        txtTurnPlayer1.setBackgroundResource(R.drawable.player_turn_border_form);

        txtNbre.setText("");
        txtResultat.setText("");
        valeurAchercher= (int) (Math.random()*100) +1;
        txtNbre.setHint(""+valeurAchercher);
        System.out.print(namePlayer1);
        System.out.print(namePlayer2);
    }
    private void ecouteComparer(){
        btnComparer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int valeurSaisie=0;
                try {
                    valeurSaisie = Integer.parseInt(txtNbre.getText().toString());
                }catch (Exception e){
                    System.out.print(e.getMessage());
                }
                if (valeurSaisie == 0) {
                    Toast.makeText(getApplicationContext(),"Pas de valeur saisie", Toast.LENGTH_SHORT).show();
                }
                else {
                    changePlayerTurn();
                    afficheResultat(valeurSaisie);
                    txtNbre.setText("");
                    txtNbre.setHint(""+valeurSaisie);
                    //winner(playerTurn, resultat);
                }

            }
        });
    }
    private void changePlayerTurn()
    {
        if(playerTurn == 1) {

            txtTurnPlayer1.setBackgroundResource(R.drawable.player_turn_form);

            txtTurnPlayer2.setBackgroundResource(R.drawable.player_turn_border_form);
            playerTurn = 2;
        }
        else {

            txtTurnPlayer1.setBackgroundResource(R.drawable.player_turn_border_form);

            txtTurnPlayer2.setBackgroundResource(R.drawable.player_turn_form);
            playerTurn = 1;
        }
    }
    private void afficheResultat(int valeurSaisie)
    {
        this.controler.createProfil(valeurSaisie, valeurAchercher);
        if(playerTurn ==1) {
            txtResultat.setText(namePlayer1 + ", " + this.controler.getResponse());
        }
        else
            txtResultat.setText(namePlayer2 +", "+this.controler.getResponse());
        winner(playerTurn, this.controler.getResponse());
    }
    //** * Retour * */
    private void ecouteRetour()
    {
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void winner(int playerTurn, String resultat){
        Intent intent = new Intent(MainActivity.this, Winner.class);

        if (resultat == "Bravo! Vous avez trouvé la valeur"){
            if (playerTurn == 1){
                intent.putExtra("player", namePlayer2);
                startActivity(intent);
            }else{
                intent.putExtra("player", namePlayer1);
                startActivity(intent);
            }
        }
    }

}