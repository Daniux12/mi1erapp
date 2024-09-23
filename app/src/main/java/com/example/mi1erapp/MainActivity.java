package com.example.mi1erapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.SharedPreferences;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        // Recuperar el nombre y género del usuario de SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "Usuario");
        String gender = sharedPreferences.getString("gender", "No seleccionado");

        // Mostrar el mensaje de bienvenida basado en el género
        String welcomeMessage = gender.equals("Femenino")
                ? "Bienvenida, " + username + "!"
                : "Bienvenido, " + username + "!";

        textView.setText(welcomeMessage);
    }
}






