import java.awt.*; // Importa pacotes para manipulação de layouts e componentes gráficos (como GridLayout, etc.)
import java.awt.event.*; // Importa pacotes para manipulação de eventos, como ActionListener, KeyListener
import javax.swing.*; // Importa componentes gráficos do Swing (como JFrame, JButton, JTextField, etc.)
// import java.sql.*; // Importa pacotes de SQL (comentado, não usado no código atual)

public class TelaDePesquisa extends JFrame { // Define a classe TelaDePesquisa que herda de JFrame (janela gráfica)
    public static final JTextField txtPesquisa = new JTextField(20); // Cria um JTextField estático para pesquisa, com largura de 20 caracteres
    public final JButton btnPesquisar; // Declara um JButton para "Pesquisar"
    public final JButton btnReiniciarPesquisa; // Declara um JButton para "Reiniciar Pesquisa"

    public final JLabel lblId; // Declara um JLabel para "Id"
    public static final JTextField txtId = new JTextField(10); // Cria um JTextField estático para o campo "Id", com largura de 10 caracteres

    public final JLabel lblNome; // Declara um JLabel para "Nome"
    public static final JTextField txtNome = new JTextField(10); // Cria um JTextField estático para o campo "Nome", com largura de 10 caracteres

    public final JLabel lblEmail; // Declara um JLabel para "Email"
    public static final JTextField txtEmail = new JTextField(10); // Cria um JTextField estático para o campo "Email", com largura de 10 caracteres

    public static final JButton btnPrimeiro = new JButton("<<");; // Cria um JButton estático para o botão "Primeiro"
    public static final JButton btnAnterior = new JButton("<");; // Cria um JButton estático para o botão "Anterior"
    public static final JButton btnProximo = new JButton(">");; // Cria um JButton estático para o botão "Próximo"
    public static final JButton btnUltimo = new JButton(">>");; // Cria um JButton estático para o botão "Último"

    public static final JLabel lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER); // Cria um JLabel estático para notificações, centralizado

    public TelaDePesquisa() { // Construtor da classe TelaDePesquisa
        super("Tela de Pesquisa"); // Define o título da janela como "Tela de Pesquisa"
        setLayout(new GridLayout(7,1,5,5)); // Define o layout da janela como GridLayout com 7 linhas e 1 coluna, com espaçamento de 5px

        JPanel linhaInputPesquisa = new JPanel(new GridLayout(1,1)); // Cria um JPanel com um GridLayout de 1 linha e 1 coluna
        linhaInputPesquisa.add(txtPesquisa); // Adiciona o JTextField "txtPesquisa" ao JPanel
        add(linhaInputPesquisa); // Adiciona o JPanel à janela principal

        JPanel linhaBotaoPesquisar = new JPanel(new GridLayout(1,2)); // Cria um JPanel com um GridLayout de 1 linha e 2 colunas
        btnPesquisar = new JButton("Pesquisar"); // Cria o botão "Pesquisar"
        btnPesquisar.setEnabled(false); // Desabilita o botão "Pesquisar" inicialmente
        linhaBotaoPesquisar.add(btnPesquisar); // Adiciona o botão "Pesquisar" ao JPanel
        btnReiniciarPesquisa = new JButton("Reiniciar Pesquisa"); // Cria o botão "Reiniciar Pesquisa"
        linhaBotaoPesquisar.add(btnReiniciarPesquisa); // Adiciona o botão "Reiniciar Pesquisa" ao JPanel
        add(linhaBotaoPesquisar); // Adiciona o JPanel à janela principal

        JPanel linhaId = new JPanel(new GridLayout(1,2)); // Cria um JPanel com um GridLayout de 1 linha e 2 colunas
        lblId = new JLabel("Id:", SwingConstants.RIGHT); // Cria o JLabel "Id", alinhado à direita
        txtId.setEditable(false); // Define que o campo de texto "txtId" não pode ser editado
        linhaId.add(lblId); // Adiciona o JLabel "Id" ao JPanel
        linhaId.add(txtId); // Adiciona o JTextField "txtId" ao JPanel
        add(linhaId); // Adiciona o JPanel à janela principal

        JPanel linhaNome = new JPanel(new GridLayout(1,2)); // Cria um JPanel com um GridLayout de 1 linha e 2 colunas
        lblNome = new JLabel("Nome:", SwingConstants.RIGHT); // Cria o JLabel "Nome", alinhado à direita
        txtNome.setEditable(false); // Define que o campo de texto "txtNome" não pode ser editado
        linhaNome.add(lblNome); // Adiciona o JLabel "Nome" ao JPanel
        linhaNome.add(txtNome); // Adiciona o JTextField "txtNome" ao JPanel
        add(linhaNome); // Adiciona o JPanel à janela principal

        JPanel linhaEmail = new JPanel(new GridLayout(1,2)); // Cria um JPanel com um GridLayout de 1 linha e 2 colunas
        lblEmail = new JLabel("Email:", SwingConstants.RIGHT); // Cria o JLabel "Email", alinhado à direita
        txtEmail.setEditable(false); // Define que o campo de texto "txtEmail" não pode ser editado
        linhaEmail.add(lblEmail); // Adiciona o JLabel "Email" ao JPanel
        linhaEmail.add(txtEmail); // Adiciona o JTextField "txtEmail" ao JPanel
        add(linhaEmail); // Adiciona o JPanel à janela principal

        JPanel linhaBotoes = new JPanel(new GridLayout(1,4)); // Cria um JPanel com um GridLayout de 1 linha e 4 colunas
        linhaBotoes.add(btnPrimeiro); // Adiciona o botão "Primeiro" ao JPanel
        linhaBotoes.add(btnAnterior); // Adiciona o botão "Anterior" ao JPanel
        linhaBotoes.add(btnProximo); // Adiciona o botão "Próximo" ao JPanel
        linhaBotoes.add(btnUltimo); // Adiciona o botão "Último" ao JPanel
        add(linhaBotoes); // Adiciona o JPanel à janela principal

        JPanel linhaNotificacoes = new JPanel(new GridLayout(1,1)); // Cria um JPanel com um GridLayout de 1 linha e 1 coluna
        linhaNotificacoes.add(lblNotificacoes); // Adiciona o JLabel "Notificações" ao JPanel
        add(linhaNotificacoes); // Adiciona o JPanel à janela principal

        // Define a ação do botão "Primeiro" para navegar até o primeiro registro
        btnPrimeiro.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    NavegadorDeRegistro.vaParaPrimeiroRegistro(); // Chama o método para ir ao primeiro registro
                }
            }
        );

        // Define a ação do botão "Anterior" para navegar até o registro anterior
        btnAnterior.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    NavegadorDeRegistro.vaParaRegistroAnterior(); // Chama o método para ir ao registro anterior
                }
            }
        );

        // Define a ação do botão "Próximo" para navegar até o próximo registro
        btnProximo.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    NavegadorDeRegistro.vaParaProximoRegistro(); // Chama o método para ir ao próximo registro
                }
            }
        );

        // Define a ação do botão "Último" para navegar até o último registro
        btnUltimo.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    NavegadorDeRegistro.vaParaUltimoRegistro(); // Chama o método para ir ao último registro
                }
            }
        );

        // Define a ação do botão "Pesquisar" para registrar a pesquisa
        btnPesquisar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    NavegadorDeRegistro.registrarPesquisa(); // Chama o método para registrar a pesquisa
                    txtPesquisa.setText(txtPesquisa.getText().trim()); // Remove espaços extras do texto de pesquisa
                }
            }
        );

        // Define a ação do campo de pesquisa (txtPesquisa) para habilitar o botão "Pesquisar"
        txtPesquisa.addKeyListener(
            new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    btnPesquisar.setEnabled(detectarPesquisa()); // Habilita o botão "Pesquisar" se houver texto na pesquisa
                    if (e.getKeyCode() == 10 && txtPesquisa.getText().trim().length() > 0) { // Se Enter for pressionado
                        NavegadorDeRegistro.registrarPesquisa(); // Chama o método para registrar a pesquisa
                        txtPesquisa.setText(txtPesquisa.getText().trim()); // Remove espaços extras do texto de pesquisa
                    }
                }
            }
        );

        // Define a ação do botão "Reiniciar Pesquisa" para limpar os campos e reiniciar a pesquisa
        btnReiniciarPesquisa.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtPesquisa.setText(""); // Limpa o campo de pesquisa
                    NavegadorDeRegistro.registroDePesquisa = ""; // Reinicia o valor de pesquisa
                    NavegadorDeRegistro.clausulasDePesquisaComWhere = ""; // Reinicia as cláusulas com WHERE
                    NavegadorDeRegistro.clausulasDePesquisaSemWhere = ""; // Reinicia as cláusulas sem WHERE
                    NavegadorDeRegistro.vaParaPrimeiroRegistro(); // Vai para o primeiro registro
                    btnPesquisar.setEnabled(false); // Desabilita o botão "Pesquisar"
                    txtPesquisa.requestFocus(); // Foca no campo de pesquisa
                }
            }
        );

        setSize(300,300); // Define o tamanho da janela como 300x300 pixels
        setVisible(true); // Torna a janela visível

        NavegadorDeRegistro.inicializacaoDeRegistros(); // Inicializa os registros, chamando o método estático de NavegadorDeRegistro
    }

    public static void notificarUsuario(String strTexto) { // Método estático para notificar o usuário com texto
        lblNotificacoes.setText(setHtmlFormat(strTexto)); // Define o texto da JLabel de notificações com formatação HTML
    }

    public static String setHtmlFormat(String strTexto) { // Método para formatar texto com HTML
        return "<html><body>" + strTexto + "</body></html>"; // Retorna o texto formatado com tags HTML
    }

    public static void habilitarVoltar() { // Habilita apenas os botões para voltar (primeiro e anterior)
        btnPrimeiro.setEnabled(true);
        btnAnterior.setEnabled(true);
        btnProximo.setEnabled(false);
        btnUltimo.setEnabled(false);
    }

    public static void habilitarAvancar() { // Habilita apenas os botões para avançar (próximo e último)
        btnPrimeiro.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnProximo.setEnabled(true);
        btnUltimo.setEnabled(true);
    }

    public static void habilitarTodos() { // Habilita todos os botões
        btnPrimeiro.setEnabled(true);
        btnAnterior.setEnabled(true);
        btnProximo.setEnabled(true);
        btnUltimo.setEnabled(true);
    }

    public static void desabilitarTodos() { // Desabilita todos os botões
        btnPrimeiro.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnProximo.setEnabled(false);
        btnUltimo.setEnabled(false);
    }

    public static boolean detectarPesquisa() { // Verifica se há texto no campo de pesquisa
        if (txtPesquisa.getText().trim().length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void limparCampos() { // Limpa os campos de Id, Nome e Email
        txtId.setText("");
        txtNome.setText("");
        txtEmail.setText("");
    }

    public static void main(String[] args) { // Método main que inicializa a aplicação
        TelaDePesquisa appTelaDePesquisa = new TelaDePesquisa(); // Cria a instância da tela de pesquisa
        appTelaDePesquisa.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define o comportamento de fechamento da janela
    }
}
