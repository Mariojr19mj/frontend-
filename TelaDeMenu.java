import java.awt.*; // Importa pacotes para manipulação de layouts e componentes gráficos (como BorderLayout, etc.)
import java.awt.event.*; // Importa pacotes para manipulação de eventos, como ActionListener
import javax.swing.*; // Importa componentes gráficos do Swing (como JFrame, JMenu, JMenuItem, etc.)

public class TelaDeMenu extends JFrame { // Define a classe TelaDeMenu que herda de JFrame (janela gráfica)
    private final JMenu cadastroMenu; // Declara um JMenu chamado cadastroMenu para o menu "Cadastro"
    private final JLabel lblNomeDaTela; // Declara um JLabel para exibir o nome da tela
    private final JMenuBar menuBar; // Declara a barra de menu
    private final JMenuItem novoItem; // Declara o item "Novo" no menu
    private final JMenuItem pesquisarItem; // Declara o item "Pesquisar" no menu
    private final JMenuItem atualizarItem; // Declara o item "Atualizar" no menu
    private final JMenuItem removerItem; // Declara o item "Remover" no menu

    public TelaDeMenu() { // Construtor da classe TelaDeMenu
        super("Tela de Menu"); // Define o título da janela como "Tela de Menu"

        cadastroMenu = new JMenu("Cadastro"); // Cria o menu "Cadastro"
        lblNomeDaTela = new JLabel("Tela de Menu", SwingConstants.CENTER); // Cria um JLabel com o texto "Tela de Menu", alinhado no centro
        menuBar = new JMenuBar(); // Cria uma barra de menu

        novoItem = new JMenuItem("Novo"); // Cria um item de menu "Novo"
        pesquisarItem = new JMenuItem("Pesquisar"); // Cria um item de menu "Pesquisar"
        atualizarItem = new JMenuItem("Atualizar"); // Cria um item de menu "Atualizar"
        removerItem = new JMenuItem("Remover"); // Cria um item de menu "Remover"

        cadastroMenu.add(novoItem); // Adiciona o item "Novo" ao menu "Cadastro"
        cadastroMenu.add(pesquisarItem); // Adiciona o item "Pesquisar" ao menu "Cadastro"
        cadastroMenu.add(atualizarItem); // Adiciona o item "Atualizar" ao menu "Cadastro"
        cadastroMenu.add(removerItem); // Adiciona o item "Remover" ao menu "Cadastro"

        menuBar.add(cadastroMenu); // Adiciona o menu "Cadastro" à barra de menu

        setJMenuBar(menuBar); // Define a barra de menu da janela com o menuBar

        add(lblNomeDaTela, BorderLayout.CENTER); // Adiciona o JLabel de nome da tela no centro da janela (usando BorderLayout)

        // Define o que ocorre quando o item "Novo" é clicado
        novoItem.addActionListener(
            new ActionListener() { // Cria um ActionListener anônimo
                @Override
                public void actionPerformed(ActionEvent event) { // Método chamado quando o item é clicado
                    JOptionPane.showMessageDialog(null,"Você clicou no menu: " + event.getActionCommand()); // Exibe uma mensagem de alerta com o comando acionado
                }
            }
        );

        // Define o que ocorre quando o item "Pesquisar" é clicado
        pesquisarItem.addActionListener(
            new ActionListener() { // Cria um ActionListener anônimo
                @Override
                public void actionPerformed(ActionEvent event) { // Método chamado quando o item é clicado
                    JOptionPane.showMessageDialog(null,"Você clicou no menu: " + event.getActionCommand()); // Exibe uma mensagem de alerta com o comando acionado
                }
            }
        );

        // Define o que ocorre quando o item "Atualizar" é clicado
        atualizarItem.addActionListener(
            new ActionListener() { // Cria um ActionListener anônimo
                @Override
                public void actionPerformed(ActionEvent event) { // Método chamado quando o item é clicado
                    JOptionPane.showMessageDialog(null,"Você clicou no menu: " + event.getActionCommand()); // Exibe uma mensagem de alerta com o comando acionado
                }
            }
        );

        // Define o que ocorre quando o item "Remover" é clicado
        removerItem.addActionListener(
            new ActionListener() { // Cria um ActionListener anônimo
                @Override
                public void actionPerformed(ActionEvent event) { // Método chamado quando o item é clicado
                    JOptionPane.showMessageDialog(null,"Você clicou no menu: " + event.getActionCommand()); // Exibe uma mensagem de alerta com o comando acionado
                }
            }
        );
    }

    public static void main(String[] args) { // Método principal para iniciar a aplicação
        TelaDeMenu appTelaDeMenu = new TelaDeMenu(); // Cria uma instância da TelaDeMenu
        appTelaDeMenu.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define a ação ao fechar a janela: encerrar o programa
        appTelaDeMenu.setSize(200,200); // Define o tamanho da janela (200x200 pixels)
        appTelaDeMenu.setVisible(true); // Torna a janela visível para o usuário
    }
}
