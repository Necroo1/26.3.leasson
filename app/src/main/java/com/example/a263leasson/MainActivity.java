package com.example.a263leasson;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button new_button = findViewById(R.id.new_button);
        new_button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               TextView welcome_message = findViewById(R.id.welcome_message);
               welcome_message.setText("Otro Mensaje");
               Button mew_button = (Button) v;
               new_button.setText("Mensaje Actualizado");
           }
       });
    }

    public void updateMessage (View view) {
        //Log.i("test-message","actualizando campo de texto");
        //R.id.welcome_message con esto se encuentra un elementro dentro de mis recursos
        TextView welcome_message = findViewById(R.id.welcome_message);
        welcome_message.setText(R.string.new_message);
    }
}