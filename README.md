# MVSistemas
Desafio para vaga de Java Junior

No desenvolvimento desse projeto foi utilizando banco de dados Oracle, Java EE (Java Enterprise Edition) com JSP JavaServer Pages e Java Servlets.
# Criação do Banco
1. Usuário(schema) utilizado no desenvolvimento foi "C##DEVELOPER". A senha de acesso é "devmv";
2. Executar os scripts das tabelas para criação das mesmas no banco. Os scripts localizam-se na pasta TABLES;
3. Compilar as PCK's no banco de dados que se encontram em PACKAGE;
# Aplicação JAVA
1. Para executar a coneção com o banco de dados, é necessário executar o passo 1 de Criação do Banco utilizando os mesmos paramêtros. Caso queira alterar as configurações, é necessário alterar a string de conexão com banco de dados no pacote Model "Conexao.java";
2. Importar as libs configuradas que estão na pasta sr/main/webapp/WEB_INF/lib;
3. O projeto não está 100% funcional, para testar, execute o arquivo index.html que está na pasta sr/main/webapp/index.html;
# Observações
1. O programa cria um Cliente e uma Conta;
2. Não está desenvolvido: Cálculo de movimentação dos clientes, Cálculo da receita da empresa assim como as impressões de relatórios, CRUD de Endereços e informações de Pessoa Jurídica;
3. O programa executa uma view(index.html) no navegador de onde parte o acesso as funcionalidades do sistema.
# Boas Práticas
- Reutilização de código;
- Responsabilidade única para cada Classe e para cada PCK no banco;
- Utilização do padrão MVC (Model-View-Controller)
# Padrões de Projeto:
- Singleton
