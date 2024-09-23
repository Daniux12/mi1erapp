package com.example.mi1erapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.text.InputType;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    private EditText editnombre;
    private Button listo;
    private RadioGroup radioGroupGender;
    private EditText editedad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editnombre = findViewById(R.id.editnombre);
        listo = findViewById(R.id.listo);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        editedad = findViewById(R.id.editedad);
        editedad.setInputType(InputType.TYPE_CLASS_NUMBER);

        listo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editnombre.getText().toString();

                // Guardar el nombre en SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", name);
                editor.putString("gender", getSelectedGender());
                editor.apply();

                // Ir a MainActivity
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finaliza SignUp
            }
        });
    }

    private String getSelectedGender() {
        int selectedId = radioGroupGender.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);
        return selectedRadioButton != null ? selectedRadioButton.getText().toString() : "No seleccionado";
    }
}