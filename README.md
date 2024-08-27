# Sistema de Controle de Estacionamento

Este projeto é um sistema de controle de estacionamento desenvolvido em Java, utilizando interface gráfica (Swing) e banco de dados MySQL. O objetivo do sistema é gerenciar os carros em um estacionamento, permitindo adicionar, atualizar, excluir e listar registros de veículos.

## Estrutura do Projeto

### Banco de Dados

O banco de dados utilizado é o MySQL, e a tabela `carros` foi criada com a seguinte estrutura:

```sql
CREATE TABLE carros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(50),
    placa VARCHAR(20) UNIQUE,
    cor VARCHAR(30),
    horaEntrada INT,
    horaSaida INT
);
Classes Java
• 
Carro: Representa a entidade de um carro no estacionamento.
• Atributos:
• `marca` (String): Marca do carro.
• `placa` (String): Placa do carro (única).
• `cor` (String): Cor do carro.
• `horaEntrada` (int): Hora de entrada no estacionamento.
• `horaSaida` (int): Hora de saída do estacionamento.
• Métodos:
• Construtores para inicialização dos objetos.
• Getters e Setters para acessar e modificar os atributos.
• 
CarroDAO: Responsável pelas operações CRUD no banco de dados.
• Métodos:
• `adicionarCarro(Carro carro)`: Adiciona um carro ao banco de dados.
• `listarCarros()`: Lista todos os carros cadastrados.
• `atualizarCarro(Carro carro)`: Atualiza as informações de um carro.
• `excluirCarro(String placa)`: Remove um carro do banco de dados com base na placa.
• 
ConexaoBD: Gerencia a conexão com o banco de dados MySQL.
• Métodos:
• `conectar()`: Estabelece uma conexão com o banco de dados e retorna um objeto `Connection`.
• 
EstacionamentoGUI: Fornece a interface gráfica para interagir com o sistema.
• 
Componentes:
• Campos de texto (`JTextField`) para entrada de dados.
• Botões (`JButton`) para adicionar, listar, atualizar e excluir carros.
• Área de texto (`JTextArea`) para exibir o relatório de carros cadastrados.
• 
Funcionalidades:
• Adicionar: Permite adicionar um novo carro ao banco de dados.
• Listar: Mostra todos os carros cadastrados no estacionamento.
• Atualizar: Atualiza as informações de um carro existente.
• Excluir: Remove um carro do banco de dados com base na placa.
Configuração do Projeto
O projeto utiliza o Maven para gerenciamento de dependências. A seguir, um exemplo de dependência utilizada:
xml
Copiar código
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.30</version>
</dependency>
Execução
1. 
Compilar o Projeto:
• No IntelliJ IDEA, selecione `Build > Rebuild Project` para compilar o código.
2. 
Executar a Aplicação:
• Clique com o botão direito na classe `EstacionamentoGUI` e selecione `Run 'EstacionamentoGUI.main()'`.
• A interface gráfica será exibida em uma janela separada.
Uso do Sistema
Ao iniciar o aplicativo, uma janela com a interface gráfica será exibida. Os usuários podem:
• Adicionar Carro: Preencher os campos e clicar no botão "Adicionar" para incluir um carro no banco de dados.
• Listar Carros: Clicar no botão "Listar" para exibir todos os carros cadastrados.
• Atualizar Carro: Preencher os campos e clicar no botão "Atualizar" para modificar as informações de um carro existente.
• Excluir Carro: Inserir a placa do carro e clicar no botão "Excluir" para removê-lo do banco de dados.
Contribuição
Sinta-se à vontade para contribuir com melhorias ou novas funcionalidades através de Pull Requests.
Licença
Este projeto está licenciado sob a Licença MIT. Consulte o arquivo LICENSE para obter mais informações.
