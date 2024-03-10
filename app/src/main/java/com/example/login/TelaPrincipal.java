package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.databinding.ActivityTelaPrincipalBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class TelaPrincipal extends AppCompatActivity {
    private ActivityTelaPrincipalBinding binding;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelaPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FirebaseAuth auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        String uidUser = getIntent().getStringExtra("UidUser");
        recuperarNomeDoUsuario(uidUser);

    }

    public void irTelaLogin(View view) {
        Toast.makeText(TelaPrincipal.this, "Logoff feito com Sucesso!", Toast.LENGTH_SHORT).show();
        Intent in = new Intent(this, TelaLogin.class);
        startActivity(in);
    }

    public void recuperarNomeDoUsuario(String uidUser){
        // Consultar o Firestore para obter o nome do usuário
        firestore.collection("users").document(uidUser)
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            String nome = documentSnapshot.getString("nome");
                            binding.txtNome.setText(nome);
                        } else {
                            binding.txtNome.setText("Nome do usuário não encontrado");
                        }
                    }
                });
    }
}
