package com.example.a263leasson;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.FrameStats;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = this.mAuth.getCurrentUser();
        if(user != null){
            String email = user.getEmail();
            Log.i("firbase-auth", "Usuario logueado con el email: " + email);

            Intent intent = new Intent(this,ListViwerActivity.class);
            intent.putExtra("messagetText","Probando Login");
            startActivity(intent);
        }
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
        EditText message = findViewById(R.id.message);
        String messageText = String.valueOf(message.getText());

        this.mAuth.signInWithEmailAndPassword(
                "michael.saracho@davinci.edu.ar",
                messageText
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.i("Firbase-auth","Logueo Correcto");
                    Intent intent = new Intent (getApplicationContext(),ListViwerActivity.class);
                    intent.putExtra("messaggeText",messageText);
                    startActivityForResult(intent,RESULT_OK);
                }else {
                    Log.i("Firbase-auth","Logueo incorrecto");
                }
            }
        });

    }
}