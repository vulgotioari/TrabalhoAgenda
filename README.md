# Agenda de Trabalho

## Integrantes Locais

Matheus da Silva da Cruz

David J. A. Silva

## Índice

Descrição do Projeto

Emblemas

Tecnologias Empregadas

Funcionalidades Disponíveis

Estrutura do Banco de Dados

Contatos

## Descrição do Projeto

Este projeto consiste em um sistema para gerenciamento de tarefas que possibilita aos usuários pesquisar, criar, editar, excluir e visualizar suas atividades. O objetivo é oferecer uma ferramenta intuitiva e 
eficaz para organizar e gerenciar tarefas diárias, utilizando uma interface gráfica para o gerenciamento de usuários e clientes. Os dados são armazenados em um banco de dados MySQL, acessível através do MySQL 
Workbench.

No Banco de Dados:

A tabela Usuários armazenados: id, nome, email, nome_usuario, senha.

A tabela Clientes contém: id, nome, endereço, telefone, email, cpf_cnpj.

A tabela Agenda possui: id, data, hora, descrição, cliente_id (chave estrangeira).

## Emblemas

Os emblemas em Markdown são elementos gráficos utilizados em arquivos Markdown para apresentar informações, status ou links de forma visualmente atraente e facilmente compreensível. Eles são frequentemente usados
​​em repositórios de código, especialmente no GitHub, para fornecer informações rápidas e relevantes, como status de construção, cobertura de testes, versões de software, licenças, entre outros.

## Tecnologias Empregadas
Linguagem de Programação: Java (Swing: bibliotecas | JavaFX: Interface Gráfica).
Banco de Dados: MySQL.
Ferramenta de Gerenciamento de Banco de Dados: MySQL Workbench.
Conexão com o Banco de Dados: JDBC (Java Database Connectivity).

## Funcionalidades Disponíveis

Tela de Login

Campos: nome de usuário e senha.

Descrição: Permite que usuários cadastrados façam login no sistema. Em caso de erro, uma mensagem informativa será exibida.

Tela Principal

Descrição: Um menu que oferece opções como Cadastro, Relatório, Ajuda e Configurações. As principais funcionalidades estão na seção de Cadastro, que inclui: Cadastro de Usuários, Cadastro de Clientes e Agenda.
Tela de Cadastro de Usuários

Campos: nome, e-mail, nome de usuário e senha.

Descrição: Formulário que permite pesquisar, limpar, inserir, editar e excluir usuários do sistema, com validação para evitar duplicação de dados.
Tela de Cadastro de Clientes

Campos: nome, endereço, telefone, e-mail e CPF/CNPJ.

Descrição: Formulário que possibilita pesquisar, limpar, inserir, editar e excluir clientes do sistema.

Agenda para Registro de Compromissos

Campos: dados, horário, descrição e cliente associado.

Descrição: Formulário que permite registrar compromissos ou eventos, exibindo-os em uma tabela com opções de visualização por dia, semana ou mês.

Estrutura do Banco de Dados

Tabelas

Usuários: id, nome, email, nome_usuario, senha.

Clientes: id, nome, endereço, telefone, email, cpf_cnpj.

Agenda: id, data, hora, descrição, cliente_id (chave estrangeira).

## Contatos
![Gmail](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)

Matheus da Silva da Cruz: motogmatheus362@gmail.com

David JA Silva: davidsx999@gmail.com


