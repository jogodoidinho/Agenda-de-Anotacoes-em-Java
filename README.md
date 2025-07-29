# 📝 Agenda de Anotações em Java

Uma aplicação de agenda de anotações desenvolvida em **Java**, com **persistência de dados via banco de dados**. O usuário interage diretamente pelo terminal, digitando as opções no menu apresentado pela classe principal (`Agenda.java`), que contém o método `main`.

## 🚀 Funcionalidades

- ✅ Criar novas anotações com título e conteúdo  
- 🔍 Listar todas as anotações salvas  
- 🔎 Buscar anotações por título  
- ❌ Remover anotações existentes  
- 💾 Armazenamento persistente usando banco de dados (via classe de conexão JDBC)

## 🛠️ Tecnologias e Componentes

- **Java** (ou versão compatível com JDBC)  
- **Conexão JDBC** para acesso ao banco (classe `Conexao.java`)  
- **POO (Programação Orientada a Objetos)**  
- Classes como `Nota`, `Agenda`, `NotaDAO` para encapsular operações de dados  
- Interação via console (`Scanner`) na classe `Agenda.java`

## 📁 Estrutura do Projeto

```bash
📦 Agenda-de-Anotacoes-em-Java
├── 📂 agenda
│   ├── Agenda.java        # Classe principal com menu e entrada do usuário (contém o método main)
│   ├── Nota.java          # Representa uma anotação
│   ├── Conexao.java       # Classe para conexão com o banco de dados
│   ├── NotaDAO.java       # Classe para operações CRUD no banco
│   └── Util.java          # Funções utilitárias (ex: limpar tela)
└── README.md              # Este arquivo
