import java.awt.*; // Importa pacotes relacionados à interface gráfica, como Layouts e componentes gráficos
import java.awt.event.*; // Importa pacotes para manipulação de eventos
import java.sql.*; // Importa componentes gráficos do Swing (como JButton, JLabel, etc.)
import javax.swing.*; // Importa pacotes necessários para interação com banco de dados

public class TelaDeLogin extends JFrame { // Define a classe TelaDeLogin, que herda de JFrame (janela gráfica)
    private final JLabel lblLogin; // Declara um JLabel para o campo "Login"
    private final JTextField txtLogin; // Declara um JTextField para digitar o "Login"
    private final JLabel lblSenha; // Declara um JLabel para o campo "Senha"
    private final JPasswordField txtSenha; // Declara um JPasswordField para digitar a "Senha" de forma oculta
    private final JButton btnLogar; // Declara um JButton para o botão de "Logar"
    private final JLabel lblNotificacoes; // Declara um JLabel para exibir notificações

    public TelaDeLogin() { // Construtor da classe TelaDeLogin
        super("Tel de Login"); // Define o título da janela como "Tela de Login"
        // setLayout(new GridLayout(6,1,5,5)); // Comentado: Define um GridLayout com 6 linhas e 1 coluna, com espaços de 5px
        setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout (organiza os componentes em uma linha)

        lblLogin = new JLabel("Login:"); // Cria o JLabel "Login:"
        add(lblLogin); // Adiciona o JLabel à janela

        txtLogin = new JTextField(10); // Cria um JTextField para digitar o login (com 10 caracteres de largura)
        add(txtLogin); // Adiciona o JTextField à janela

        lblSenha = new JLabel("Senha:"); // Cria o JLabel "Senha:"
        add(lblSenha); // Adiciona o JLabel à janela

        txtSenha = new JPasswordField(10); // Cria um JPasswordField para digitar a senha de forma oculta (com 10 caracteres de largura)
        add(txtSenha); // Adiciona o JPasswordField à janela

        btnLogar = new JButton("Logar"); // Cria o JButton "Logar"
        add(btnLogar); // Adiciona o JButton à janela

        lblNotificacoes = new JLabel("Notificações"); // Cria um JLabel para exibir notificações
        // lblNotificacoes.setSize(getContentPane().getWidth(), 40); // Comentado: Tenta definir o tamanho do JLabel de notificações
        add(lblNotificacoes); // Adiciona o JLabel de notificações à janela

        ButtonHandler buttonHandler = new ButtonHandler(); // Cria um objeto do tipo ButtonHandler para tratar eventos do botão
        btnLogar.addActionListener(buttonHandler); // Registra o ButtonHandler como ouvinte para o evento de clique no botão "Logar"

        // Adiciona um KeyListener ao campo de senha para capturar a tecla "Enter"
        txtSenha.addKeyListener(
            new KeyAdapter() { // Classe anônima que extende KeyAdapter (para sobrepor o método keyReleased)
                @Override
                public void keyReleased(KeyEvent e) { // Sobrescreve o método keyReleased para detectar quando uma tecla é liberada
                    if (String.valueOf(txtSenha.getPassword()).trim().length() > 0) { // Verifica se a senha não está vazia
                        if (e.getKeyCode() == 10) { // Verifica se a tecla pressionada foi "Enter" (código 10)
                            System.out.println("Você teclou Enter"); // Exibe mensagem no console
                            logar(); // Chama o método logar() para tentar realizar o login
                        }
                    }
                }
            }
        );
    }

    private class ButtonHandler implements ActionListener { // Classe interna que implementa ActionListener para tratar eventos de botão
        @Override
        public void actionPerformed(ActionEvent event) { // Sobrescreve o método actionPerformed
            logar(); // Chama o método logar() quando o botão é pressionado
        }
    }

    public void logar() { // Método logar() para tentar realizar o login
        try {
            Connection conexao = MySQLConnector.conectar(); // Estabelece conexão com o banco de dados (MySQL)
            // Cria uma string SQL para verificar o login e senha no banco de dados
            String strSqlLogin = "select * from `db_senac`.`tbl_senac` where email = '" + txtLogin.getText() + "' and senha = '" + String.valueOf(txtSenha.getPassword()) + "';";
            Statement stmSqlLogin = conexao.createStatement(); // Cria um Statement para executar a consulta SQL
            ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strSqlLogin); // Executa a consulta SQL e armazena o resultado em ResultSet
            if (rstSqlLogin.next()) { // Verifica se o login e senha encontrados no banco são válidos
                notificarUsuario("Login " + rstSqlLogin.getString("email") + " realizado com sucesso."); // Exibe uma mensagem de sucesso
            } else {
                notificarUsuario("Não foi possível encontrar o login e/ou senha digitados. Por favor, verifique e tente novamente."); // Exibe uma mensagem de erro
            }
            stmSqlLogin.close(); // Fecha o Statement
        } catch (Exception e) { // Se houver algum erro na conexão ou consulta
            notificarUsuario("Houve um problema e não será possível realizar o login neste momento. Por favor, tente novamente mais tarde."); // Exibe uma mensagem de erro
            System.err.println("Ops! Deu ruim, se liga no erro: " + e); // Exibe o erro no console
        }
    }

    public String setHtmlFormat(String txt) { // Método para formatar texto em HTML
        return "<html><body>" + txt + "</body></html>"; // Retorna o texto formatado em HTML
    }

    public void notificarUsuario(String strTexto) { // Método para atualizar o JLabel de notificações com uma mensagem
        lblNotificacoes.setText(setHtmlFormat(strTexto)); // Define o texto do JLabel com a mensagem formatada em HTML
    }

    public static void main(String[] args) { // Método principal para iniciar a aplicação
        TelaDeLogin appTelaDeLogin = new TelaDeLogin(); // Cria uma instância da tela de login
        appTelaDeLogin.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define a ação ao fechar a janela: encerrar o programa
        appTelaDeLogin.setSize(150,200); // Define o tamanho da janela (150x200 pixels)
        appTelaDeLogin.setVisible(true); // Torna a janela visível para o usuário
    }
}
