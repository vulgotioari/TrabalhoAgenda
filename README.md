Agenda de Trabalho

Integrantes Locais:
Matheus da Silva da Cruz
David JA Silva
Índice
Descrição do Projeto
Tecnologias Utilizadas
Funcionalidades Implementadas
Contatos
Descrição do Projeto
Este projeto é um sistema de gerenciamento de tarefas que permite aos usuários:

Pesquisar,
Criar,
Editar,
Excluir,
Visualizar tarefas.
Objetivo:
O sistema visa oferecer uma ferramenta simples e eficiente para organizar e acompanhar atividades diárias. Ele inclui uma interface gráfica para o gerenciamento de usuários e clientes , e usa um banco de dados local com MySQL para armazenar as informações.

Estrutura do Banco de Dados:
Usuários : id, nome, email, nome_usuario, senha.
Clientes : id, nome, endereço, telefone, email, cpf_cnpj.
Ordem do dia : id, data, hora, descrição, cliente_id.
Tecnologias Utilizadas
Linguagem de Programação : Java (bibliotecas Swing e JavaFX para Interface Gráfica).
Banco de Dados : MySQL.
Ferramenta de Gerenciamento de Banco de Dados : MySQL Workbench.
Conexão com Banco de Dados : JDBC (Java Database Connectivity).
Funcionalidades Implementadas
1. Tela de Login
Campos : Nome de usuário e senha.
Descrição : Permite o login de usuários cadastrados. Exibe uma mensagem de erro se as credenciais forem incorretas.
2. Tela Principal
Descrição : Contém um menu com opções como:
Cadastro de Usuários
Cadastro de Clientes
Agenda
3. Tela de Cadastro de Usuários
Campos : Nome, e-mail, nome de usuário e senha.
Descrição : Permitir pesquisar, adicionar, editar e excluir usuários, com validações para evitar dados duplicados.
4. Tela de Cadastro de Clientes
Campos : Nome, endereço, telefone, e-mail e CPF/CNPJ.
Descrição : Permite gerenciar clientes de forma simples.
5. Agenda para Registro de Compromissos
Campos : Dados, hora, descrição e cliente associado.
Descrição : Interface para agendar compromissos, exibindo os dados em uma tabela, com opções de visualização por dia, semana ou mês.
Contatos
Matheus da Silva da Cruz : Motogmatheus362 @gmail .com
David JA Silva : (seu e-mail)
