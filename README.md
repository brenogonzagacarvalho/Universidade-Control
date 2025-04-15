# Frontend do Projeto AutoEstudo

Este é o frontend do projeto **AutoEstudo**, desenvolvido com **Vue.js** e **Vuetify**. O objetivo do projeto é gerenciar usuários, cursos e suas associações, com uma interface moderna e responsiva.

---

## 🚀 Tecnologias Utilizadas

- **Vue.js**: Framework JavaScript progressivo para construção de interfaces de usuário.
- **Vuetify**: Biblioteca de componentes UI baseada em Material Design.
- **Vue Router**: Gerenciamento de rotas para navegação entre páginas.
- **Axios**: Cliente HTTP para comunicação com o backend.

---

## 📦 Instalação

1. Clone o repositório:
   ```bash
   git clone <URL_DO_REPOSITORIO>
   ```

2. Acesse o diretório do projeto:
   ```bash
   cd frontEnd
   ```

3. Instale as dependências:
   ```bash
   npm install
   ```

---

## 🖥️ Como Rodar o Projeto

1. Inicie o servidor de desenvolvimento:
   ```bash
   npm run dev
   ```

2. Acesse o frontend no navegador:
   ```
   http://localhost:3000
   ```

---

## 📂 Estrutura do Projeto

- **`src/main.js`**: Arquivo principal que inicializa o Vue, registra plugins e monta a aplicação.
- **`src/App.vue`**: Componente raiz que contém o layout principal e o `<router-view>` para renderizar as páginas.
- **`src/router/index.js`**: Configuração das rotas da aplicação.
- **`src/pages`**: Contém os componentes das páginas principais, como `Users.vue` e `Courses.vue`.
- **`src/plugins`**: Configuração de plugins como Vuetify e Axios.

---

## 🌐 Funcionalidades

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

---

## 🛠️ Requisitos

- **Node.js** (versão 16 ou superior)
- **NPM** (ou **Yarn**) para gerenciar dependências

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