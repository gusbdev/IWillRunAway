package com.projects.gus;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class Menu extends Activity {
    private Button btnJogar,btnInstr;
    private TextView txvTitle;
    AlertDialog alert;

    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.menu_principal);
        btnJogar = findViewById(R.id.btnJogar);
        btnInstr = findViewById(R.id.btnInstructions);
        txvTitle = findViewById(R.id.txvTitle);

        txvTitle.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.flash_leave_now));

        btnJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AndroidLauncher.class);
                startActivity(intent);
            }
        });

        btnInstr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               instructions();
            }
        });
    }

    private void instructions(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Instruções");
        builder.setMessage("O jogo consiste em ajudar Bidu a fugir de seu terrível dono. " +
                "Para que isso aconteça, você deve pressionar a tela várias vezes para que " +
                "Bidu não caia pelo espaço, fazendo-o passar pelos obstáculos. " +
                "Cuidado com os asteroides!");
        builder.setNeutralButton("Entendi!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alert.dismiss();
            }
        });
        alert = builder.create();
        alert.show();
    }
}
