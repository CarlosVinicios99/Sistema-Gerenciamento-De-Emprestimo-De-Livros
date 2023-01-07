# Sistema Para Gerenciamento De Empréstimos De Livros

## Visão Geral
<p> 
  Neste projeto foi desenvolvido um sistema desktop para o gerenciamento de empréstimos de livros tendo como base uma biblioteca universitária física. Este projeto foi desenvolvido para um TCC e pode passar por algumas mudanças em breve.
</p>
<br>

## Objetivos
<p>
  Os principais objetivos do sistema são: 
</p>

<ul>
  <li> Permitir que usuários possam disponibilizar livros para empréstimo ao acervo da biblioteca.
  <li>Implementar as demais funções de uma biblioteca, por ex; cadastro de usuários, cadastro de livros...
  <li> Criar uma interface gráfica clara e de fácil utilização.
</ul>
<br>

## Ferramentas e Tecnologias

<p>
  O sistema foi desenvolvido em 3 etapas, desenvolvimento do modelo do domínio, desenvolvimento do banco de dados e integração com o sistema e desenvolvimento da interface gráfica.
</p>

<p>
  Na etapa de desenvolvimento do modelo foram utilizadas técnicas e abordagens de engenharia de software e da UML para a análise e extração dos requisitos.  
</p>

<p>
  Na etapa de banco de dados foi utilizado o SGBD MySQL para o armazenamento dos dados, o MySQL Workbench foi utilizado para a modelagem, extração do diagrama E/R e interface com o banco. Por fim a biblioteca JDBC foi utilizada para realizar a integração do sistema com o banco. 
</p>

<p> 
  Na etapa do desenvolvimento da interface gráfica foi utilizada a biblioteca JavaFX e também CSS para os estilos.
</p>
<br>

## Tela De Login
<p>
  Os bibliotecários são cadastrados manualmente no banco por um administrador que disponibiliza uma senha. O login é realizado com a entrada do CPF e da senha.
</p>

<p>
  <img src = "https://github.com/CarlosVinicios99/Sistema-Gerenciamento-De-Emprestimo-De-Livros/blob/main/imagens/telaDeLogin.jpg?raw=true" alt = "Tela De Login">
</p>
<hr>
<br>

## Menu Principal
<p>
  O menu principal possui 4 opções representadas cada uma por um botão, cada opção com exceção da opção “Sair” direciona o bibliotecário para um menu secundário.
</p>

<p>
  <img src = "https://github.com/CarlosVinicios99/Sistema-Gerenciamento-De-Emprestimo-De-Livros/blob/main/imagens/TelaMenuPrincipal.jpg?raw=true" alt = "Menu Principal">
</p>
<hr>
<br>

## Menu Usuários
<p>
   O menu Usuários possui 3 opções, "Cadastrar" e "Remover" redirecionam para telas onde dados serão preenchidos de acordo com a opção escolhida, ao fim do preenchimento a operação indica é realizada.
</p>
<p>
   <img src = "https://github.com/CarlosVinicios99/Sistema-Gerenciamento-De-Emprestimo-De-Livros/blob/main/imagens/telaMenuUsuario.jpg?raw=true" alt = "Menu Usuários">
</p>
<hr>

### Cadastrar Usuário
<p>
   <img src = "https://github.com/CarlosVinicios99/Sistema-Gerenciamento-De-Emprestimo-De-Livros/blob/main/imagens/telaCadastroUsuario.jpg?raw=true" alt = "Cadastro De Usuário">
</p>
<hr>

### Remover Usuário
<p>
   <img src = "https://github.com/CarlosVinicios99/Sistema-Gerenciamento-De-Emprestimo-De-Livros/blob/main/imagens/telaRemoverUsuario.jpg?raw=true" alt = "Remover Usuário">
</p>
<hr>
<br>


## Menu Livros
<p>
  O menu Livros possui 3 opções, "Cadastrar" e "Remover" redirecionam para telas onde dados serão preenchidos de acordo com a opção escolhida, ao fim do preenchimento a operação indica é realizada.
</p>
<p>
   <img src = "https://github.com/CarlosVinicios99/Sistema-Gerenciamento-De-Emprestimo-De-Livros/blob/main/imagens/telaMenuLivro.jpg?raw=true" alt = "Menu Livros">
</p>
<hr>

### Cadastrar Livros
<p>
   <img src = "https://github.com/CarlosVinicios99/Sistema-Gerenciamento-De-Emprestimo-De-Livros/blob/main/imagens/telaCadastroLivro.jpg?raw=true" alt = "Cadastro De Livros">
</p>
<hr>

### Remover Livros
<p>
   <img src = "https://github.com/CarlosVinicios99/Sistema-Gerenciamento-De-Emprestimo-De-Livros/blob/main/imagens/TelaRemoverLivro.jpg?raw=true" alt = "Remover Livros">
</p>
<hr>
<br>

## Menu Empréstimos
<p>
   O menu Empréstimos possui 3 opções, "Realizar Empréstimo" e "Realizar Devolução" redirecionam para telas onde dados serão preenchidos de acordo com a opção escolhida, ao fim do preenchimento a operação indica é realizada.
</p>
<p>
   <img src = "https://github.com/CarlosVinicios99/Sistema-Gerenciamento-De-Emprestimo-De-Livros/blob/main/imagens/telaMenuEmprestimo.jpg?raw=true" alt = "Menu Empréstimos">
</p>
<hr>

### Realizar Empréstimo
<p>
  A opção "Realizar Empréstimo" direciona o bibliotecário para uma tela onde deve ser inserido o título do livro a ser emprestado.
</p>
<p>
   <img src = "https://github.com/CarlosVinicios99/Sistema-Gerenciamento-De-Emprestimo-De-Livros/blob/main/imagens/telaLivroParaEmprestimo.jpg?raw=true" alt = "Realizar Empréstimo">
</p>
<hr>

### Confirmar Livro
<p>
  Após a indicação do livro aparece uma tela de confirmação com os dados do livro. 
</p>
<p>
   <img src = "https://github.com/CarlosVinicios99/Sistema-Gerenciamento-De-Emprestimo-De-Livros/blob/main/imagens/telaConfirmarLivroEmprestimo.jpg?raw=true" alt = "Realizar Confirmar Livro">
</p>
<hr>

## Confirmar Usuário
