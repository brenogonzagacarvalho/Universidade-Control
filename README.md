# Projeto AutoEstudo

Este é o projeto **AutoEstudo**, composto por um **frontend** desenvolvido com **Vue.js** e **Vuetify**, e um **backend** desenvolvido com **Spring Boot**. O objetivo do projeto é gerenciar usuários, cursos e suas associações, com uma interface moderna e responsiva e uma API robusta.

---

## 🚀 Tecnologias Utilizadas

### **Frontend**
- **Vue.js**: Framework JavaScript progressivo para construção de interfaces de usuário.
- **Vuetify**: Biblioteca de componentes UI baseada em Material Design.
- **Vue Router**: Gerenciamento de rotas para navegação entre páginas.
- **Axios**: Cliente HTTP para comunicação com o backend.

### **Backend**
- **Spring Boot**: Framework Java para construção de APIs REST.
- **Spring Data JPA**: Para persistência de dados.
- **MySQL**: Banco de dados relacional.
- **Lombok**: Redução de código boilerplate.
- **Spring Security**: Para autenticação e autorização.
- **MinIO** (opcional): Para armazenamento de arquivos.

---

## 📦 Instalação

### **Frontend**
1. Clone o repositório:
   ```bash
   git clone <URL_DO_REPOSITORIO>
   ```

2. Acesse o diretório do frontend:
   ```bash
   cd frontEnd
   ```

3. Instale as dependências:
   ```bash
   npm install
   ```

4. Inicie o servidor de desenvolvimento:
   ```bash
   npm run dev
   ```

5. Acesse o frontend no navegador:
   ```
   http://localhost:3000
   ```

### **Backend**
1. Acesse o diretório do backend:
   ```bash
   cd backEnd
   ```

2. Configure o banco de dados MySQL:
   - Crie um banco de dados chamado `autoestudo`.
   - Atualize o arquivo `application.properties` com as credenciais do banco:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/autoestudo
     spring.datasource.username=SEU_USUARIO
     spring.datasource.password=SUA_SENHA
     ```

3. Compile e execute o backend:
   ```bash
   mvn spring-boot:run
   ```

4. O backend estará disponível em:
   ```
   http://localhost:8080
   ```

---

## 📂 Estrutura do Projeto

### **Frontend**
- **`src/main.js`**: Arquivo principal que inicializa o Vue, registra plugins e monta a aplicação.
- **`src/App.vue`**: Componente raiz que contém o layout principal e o `<router-view>` para renderizar as páginas.
- **`src/router/index.js`**: Configuração das rotas da aplicação.
- **`src/pages`**: Contém os componentes das páginas principais, como `Users.vue` e `Courses.vue`.
- **`src/plugins`**: Configuração de plugins como Vuetify e Axios.

### **Backend**
- **`src/main/java`**: Contém o código-fonte principal do backend.
  - **`controller`**: Controladores REST para gerenciar as requisições.
  - **`service`**: Contém a lógica de negócios.
  - **`repository`**: Interfaces para acesso ao banco de dados.
  - **`entity`**: Classes que representam as tabelas do banco de dados.
- **`src/main/resources/application.properties`**: Configurações do Spring Boot.

---

## 🌐 Funcionalidades

### **Frontend**
- **Gerenciamento de Usuários**:
  - Listar usuários.
  - Cadastrar novos usuários.
  - Atualizar informações de usuários.
  - Excluir usuários inativos.

- **Gerenciamento de Cursos**:
  - Listar cursos.
  - Cadastrar novos cursos.
  - Atualizar informações de cursos.
  - Excluir cursos.

- **Associação entre Usuários e Cursos**:
  - Relacionar um usuário a um curso específico.

### **Backend**
- **API REST**:
  - Endpoints para gerenciar usuários, cursos e associações.
- **Autenticação e Autorização**:
  - Login e controle de acesso com Spring Security.
- **Persistência de Dados**:
  - Gerenciamento de dados com Spring Data JPA e MySQL.
- **Armazenamento de Arquivos** (opcional):
  - Upload e gerenciamento de arquivos com MinIO.

---

## 🛠️ Requisitos

- **Node.js** (versão 16 ou superior) para o frontend.
- **Java 17** ou superior para o backend.
- **MySQL** para o banco de dados.
- **Maven** para gerenciar dependências do backend.

---

## 🤝 Contribuição

1. Faça um fork do projeto.
2. Crie uma nova branch:
   ```bash
   git checkout -b minha-feature
   ```
3. Faça as alterações e commit:
   ```bash
   git commit -m "Minha nova feature"
   ```
4. Envie para o repositório remoto:
   ```bash
   git push origin minha-feature
   ```
5. Abra um Pull Request.

---

## 📞 Contato

Para dúvidas ou sugestões, entre em contato:

- **Email**: brenogonzaga96@gmail.com
- **GitHub**: [github.com/brenogonzaga](https://github.com/brenogonzaga)

---

## 📜 Licença

Este projeto está licenciado sob a licença MIT.