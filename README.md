Agenda de Trabalho

Integrantes Locais:

Matheus da Silva da Cruz;
David J. A. Silva

Índice

Descrição do Projeto

Tecnologias Utilizadas

Funcionalidades Implementadas

Estrutura do Banco de Dados

Contatos

Descrição do Projeto

Este projeto é um sistema de gerenciamento de tarefas que oferece aos usuários a capacidade de:

Tarefas de pesquisa

Criar novas tarefas

Editar tarefas existentes

Excluir tarefas

Visualizar tarefas

Objetivo:

O sistema visa fornecer uma ferramenta simples e eficiente para organizar e acompanhar atividades diárias. Ele inclui uma interface gráfica para o gerenciamento de usuários e clientes , e utiliza um banco de dados MySQL para armazenamento de informações.

Tecnologias Utilizadas

Linguagem de Programação : Java

Bibliotecas : Swing e JavaFX (para interface gráfica)

Banco de Dados : MySQL

Ferramenta de Gerenciamento de Banco de Dados : MySQL Workbench

Conexão com Banco de Dados : JDBC (Java Database Connectivity)

Funcionalidades Implementadas

1. Tela de Login
2. 
Campos : Nome de usuário e senha

Descrição : Permite a autenticação de usuários cadastrados. Se as credenciais forem incorretas, uma mensagem de erro será exibida.
4. Tela Principal

Descrição : Apresenta um menu com as seguintes opções:

Cadastro de Usuários

Cadastro de Clientes

Agenda

5. Tela de Cadastro de Usuários
6. 
Campos : Nome, e-mail, nome de usuário e senha

Descrição : Permitir pesquisar, adicionar, editar e excluir usuários. Inclui validações para evitar duplicação de dados.

8. Tela de Cadastro de Clientes
9. 
Campos : Nome, endereço, telefone, e-mail e CPF/CNPJ

Descrição : Interface simples para gerenciar clientes, facilitando a criação e atualização de informações.

11. Agenda para Registro de Compromissos
12. 
Campos : Dados, hora, descrição e cliente associado

Descrição : Permite o agendamento de compromissos, com uma tabela que exibe as informações registradas. Oferece opções de visualização por dia, semana ou mês .

Estrutura do Banco de Dados

Tabelas:

Usuários :

id(INTEIRO)

nome(VARCHAR)

email(VARCHAR)

nome_usuario(VARCHAR)

senha(VARCHAR)

Clientes :

id(INTEIRO)

nome(VARCHAR)

endereço(VARCHAR)

telefone(VARCHAR)

email(VARCHAR)

cpf_cnpj(VARCHAR)

Ordem do Dia :

id(INTEIRO)

data(DATA)

hora(TEMPO)

descrição(TEXTO)

cliente_id(INT) – chave estrangeira referenciandoClientes

Contatos

Matheus da Silva da Cruz :motogmatheus362@gmail.com

David JA Silva : (inserir e-mail aqui)
