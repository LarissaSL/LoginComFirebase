package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.login.databinding.ActivityTelaLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class TelaLogin extends AppCompatActivity {
    private ActivityTelaLoginBinding binding;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelaLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();

        binding.botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.email.getText().toString().trim();
                String senha = binding.senha.getText().toString().trim();

                // Validações e Login
                if (validarCampos(email, senha)) {
                    entrarComEmailESenha(email, senha);
                }
            }
        });
    }

    public void irTelaCadastro(View view) {
        Intent in = new Intent(this, TelaCadastro.class);
        startActivity(in);
    }

    private boolean validarCampos(String email, String senha) {
        // Verifica se o e-mail e a senha estão vazios
        if (email.isEmpty()) {
            binding.email.setError("Digite um email");
            return false;
        } else if (senha.isEmpty()) {
            binding.senha.setError("Digite uma senha");
            return false;
        }
        return true;
    }

    private void entrarComEmailESenha(String email, String senha) {
        auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    //Login feito com Sucesso
                    finish();
                    startActivity(new Intent(TelaLogin.this, TelaPrincipal.class).putExtra("UidUser", auth.getCurrentUser().getUid()));
                } else {
                    // Erros ao fazer login
                    Exception exception = task.getException();
                    if (exception instanceof FirebaseAuthInvalidUserException) {
                        // Email não cadastrado
                        Toast.makeText(TelaLogin.this, "E-mail não cadastrado", Toast.LENGTH_SHORT).show();
                    } else if (exception instanceof FirebaseAuthInvalidCredentialsException) {
                        // Senha incorreta
                        Toast.makeText(TelaLogin.this, "Senha incorreta.", Toast.LENGTH_SHORT).show();
                    } else {
                        // Erro genérico
                        Toast.makeText(TelaLogin.this, "Erro ao fazer login.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void irTelaRecuperarSenha(View view){
        Intent in = new Intent(this, TelaRecuperarSenha.class);
        startActivity(in);
    }
}
