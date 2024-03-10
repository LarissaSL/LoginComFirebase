# SeaSide - Aplicativo de Autenticação 🌊

SeaSide é um aplicativo Android que oferece funcionalidades de autenticação, incluindo login, recuperação de senha e cadastro de usuários. Ele foi desenvolvido para fornecer uma experiência de autenticação simples e intuitiva para os usuários.

## Funcionalidades 🛠️

| Funcionalidade          | Descrição                                                                                       |
|-------------------------|-------------------------------------------------------------------------------------------------|
| Login de Usuário        | Os usuários podem fazer login em suas contas existentes utilizando seu endereço de e-mail e senha. |
| Recuperação de Senha    | Os usuários têm a opção de redefinir sua senha caso a tenham esquecido.                          |
| Cadastro de Usuário     | Novos usuários podem criar uma conta fornecendo um endereço de e-mail e senha válidos.            |
| Boas Vindas             | Após o login bem-sucedido, os usuários são recebidos com uma tela de boas-vindas.                 |


## Tecnologias Utilizadas 🚀

- **Firebase Authentication**: Para autenticação de usuários e gerenciamento de contas.
- **Firebase Firestore**: Para armazenar dados de usuário, como nome e endereço de e-mail.
- **Android SDK**: Para o desenvolvimento da interface do usuário e lógica do aplicativo.

## Como Usar 📋

1. Faça o download do código-fonte do projeto.
2. Importe o projeto para o Android Studio.
3. Certifique-se de configurar o Firebase no projeto.
4. Compile e execute o aplicativo em um dispositivo ou emulador Android.

## Telas 📱
### Tela de Carregamento
<p>Uma tela inicial exibida enquanto o aplicativo carrega, apresentando o logotipo do SeaSide ( Empresa Fake ).</p>
<img src="https://github.com/LarissaSL/LoginComFirebase/assets/112571317/1a7c1a06-0c92-4425-9cd9-5fdc23a2aa4a" width="300">

### Tela de Login
<p>Permite que os usuários façam login em suas contas existentes.</p>
<img src="https://github.com/LarissaSL/LoginComFirebase/assets/112571317/53da6d4a-f5fe-41c0-a4c5-1799d9081514" width="300">

### Tela de Cadastro
<p>Permite que novos usuários se cadastrem no aplicativo.</p>
<img src="https://github.com/LarissaSL/LoginComFirebase/assets/112571317/78e43520-b35b-442a-816b-14e2067d5ac8" width="300">

### Tela de Recuperação de Senha
<p>Fornece uma maneira fácil para os usuários recuperarem suas senhas caso a tenham esquecido.</p>
<img src="https://github.com/LarissaSL/LoginComFirebase/assets/112571317/07380915-cd85-4c1a-86af-4edb8787d6ef" width="300">

### Tela de Boas Vindas
<p>Uma tela de boas-vindas exibida após o login bem-sucedido.</p>
<img src="https://github.com/LarissaSL/LoginComFirebase/assets/112571317/7129f699-250c-4b34-9739-e5e4b901234b" width="300">

## Desenvolvimento

| Desenvolvimento                           | Descrição                                                                                                                                                                            |
|-------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Separação dos Icones e Imagens para a Pasta Drawable | Organização dos recursos visuais, como ícones e imagens, em diretórios específicos dentro da pasta `res` do projeto Android.                                                  |
| Criação dos Layouts                      | Desenvolvimento dos layouts de interface do usuário (XML) para as diferentes telas da aplicação, como tela de login, cadastro, recuperação de senha e boas-vindas.                 |
| Vinculação do Projeto com o Firebase e o Firestore | Configuração do projeto Android para utilizar os serviços do Firebase, como autenticação e armazenamento de dados no Firestore, incluindo a adição das dependências necessárias. |
| Lógica da Tela de Cadastro               | Implementação da lógica para validação de campos vazios, verificação de emails válidos usando expressões regulares, requisitos de senha e inserção de dados no Firestore.        |
| Lógica da Tela de Login                  | Desenvolvimento da lógica para autenticação de usuários utilizando Firebase Auth, seguindo uma estrutura similar à tela de cadastro.                                              |
| Lógica para Tela de Boas-vindas          | Implementação da lógica para exibir o nome do usuário na tela de boas-vindas, obtendo-o do Firestore com base no UID do usuário.                                                    |
| Lógica para Recuperação de Senha         | Utilização dos recursos fornecidos pelo Firebase para permitir que os usuários redefinam suas senhas, enviando um link de redefinição para o endereço de e-mail fornecido.          |

## 🎥 Materiais de Apoio Usados

Aqui estão alguns vídeos que utilizei como apoio durante o desenvolvimento:

- [![YouTube Video 1](https://img.shields.io/badge/Assistir-Video%201-red)](https://youtu.be/8gp5zWOZT0c) **Login & Signup & forget password using firebase authentication - Android studio Java Tutorial**

- [![YouTube Video 2](https://img.shields.io/badge/Assistir-Video%202-red)](https://youtu.be/UiFl3hCQu_I) **Criando App Autenticação com Firebase (JAVA) - #1**

- [![YouTube Video 3](https://img.shields.io/badge/Assistir-Video%203-red)](https://www.youtube.com/watch?v=v0y5VYhvc7s) **Criando App Autenticação com Firebase (JAVA) - #2**

- [Documentação Oficial do Android - View Binding](https://developer.android.com/topic/libraries/view-binding?hl=pt-br)


## Simulação 🎬

Aqui está uma simulação do aplicativo em funcionamento:

![login](https://github.com/LarissaSL/LoginComFirebase/assets/112571317/b7eab613-4c1f-4af6-9af2-99677a44c163)


## Licença ⚖️

Imagens de Unsplash e Freepik


Design por LarissaSL
