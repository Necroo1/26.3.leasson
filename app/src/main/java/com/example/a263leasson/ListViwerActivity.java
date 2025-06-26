package com.example.a263leasson;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ListViwerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_viwer);

        Intent intent = getIntent();
        String messageText = intent.getStringExtra("messageText");

        Button new_button = new Button(this);
        new_button.setText(R.string.new_message);
        new_button.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        new_button.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout header_layout = (LinearLayout) findViewById(+R.id.header_layout);
        header_layout.addView(new_button);

        TextView welcome_message = new TextView(getApplicationContext());
        LinearLayout card = findViewById(R.id.viewer);
        welcome_message.setText(messageText);
        card.addView(welcome_message);

        new_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView welcome_message = new TextView(getApplicationContext());
                LinearLayout card = findViewById(R.id.viewer);
                welcome_message.setText("Otro mensaje");
                card.addView(welcome_message);
//                TextView welcome_message = findViewById(R.id.welcome_message);
                Button new_button = (Button) v;
                new_button.setText("Mensaje Actualizado");
                Toast messageToast = Toast.makeText(getApplicationContext(), "Segundo botón clickeado", Toast.LENGTH_LONG);
                messageToast.show();
            }
        });

    }
}
