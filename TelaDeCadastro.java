import java.awt.*; // Importa a biblioteca AWT para componentes gráficos e layouts.
import java.awt.event.*; // Importa a biblioteca para eventos, como ActionListener.
import javax.swing.*; // Importa a biblioteca Swing para componentes gráficos como JButtons, JTextFields, etc.
import java.sql.*; // Importa a biblioteca para trabalhar com SQL (Banco de Dados).

public class TelaDeCadastro extends JFrame { // Cria a classe TelaDeCadastro, que herda de JFrame (uma janela).
    public final JLabel lblNome; // Declara o rótulo (label) para o campo "Nome".
    public final JTextField txtNome; // Declara o campo de texto para inserir o "Nome".

    public final JLabel lblEmail; // Declara o rótulo (label) para o campo "Email".
    public final JTextField txtEmail; // Declara o campo de texto para inserir o "Email".

    public final JLabel lblSenha; // Declara o rótulo (label) para o campo "Senha".
    public final JPasswordField txtSenha; // Declara o campo de texto para inserir a "Senha" (campo especial para senha).

    public final JButton btnCadastrar; // Declara o botão "Cadastrar".
    public final JButton btnCancelar; // Declara o botão "Cancelar".

    public final JLabel lblNotificacoes; // Declara o rótulo (label) para exibir notificações.

    public TelaDeCadastro() { // Construtor da classe TelaDeCadastro, chamado para inicializar os componentes.
        super("Tela de Cadastro"); // Chama o construtor da classe JFrame e define o título da janela.
        setLayout(new GridLayout(5,1,5,5)); // Define o layout da janela com 5 linhas e 1 coluna, com 5px de espaçamento entre os componentes.

        JPanel linhaNome = new JPanel(new GridLayout(1,2)); // Cria um painel para o campo "Nome" com 1 linha e 2 colunas.
        lblNome = new JLabel("Nome:", SwingConstants.RIGHT); // Cria o rótulo "Nome", alinhado à direita.
        txtNome = new JTextField(10); // Cria o campo de texto para o nome, com largura de 10 caracteres.
        linhaNome.add(lblNome); // Adiciona o rótulo "Nome" ao painel.
        linhaNome.add(txtNome); // Adiciona o campo de texto "Nome" ao painel.
        add(linhaNome); // Adiciona o painel "linhaNome" à janela principal.

        JPanel linhaEmail = new JPanel(new GridLayout(1,2)); // Cria um painel para o campo "Email" com 1 linha e 2 colunas.
        lblEmail = new JLabel("Email:", SwingConstants.RIGHT); // Cria o rótulo "Email", alinhado à direita.
        txtEmail = new JTextField(10); // Cria o campo de texto para o email, com largura de 10 caracteres.
        linhaEmail.add(lblEmail); // Adiciona o rótulo "Email" ao painel.
        linhaEmail.add(txtEmail); // Adiciona o campo de texto "Email" ao painel.
        add(linhaEmail); // Adiciona o painel "linhaEmail" à janela principal.

        JPanel linhaSenha = new JPanel(new GridLayout(1,2)); // Cria um painel para o campo "Senha" com 1 linha e 2 colunas.
        lblSenha = new JLabel("Senha:", SwingConstants.RIGHT); // Cria o rótulo "Senha", alinhado à direita.
        txtSenha = new JPasswordField(10); // Cria o campo de senha com largura de 10 caracteres.
        linhaSenha.add(lblSenha); // Adiciona o rótulo "Senha" ao painel.
        linhaSenha.add(txtSenha); // Adiciona o campo de senha ao painel.
        add(linhaSenha); // Adiciona o painel "linhaSenha" à janela principal.

        JPanel linhaBotoes = new JPanel(new GridLayout(1,2)); // Cria um painel para os botões, com 1 linha e 2 colunas.
        btnCadastrar = new JButton("Cadastrar"); // Cria o botão "Cadastrar".
        btnCancelar = new JButton("Cancelar"); // Cria o botão "Cancelar".
        linhaBotoes.add(btnCadastrar); // Adiciona o botão "Cadastrar" ao painel.
        linhaBotoes.add(btnCancelar); // Adiciona o botão "Cancelar" ao painel.
        add(linhaBotoes); // Adiciona o painel "linhaBotoes" à janela principal.

        JPanel linhaNotificacoes = new JPanel(new GridLayout(1,1)); // Cria um painel para as notificações com 1 linha e 1 coluna.
        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER); // Cria o rótulo "Notificações", centralizado.
        linhaNotificacoes.add(lblNotificacoes); // Adiciona o rótulo de notificações ao painel.
        add(linhaNotificacoes); // Adiciona o painel "linhaNotificacoes" à janela principal.

        btnCadastrar.addActionListener( // Adiciona um ouvinte de evento para o botão "Cadastrar".
            new ActionListener() { // Define o que acontece quando o botão "Cadastrar" é clicado.
                @Override
                public void actionPerformed(ActionEvent event) { // Método chamado quando o evento (clique) ocorre.
                    if (txtNome.getText().trim().length() == 0) { // Verifica se o campo "Nome" está vazio.
                        lblNotificacoes.setText("É necessário digitar alguma coisa no campo Nome. Por favor, digite um caracter válido no campo Nome para prosseguir."); // Exibe uma mensagem de erro.
                        txtNome.requestFocus(); // Define o foco para o campo "Nome".
                        return; // Interrompe a execução se o campo "Nome" estiver vazio.
                    }

                    if (txtEmail.getText().trim().length() == 0) { // Verifica se o campo "Email" está vazio.
                        lblNotificacoes.setText("É necessário digitar alguma coisa no campo Email. Por favor, digite um caracter válido no campo Email para prosseguir."); // Exibe uma mensagem de erro.
                        txtEmail.requestFocus(); // Define o foco para o campo "Email".
                        return; // Interrompe a execução se o campo "Email" estiver vazio.
                    }

                    if (String.valueOf(txtSenha.getPassword()).trim().length() == 0) { // Verifica se o campo "Senha" está vazio.
                        lblNotificacoes.setText("É necessário digitar alguma coisa no campo Senha. Por favor, digite um caracter válido no campo Senha para prosseguir."); // Exibe uma mensagem de erro.
                        txtSenha.requestFocus(); // Define o foco para o campo "Senha".
                        return; // Interrompe a execução se o campo "Senha" estiver vazio.
                    }

                    String strSqlCadastrar = "insert into `db_senac`.`tbl_senac` (`nome`, `email`, `senha`) values ('" + txtNome.getText() + "','" + txtEmail.getText() + "','" + String.valueOf(txtSenha.getPassword()) + "');"; // Cria a instrução SQL para inserir os dados no banco.
                    try { // Tenta executar a operação de cadastro.
                        Connection conexao = MySQLConnector.conectar(); // Estabelece uma conexão com o banco de dados.
                        Statement stmSqlCadastrar = conexao.createStatement(); // Cria um statement para executar a instrução SQL.
                        stmSqlCadastrar.addBatch(strSqlCadastrar); // Adiciona a instrução ao batch de comandos.
                        stmSqlCadastrar.executeBatch(); // Executa o batch de comandos no banco.
                        lblNotificacoes.setText("Cadastro realizado com sucesso!"); // Exibe a mensagem de sucesso.
                    } catch (Exception e) { // Caso ocorra um erro durante o processo.
                        lblNotificacoes.setText("Ops! Ocorrou um problema e não será possível cadastrar nesse momento. Por favor, tente novamente mais tarde."); // Exibe a mensagem de erro.
                        System.err.println("Erro: " + e); // Exibe o erro no console.
                    }
                }
            }
        );

        btnCancelar.addActionListener( // Adiciona um ouvinte de evento para o botão "Cancelar".
            new ActionListener() { // Define o que acontece quando o botão "Cancelar" é clicado.
                @Override
                public void actionPerformed(ActionEvent event) { // Método chamado quando o evento (clique) ocorre.
                    System.exit(0); // Encerra a aplicação.
                }
            }
        );

        setSize(300,300); // Define o tamanho da janela (300x300 pixels).
        setVisible(true); // Torna a janela visível.
    }

    public static void main(String[] args) { // Método principal que inicia a aplicação.
        TelaDeCadastro appTelaDeCadastro = new TelaDeCadastro(); // Cria uma nova instância da tela de cadastro.
        appTelaDeCadastro.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define a ação de fechamento da janela (encerrar a aplicação).
    }
}
