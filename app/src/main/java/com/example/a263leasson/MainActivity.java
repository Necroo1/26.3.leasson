package com.example.a263leasson;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    }

    public void updateMessage (View view) {
        //Log.i("test-message","actualizando campo de texto");
        //R.id.welcome_message con esto se encuentra un elementro dentro de mis recursos
        TextView welcome_message = findViewById(R.id.welcome_message);
        welcome_message.setText(R.string.new_message);
       Toast messageToast = Toast.makeText(this,"Primer boton clickeado",Toast.LENGTH_SHORT);
       messageToast.show();
    }
    public void openActivity (View view) {
        Intent intent = new Intent(this,ListViwerActivity.class);
        startActivity(intent);
    }
}