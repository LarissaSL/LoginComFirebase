package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.example.login.Models.Modelo;
import com.example.login.databinding.ActivityTelaCadastroBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class telaCadastro extends AppCompatActivity {

    private ActivityTelaCadastroBinding binding;
    private FirebaseAuth auth;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelaCadastroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firestore = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        binding.botaoCriarConta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String nome = binding.nome.getText().toString().trim();
                String email = binding.email.getText().toString().trim();
                String senha = binding.senha.getText().toString().trim();

                String mensagemDeSucesso = "Hey, " + nome + ". Seja bem-vindo(a) a Plataforma!";
                String mensagemDeErro = "Poxa, " + nome + " alguma coisa deu errada, tente novamente.";

                // Validações e Cadastro
                if(validarCampos(nome, email, senha)) {
                    auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Modelo modelo = new Modelo(nome, email);
                                String id = task.getResult().getUser().getUid();
                                firestore.collection("users").document(id).set(modelo)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    // Cadastro bem-sucedido
                                                    Toast.makeText(telaCadastro.this, mensagemDeSucesso, Toast.LENGTH_SHORT).show();
                                                }

                                                //Redirecionar para tela Principal do APP depois de 3s
                                                new Handler(getMainLooper()).postDelayed(() -> {
                                                    finish();
                                                    startActivity(new Intent(telaCadastro.this, telaPrincipal.class));
                                                }, 3000);
                                            }
                                        });
                            } else {
                                // Erro ao cadastrar
                                // O e-mail já está em uso
                                Exception exception = task.getException();
                                if (exception instanceof FirebaseAuthUserCollisionException) {
                                    Toast.makeText(telaCadastro.this, "E-mail já está em Uso.", Toast.LENGTH_SHORT).show();
                                } else {
                                    // Erro genérico
                                    Toast.makeText(telaCadastro.this, mensagemDeErro, Toast.LENGTH_SHORT).show();
                                }

                            }
                        }
                    });
                }
            }
        });
    }

    private boolean validarCampos(String nome, String email, String senha) {
        //Expressão regular para verificar se e-mail é válido
        String regex = "^(.+)@(.+)$";

        // Verifica se o e-mail está vazio ou não corresponde ao padrão regex
        if(nome.isEmpty()) {
            binding.nome.setError("Digite seu nome");
            return false;
        } else if(email.isEmpty() || !email.matches(regex)){
            binding.email.setError("Digite um email válido");
            return false;
        } else if(senha.isEmpty() || senha.length() < 6) {
            binding.senha.setError("Por favor digite uma senha com pelo menos 6 caracteres");
            return false;
        }
        return true;
    }

}
