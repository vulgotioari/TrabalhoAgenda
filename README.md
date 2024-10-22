Agenda de Trabalho
Integrantes Locais :
Matheus da Silva da Cruz
David J. A. Silva
Índice
Descrição do Projeto
Tecnologias Utilizadas
Funcionalidades Implementadas
Estrutura do Banco de Dados
Contatos
Descrição do Projeto
Este projeto é um sistema de gerenciamento de tarefas que permite aos usuários:

Pesquisar
Criar
Editar
Excluir
Visualizar tarefas
O objetivo é fornecer uma ferramenta simples e eficiente para a organização e acompanhamento de atividades diárias . O sistema conta com uma interface gráfica para o gerenciamento de usuários e clientes , utilizando MySQL para o armazenamento de dados.

Tecnologias Utilizadas
Linguagem : Java
Interface gráfica : Swing, JavaFX
Banco de Dados : MySQL
Ferramenta de gerenciamento : MySQL Workbench
Conexão com o Banco de Dados : JDBC
Funcionalidades Implementadas
Tela de Login
Autenticação com nome de usuário e senha.
Exibe erro se as credenciais forem incorretas.
Tela Principal
Menu com opções: Cadastro de Usuários , Cadastro de Clientes e Agenda .
Tela de Cadastro de Usuários
Campos : nome, e-mail, nome de usuário e senha.
Funcionalidades: pesquisa , adição , edição e exclusão de usuários , com validações para evitar duplicações.
Tela de Cadastro de Clientes
Campos : nome, endereço, telefone, e-mail e CPF/CNPJ.
Funcionalidades: gerenciamento de clientes .
Agenda para Registro de Compromissos
Campos : dados, hora, descrição e cliente associado.
Exibe compromissos em tabela com visualização por dia , semana ou mês .
Estrutura do Banco de Dados
Tabelas :
Usuários : id, nome, email, nome_usuario, senha
Clientes : id, nome, endereço, telefone, email, cpf_cnpj
Ordem do Dia : id, data, hora, descrição, cliente_id (chave estrangeira)
Contatos
Matheus da Silva da Cruz : motogmatheus362 @ gmail.com
David JA Silva : (inserir e-mail aqui)
