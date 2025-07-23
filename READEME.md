# Projeto Backend JDBC - MySQL

Este projeto foi desenvolvido com o objetivo de **ensinar como conectar uma aplicação Java ao banco de dados MySQL usando JDBC**, além de mostrar duas formas de conexão: usando **arquivo `.properties`** e **variáveis de ambiente**.

---

## 🎯 Objetivos

- Aprender a usar JDBC com Java
- Conectar com MySQL de forma segura
- Utilizar propriedades externas ou variáveis de ambiente para conexão
- Gerenciar a conexão e seu encerramento corretamente

---

## ⚙️ Requisitos

- JDK 17+ instalado
- Eclipse IDE
- Conector JDBC (MySQL)
- MySQL instalado
- Variáveis de ambiente configuradas (opcional)

---

## 📁 Estrutura do Projeto

```

JDBC-ConnectionDB/
├── src/
│   ├── apication/
│   │   └── app.java                   # Classe principal que executa a conexão e desconexão
│   ├── db/
│   │   ├── DB.java                    # Classe principal de conexão via properties
│   │   ├── Exceptions/
│   │   │   └── DbException.java       # Exceção personalizada
│   │   ├── closes/
│   │   │   └── CloseConection.java    # Encerramento seguro da conexão
│   │   └── data/
│   │       ├── LoadProperties.java           # Carregamento do arquivo .properties
│   │       └── LoadVariaveisAmbiente.java    # Carregamento das variáveis de ambiente
├── properties/
│   └── db.properties                 # Arquivo de configuração de conexão

````

---

## 🔧 Configuração do Projeto

### 1. Baixe o Conector JDBC

Você pode usar conectores diferentes conforme o banco de dados:

- [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)
- [PostgreSQL JDBC Driver](https://jdbc.postgresql.org/download.html)

Salve o `.jar` em `C:\Program Files\Java\lib` ou em outro local conveniente.

---

### 2. Configure o Eclipse

1. **Importe o projeto:**
   - `File > Open Projects from File System`

2. **Crie uma biblioteca:**
   - `Window > Preferences > Java > Build Path > User Libraries`
   - Clique em **"New..."**, dê um nome (ex: `MySQLConnector`)
   - Selecione a biblioteca criada e clique em **"Add External JARs..."**, depois selecione o conector `.jar`

3. **Adicione a biblioteca ao projeto:**
   - Botão direito no projeto > `Build Path > Configure Build Path`
   - Aba **Libraries > Add Library > User Library**
   - Escolha a biblioteca personalizada criada

---

## 🔐 Formas de Conexão

### 1. Usando `db.properties`

#### 📁 Arquivo: `properties/db.properties`
	- Crie uma pasta na raiz do projeto, como nome de properties e dentro dela crie um arquivo chamado
	- db.properties e dentro do arquivo 
	
	
						dburl=jdbc:mysql://localhost:3306/meu_banco
						user=root
						password=123456
						
	- Lembrando que antes tem que ser criado uma base de dados chamado de exemplo : "meu_banco"
					

#### 📦 Classe: `LoadProperties.java`

```java
public static Properties dbProperties() {
    try (FileInputStream fs = new FileInputStream("properties/db.properties")) {
        Properties props = new Properties();
        props.load(fs);
        return props;
    } catch (IOException e) {
        throw new DbException(e.getMessage());
    }
}
```

#### 📦 Classe: `DB.java`

```java
public static Connection getConectComProperties() {
    if (conn == null) {
        try {
            Properties props = LoadProperties.dbProperties();
            String url = props.getProperty("dburl");
            System.out.println("Conectando ao banco de dados: " + url);
            conn = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
    return conn;
}
```

---

### 2. Usando Variáveis de Ambiente

Você pode optar por não usar um arquivo `.properties`, e sim configurar dados sensíveis diretamente nas **variáveis de ambiente do sistema**.

#### 📦 Classe: `LoadVariaveisAmbiente.java`

```java
public static Connection getConectVariaveisAmbiente(Connection conn) {
    if (conn == null) {
        try {
            String host = System.getenv("DB_HOST");
            String port = System.getenv("DB_PORT");
            String user = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");
            String dbName = System.getenv("DB_NAME");

            String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
            System.out.println("Conectando ao banco de dados: " + url);
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco: " + e.getMessage(), e);
        }
    }
    return conn;
}
```

---

## 🧱 Como Configurar Variáveis de Ambiente no Windows

### ▶️ Passo a Passo

1. Pressione `Win + S` e digite **“variáveis de ambiente”**
2. Clique em **“Editar variáveis de ambiente do sistema”**
3. Na nova janela, clique em **“Variáveis de ambiente...”**
4. Em **Variáveis de usuário**, clique em **"Nova..."** para cada item abaixo:

| Nome da variável | Valor exemplo |
| ---------------- | ------------- |
| `DB_HOST`        | `localhost`   |
| `DB_PORT`        | `3306`        |
| `DB_NAME`        | `meu_banco`   |
| `DB_USER`        | `root`        |
| `DB_PASSWORD`    | `123456`      |

5. Clique em **OK** em todas as janelas para salvar.

### 🔁 Importante:

* **Reinicie o computador** depois de definir as variáveis para garantir que o Java consiga acessá-las com `System.getenv()`.

---

## ❌ Encerrando a Conexão

### 📦 Classe: `CloseConection.java`

```java
public static void closeConection(Connection conn) {
    if (conn != null) {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
```

---

## ▶️ Executando o Projeto

### 📦 Classe: `app.java`

```java
public class app {
    public static void main(String[] args) {
        System.out.println("====================");	
        System.out.println("Banco Conectado");	
        System.out.println("====================");	

        // Conexão com arquivo .properties
        Connection conn = DB.getConectComProperties();

        // Ou, se quiser usar variáveis de ambiente:
        // Connection conn = LoadVariaveisAmbiente.getConectVariaveisAmbiente(DB.conn);

        CloseConection.closeConection(conn);

        System.out.println("====================");	
        System.out.println("Banco Desconectado");	
        System.out.println("====================");	
    }
}
```

---

## 🧠 O que você aprende neste projeto?

* Como funciona o JDBC
* Como ler arquivos `.properties` em Java
* Como acessar variáveis de ambiente
* Como usar exceções personalizadas
* Como criar e gerenciar a conexão de forma segura

---

## 📌 Observações

* Nunca salve senhas reais em arquivos públicos ou repositórios abertos
* Sempre feche suas conexões com `close()` para evitar vazamento de recursos
* O uso de `Properties` ou variáveis de ambiente melhora a segurança e flexibilidade

---

## 📫 Contato

Se tiver dúvidas ou quiser contribuir, sinta-se à vontade para abrir uma **issue** ou enviar um **pull request**.

---

**Desenvolvido com fins didáticos.**

```

