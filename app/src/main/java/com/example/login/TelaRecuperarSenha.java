package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.login.databinding.ActivityTelaLoginBinding;
import com.example.login.databinding.ActivityTelaRecuperarSenhaBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class TelaRecuperarSenha extends AppCompatActivity {

    private ActivityTelaRecuperarSenhaBinding binding;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelaRecuperarSenhaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();

        binding.botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.email.getText().toString().trim();

                // Validações e Login
                if (validarCampos(email)) {
                    recuperarContaFireBase(email);
                }
            }
        });
    }

    public void irTelaLogin(View view) {
        Intent in = new Intent(this, TelaLogin.class);
        startActivity(in);
    }

    private boolean validarCampos(String email) {
        // Verifica  o e-mail
        if (email.isEmpty()) {
            binding.email.setError("Digite um email");
            return false;
        }
        return true;
    }

    private void recuperarContaFireBase(String email) {
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    // Recuperação feita com Sucesso
                    Toast.makeText(TelaRecuperarSenha.this, "E-mail de recuperação enviado com Sucesso!", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(TelaRecuperarSenha.this, TelaLogin.class));
                } else {
                    // Erros ao fazer login
                    Exception exception = task.getException();
                    if (exception instanceof FirebaseAuthInvalidUserException) {
                        // Email não cadastrado
                        Toast.makeText(TelaRecuperarSenha.this, "E-mail não cadastrado", Toast.LENGTH_SHORT).show();
                    } else {
                        // Erro genérico
                        Toast.makeText(TelaRecuperarSenha.this, "Erro ao fazer login.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}