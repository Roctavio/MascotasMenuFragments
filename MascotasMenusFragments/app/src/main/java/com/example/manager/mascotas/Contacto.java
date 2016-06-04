package com.example.manager.mascotas;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.manager.mascotas.mail.GMailSender;

public class Contacto extends AppCompatActivity
{
    Button btnEnviarEmail;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        btnEnviarEmail = (Button) findViewById(R.id.btnEnviarEmail);

        btnEnviarEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    GMailSender sender = new GMailSender("duranisrael@gmail.com", "M3rE6aCG");
                    sender.sendMail("Subject", "Body", "duranisrael@gmail.com", "duranisrael@gmail.com");
                    //Toast.makeText(context, "Email enviado", Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    Log.e("SendMail", e.getMessage(), e);
                }
            }
        });
    }
}
