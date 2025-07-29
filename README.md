📝 Agenda de Anotações em Java
Uma aplicação de agenda de anotações desenvolvida em Java, com persistência de dados via banco de dados. O usuário interage pelo terminal através da classe principal (Agenda.java).

🚀 Funcionalidades
✅ Criar novas anotações com título e conteúdo

🔍 Listar todas as anotações salvas

🔎 Buscar anotações por título

❌ Remover anotações existentes

💾 Armazenamento persistente usando banco de dados (via classe de conexão JDBC)

🛠️ Tecnologias e Componentes
Java 17+ (ou versão compatível com JDBC)

Conexão JDBC para acesso ao banco (classe Conexao.java)

POO (Programação Orientada a Objetos)

Classes como Nota, Agenda, e DAO para encapsular operações

Interação via console (Scanner) na classe Agenda.java

📁 Estrutura do Projeto
bash
Copiar
Editar
📦 Agenda-de-Anotacoes-em-Java
├── 📂 agenda
│   ├── Agenda.java        # Classe principal com menu e entrada do usuário
│   ├── Nota.java          # Representa uma anotação
│   ├── Conexao.java       # Classe para conexão com o banco de dados
│   ├── NotaDAO.java       # Classe para operações CRUD no banco
│   └── Util.java          # Funções utilitárias (ex: limpar tela)
└── README.md              # Este arquivo
▶️ Como Executar
Clone o repositório:

bash
Copiar
Editar
git clone https://github.com/jogodoidinho/Agenda-de-Anotacoes-em-Java.git
cd Agenda-de-Anotacoes-em-Java
Ajuste os parâmetros de conexão no Conexao.java:

java
Copiar
Editar
String SERVER = "localhost";
String DATABASE = "nome_do_banco";
String USER = "usuario";
String PASSWORD = "senha";
Certifique-se de que o driver JDBC (por exemplo, mysql-connector-java.jar) esteja no classpath.

Compile:

bash
Copiar
Editar
javac agenda/*.java
Execute a aplicação:

bash
Copiar
Editar
java agenda.Agenda
🧪 Exemplo de Uso no Terminal
text
Copiar
Editar
====== MENU ======
1. Adicionar anotação
2. Listar anotações
3. Buscar anotação
4. Remover anotação
5. Sair
Escolha: _
Aqui, todas as interações são feitas pelo usuário, digitando a opção desejada no método main da classe Agenda.

📌 Objetivo do Projeto
Esse projeto tem o objetivo de praticar:

Conexão e persistência com banco de dados usando JDBC;

Criação de camadas de acesso (DAO);

Interação via terminal com entradas recebidas pelo usuário;

Organização modular e boa separação de responsabilidades.

🤝 Contribuições
Contribuições e melhorias são bem-vindas! Abra issues ou envie pull requests. 🙂
