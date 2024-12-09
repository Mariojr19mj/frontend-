import java.awt.*;  // Importa classes para interfaces gráficas em Java.
import java.awt.event.*;  // Importa eventos para interação com componentes gráficos.
import java.sql.*;  // Importa classes para conectar e manipular banco de dados.
import javax.swing.*;  // Importa classes para construir interfaces gráficas com componentes Swing.

public class TelaDeAtualizacao extends JFrame {  // Define uma classe que herda de JFrame, criando uma janela gráfica.
    public static JLabel lblId;  // Declara uma variável para o label que exibe "Id".
    public static JComboBox<String> cbxId;  // Declara uma combo box para selecionar um Id.

    public static JLabel lblNome;  // Declara uma variável para o label "Nome".
    public static JTextField txtNome;  // Declara uma variável para o campo de texto do "Nome".
    public static String txtNomeCarregado;  // Variável para armazenar o nome carregado do banco de dados.

    public static JLabel lblEmail;  // Declara uma variável para o label "Email".
    public static JTextField txtEmail;  // Declara uma variável para o campo de texto do "Email".
    public static String txtEmailCarregado;  // Variável para armazenar o email carregado do banco de dados.

    public static JLabel lblSenha;  // Declara uma variável para o label "Senha".
    public static JPasswordField txtSenha;  // Declara uma variável para o campo de senha.

    public static JButton btnAtualizar;  // Declara um botão para atualizar os dados.
    public static JButton btnCancelar;  // Declara um botão para cancelar a operação.

    public static JLabel lblNotificacoes;  // Declara um label para exibir notificações.

    public static GridBagLayout gbLayout;  // Declara um layout para organizar os componentes.
    public static GridBagConstraints gbConstraints;  // Declara as restrições do layout para posicionar os componentes.

    public TelaDeAtualizacao() {  // Construtor da classe, que cria a interface gráfica.
        super("Tela de Atualização");  // Chama o construtor da superclasse JFrame, definindo o título da janela.

        gbLayout = new GridBagLayout();  // Instancia o layout GridBagLayout.
        setLayout(gbLayout);  // Define o layout da janela como GridBagLayout.
        gbConstraints = new GridBagConstraints();  // Instancia as restrições do layout.

        lblId = new JLabel("Id:", SwingConstants.RIGHT);  // Cria o label para "Id" alinhado à direita.
        addComponent(lblId, 0, 0, 1, 1);  // Adiciona o label na posição (0, 0) da grade.

        cbxId = new JComboBox<String>();  // Cria a combo box para selecionar o Id.
        popularCbxId();  // Chama o método que preenche a combo box com os Ids do banco de dados.
        addComponent(cbxId, 0, 1, 1, 1);  // Adiciona a combo box na posição (0, 1) da grade.

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);  // Cria o label para "Nome" alinhado à direita.
        addComponent(lblNome, 1, 0, 1, 1);  // Adiciona o label na posição (1, 0) da grade.

        txtNome = new JTextField(10);  // Cria o campo de texto para o nome, com largura de 10 caracteres.
        addComponent(txtNome, 1, 1, 1, 1);  // Adiciona o campo de texto na posição (1, 1) da grade.

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);  // Cria o label para "Email" alinhado à direita.
        addComponent(lblEmail, 2, 0, 1, 1);  // Adiciona o label na posição (2, 0) da grade.

        txtEmail = new JTextField(10);  // Cria o campo de texto para o email, com largura de 10 caracteres.
        addComponent(txtEmail, 2, 1, 1, 1);  // Adiciona o campo de texto na posição (2, 1) da grade.

        atualizarCampos(String.valueOf(cbxId.getSelectedItem()));  // Chama o método para carregar os dados do Id selecionado na combo box.

        lblSenha = new JLabel("Senha:", SwingConstants.RIGHT);  // Cria o label para "Senha" alinhado à direita.
        addComponent(lblSenha, 3, 0, 1, 1);  // Adiciona o label na posição (3, 0) da grade.

        txtSenha = new JPasswordField(10);  // Cria o campo de senha, com largura de 10 caracteres.
        addComponent(txtSenha, 3, 1, 1, 1);  // Adiciona o campo de senha na posição (3, 1) da grade.

        btnAtualizar = new JButton("Atualizar");  // Cria o botão "Atualizar".
        btnAtualizar.setEnabled(false);  // Desabilita o botão "Atualizar" inicialmente.
        addComponent(btnAtualizar, 4, 0, 1, 1);  // Adiciona o botão na posição (4, 0) da grade.

        btnCancelar = new JButton("Cancelar");  // Cria o botão "Cancelar".
        addComponent(btnCancelar, 4, 1, 1, 1);  // Adiciona o botão na posição (4, 1) da grade.

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);  // Cria o label para exibir notificações centralizado.
        addComponent(lblNotificacoes, 5, 0, 2, 1);  // Adiciona o label na posição (5, 0) da grade, ocupando 2 colunas.

        cbxId.addItemListener(  // Adiciona um ouvinte de evento para a combo box.
            new ItemListener() {  // Implementa o ItemListener para quando o item da combo box for alterado.
                @Override
                public void itemStateChanged(ItemEvent event) {
                    if (event.getStateChange() == ItemEvent.SELECTED) {  // Verifica se o item foi selecionado.
                        atualizarCampos(String.valueOf(cbxId.getSelectedItem()));  // Atualiza os campos com os dados do Id selecionado.
                    }
                }
            }
        );

        // Ações do botão "Atualizar"
        btnAtualizar.addActionListener(  // Adiciona um ouvinte de evento para o botão "Atualizar".
            new ActionListener() {  // Implementa o ActionListener para a ação de clicar no botão.
                @Override
                public void actionPerformed(ActionEvent event) {  // Define o que acontece quando o botão é pressionado.
                    try {
                        Connection conexao = MySQLConnector.conectar();  // Estabelece a conexão com o banco de dados.
                        String atualizarSenha = "";  // Variável para armazenar a atualização da senha, se for fornecida.
                        if (String.valueOf(txtSenha.getPassword()).trim().length() > 0) {  // Verifica se a senha foi preenchida.
                            atualizarSenha = ", `senha` = '" + String.valueOf(txtSenha.getPassword()).trim() + "'";  // Prepara a atualização da senha.
                        }
                        String strSqlAtualizarId = "update `db_senac`.`tbl_senac` set `nome` = '" + txtNome.getText().trim() + "', `email` = '" + txtEmail.getText().trim() + "'" + atualizarSenha + " where `id` = " + String.valueOf(cbxId.getSelectedItem()) + ";";  // SQL para atualizar os dados no banco.
                        Statement stmSqlAtualizarId = conexao.createStatement();  // Cria um Statement para executar o SQL.
                        stmSqlAtualizarId.addBatch(strSqlAtualizarId);  // Adiciona o comando de atualização ao lote de comandos.
                        stmSqlAtualizarId.executeBatch();  // Executa o lote de comandos.
                        txtNomeCarregado = txtNome.getText().trim();  // Atualiza o nome carregado.
                        txtEmailCarregado = txtEmail.getText().trim();  // Atualiza o email carregado.
                        btnAtualizar.setEnabled(false);  // Desabilita o botão de atualização após a mudança.
                        notificarUsuario("O id " + String.valueOf(cbxId.getSelectedItem()) + " foi atualizado com sucesso.");  // Notifica o usuário do sucesso na atualização.
                    } catch (Exception e) {  // Em caso de erro, exibe uma mensagem de erro.
                        notificarUsuario("Ops! Problema no servidor, tente novamente mais tarde.");
                        System.err.println("Erro: " + e);
                    }
                }
            }
        );

        // Adiciona ouvintes para os campos de texto para habilitar o botão "Atualizar" caso algum valor seja alterado.
        txtNome.addKeyListener(  // Adiciona um ouvinte para o campo "Nome".
            new KeyAdapter() {  // Implementa um KeyAdapter para o evento de digitação.
                @Override
                public void keyReleased(KeyEvent event) {  // Define o que acontece quando uma tecla é solta.
                    if (txtNomeCarregado.trim().equals(txtNome.getText().trim())) {  // Verifica se o nome não foi alterado.
                        btnAtualizar.setEnabled(false);  // Desabilita o botão de atualizar se o nome não for alterado.
                    } else {
                        btnAtualizar.setEnabled(true);  // Habilita o botão de atualizar se o nome for alterado.
                    }
                }
            }
        );

        txtEmail.addKeyListener(  // Adiciona um ouvinte para o campo "Email".
            new KeyAdapter() {  // Implementa um KeyAdapter para o evento de digitação.
                @Override
                public void keyReleased(KeyEvent event) {  // Define o que acontece quando uma tecla é solta.
                    if (txtEmailCarregado.trim().equals(txtEmail.getText().trim())) {  // Verifica se o email não foi alterado.
                        btnAtualizar.setEnabled(false);  // Desabilita o botão de atualizar se o email não for alterado.
                    } else {
                        btnAtualizar.setEnabled(true);  // Habilita o botão de atualizar se o email for alterado.
                    }
                }
            }
        );

        txtSenha.addKeyListener(  // Adiciona um ouvinte para o campo "Senha".
            new KeyAdapter() {  // Implementa um KeyAdapter para o evento de digitação.
                @Override
                public void keyReleased(KeyEvent event) {  // Define o que acontece quando uma tecla é solta.
                    if (String.valueOf(txtSenha.getPassword()).trim().length() == 0) {  // Verifica se a senha não foi preenchida.
                        btnAtualizar.setEnabled(false);  // Desabilita o botão de atualizar se a senha estiver vazia.
                    } else {
                        btnAtualizar.setEnabled(true);  // Habilita o botão de atualizar se a senha for preenchida.
                    }
                }
            }
        );

        setSize(206,200);  // Define o tamanho da janela.
        setVisible(true);  // Torna a janela visível.
    }

    public void addComponent(Component component, int row, int column, int width, int height) {  // Método para adicionar componentes à tela usando o GridBagLayout.
        if (height > 1 && width > 1) {  // Se o componente ocupar mais de uma linha e coluna.
            gbConstraints.fill = GridBagConstraints.BOTH;  // Define o preenchimento para ocupar todo o espaço disponível.
        } else if (height > 1) {  // Se o componente ocupar mais de uma linha.
            gbConstraints.fill = GridBagConstraints.VERTICAL;  // Define o preenchimento vertical.
        } else {  // Caso contrário, ocupa apenas horizontalmente.
            gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        }
        gbConstraints.gridy = row;  // Define a linha em que o componente ficará.
        gbConstraints.gridx = column;  // Define a coluna em que o componente ficará.
        gbConstraints.gridwidth = width;  // Define o número de colunas que o componente ocupará.
        gbConstraints.gridheight = height;  // Define o número de linhas que o componente ocupará.
        gbLayout.setConstraints(component, gbConstraints);  // Define as restrições de layout para o componente.
        add(component);  // Adiciona o componente à janela.
    }

    public static void popularCbxId() {  // Método para preencher a combo box com os Ids do banco de dados.
        try {
            Connection conexao = MySQLConnector.conectar();  // Estabelece a conexão com o banco de dados.
            String strSqlPopularCbxId = "select * from `db_senac`.`tbl_senac` order by `id` asc;";  // SQL para selecionar todos os Ids.
            Statement stmSqlPopularCbxId = conexao.createStatement();  // Cria um Statement para executar o SQL.
            ResultSet rstSqlPopularCbxId = stmSqlPopularCbxId.executeQuery(strSqlPopularCbxId);  // Executa a consulta.
            while (rstSqlPopularCbxId.next()) {  // Itera sobre os resultados da consulta.
                cbxId.addItem(rstSqlPopularCbxId.getString("id"));  // Adiciona os Ids à combo box.
            }
            stmSqlPopularCbxId.close();  // Fecha o Statement.
        } catch (Exception e) {  // Caso ocorra um erro ao preencher a combo box.
            lblNotificacoes.setText("Ops! Ocorreu um problema no servidor e não será possível carregar os ids neste momento. Por favor, retorne novamente mais tarde.");  // Notifica o erro ao usuário.
            System.err.println("Erro: " + e);  // Exibe o erro no console.
        }
    }

    public static void notificarUsuario(String str) {  // Método para notificar o usuário na interface gráfica.
        lblNotificacoes.setText(setHtmlFormat(str));  // Formata e define o texto de notificação.
    }

    public static String setHtmlFormat(String str) {  // Método para formatar o texto com HTML.
        return "<html><body>" + str + "</body></html>";  // Retorna o texto formatado.
    }

    public static void atualizarCampos(String strId) {  // Método para atualizar os campos com os dados de um Id específico.
        try {
            Connection conexao = MySQLConnector.conectar();  // Estabelece a conexão com o banco de dados.
            String strSqlAtualizarCampos = "select * from `db_senac`.`tbl_senac` where id = " + strId + ";";  // SQL para buscar os dados do Id.
            Statement stmSqlAtualizarCampos = conexao.createStatement();  // Cria um Statement para executar o SQL.
            ResultSet rstSqlAtualizarCampos = stmSqlAtualizarCampos.executeQuery(strSqlAtualizarCampos);  // Executa a consulta.
            if (rstSqlAtualizarCampos.next()) {  // Se encontrar o Id no banco.
                txtNome.setText(rstSqlAtualizarCampos.getString("nome"));  // Atualiza o campo "Nome".
                txtNomeCarregado = txtNome.getText();  // Armazena o nome carregado.
                txtEmail.setText(rstSqlAtualizarCampos.getString("email"));  // Atualiza o campo "Email".
                txtEmailCarregado = txtEmail.getText();  // Armazena o email carregado.
            } else {
                notificarUsuario("Id não encontrado.");  // Se não encontrar o Id, notifica o usuário.
            }
        } catch (Exception e) {  // Em caso de erro ao acessar o banco de dados.
            notificarUsuario("Ops! Problema no servidor. Tente novamente mais tarde.");  // Exibe erro ao usuário.
            System.err.println("Erro: " + e);  // Exibe o erro no console.
        }
    }

    public static TelaDeAtualizacao appTelaDeAtualizacao;  // Declara a instância da classe TelaDeAtualizacao.

    public static void main(String[] args) {  // Método principal para rodar a aplicação.
        appTelaDeAtualizacao = new TelaDeAtualizacao();  // Cria a instância da tela.
        appTelaDeAtualizacao.setDefaultCloseOperation(EXIT_ON_CLOSE);  // Define o comportamento ao fechar a janela.

        // O código comentado abaixo é para ouvir alterações no tamanho da janela, mas foi desativado.
        // appTelaDeAtualizacao.getRootPane().addComponentListener(
        //     new ComponentAdapter() {
        //         public void componentResized(ComponentEvent e) {
        //             int larguraTela = appTelaDeAtualizacao.getWidth();
        //             int alturaTela = appTelaDeAtualizacao.getHeight();
        //             notificarUsuario(String.format("Largura: %s, Altura: %s", larguraTela, alturaTela));
        //         }
        //     }
        // );
    }
}
