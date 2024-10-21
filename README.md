Agenda de Trabalho
Integrantes Locais:
Matheus da Silva da Cruz
David J. A. Silva
Índice
Descrição do Projeto
Tecnologias Utilizadas
Funcionalidades Implementadas
Contatos
Descrição do Projeto
Este projeto é um sistema de gerenciamento de tarefas que oferece aos usuários a possibilidade de:

Tarefas de pesquisa
Criar novas tarefas
Editar tarefas existentes
Excluir tarefas
Visualizar tarefas
Objetivo:
Fornecer uma ferramenta simples e eficiente para organizar e acompanhar atividades diárias. O sistema inclui uma interface gráfica para o gerenciamento de usuários e clientes, com um banco de dados MySQL para armazenamento de informações.

Estrutura do Banco de Dados:
Usuários : id, nome, email, nome_usuario,senha
Clientes : id, nome, endereço, telefone, email,cpf_cnpj
Ordem do Dia : id, data, hora, descrição,cliente_id
Tecnologias Utilizadas
Linguagem de Programação : Java (com bibliotecas Swing e JavaFX para interface gráfica)
Banco de Dados : MySQL
Ferramenta de Gerenciamento de Banco de Dados : MySQL Workbench
Conexão com Banco de Dados : JDBC (Java Database Connectivity)
Funcionalidades Implementadas
Tela de Login

Campos : Nome de usuário e senha
Descrição : Permite a autenticação de usuários cadastrados. Caso as credenciais sejam incorretas, uma mensagem de erro será exibida.
Tela Principal

Descrição : Apresenta um menu com opções como:
Cadastro de Usuários
Cadastro de Clientes
Agenda
Tela de Cadastro de Usuários

Campos : Nome, e-mail, nome de usuário e senha
Descrição : Permitir pesquisar, adicionar, editar e excluir usuários. Inclui validações para evitar duplicação de dados.
Tela de Cadastro de Clientes

Campos : Nome, endereço, telefone, e-mail e CPF/CNPJ
Descrição : Ferramenta simples para gerenciar clientes.
Agenda para Registro de Compromissos

Campos : Dados, hora, descrição e cliente associado
Descrição : Interface para agendar compromissos, exibindo as informações em formato de tabela. Oferece opções de visualização por dia, semana ou mês.
Contatos
Matheus da Silva da Cruz : motogmatheus362 @ gmail.com
David JA Silva : (inserir e-mail aqui)
