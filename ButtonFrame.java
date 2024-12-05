import java.awt.FlowLayout; // Importa o layout de fluxo para organizar os componentes na janela
import java.awt.event.ActionEvent; // Importa a interface ActionListener para lidar com eventos de ação
import java.awt.event.ActionListener; // Importa a classe ActionEvent para representar os eventos de ação
import javax.swing.Icon; // Importa a classe JFrame para criar a janela
import javax.swing.ImageIcon; // Importa a classe JButton para criar botões
import javax.swing.JButton; // Importa a interface Icon para definir ícones
import javax.swing.JFrame; // Importa a classe ImageIcon para criar ícones a partir de imagens
import javax.swing.JOptionPane; // Importa JOptionPane para mostrar caixas de diálogo

public class ButtonFrame extends JFrame // Define a classe ButtonFrame que herda de JFrame
{
   private final JButton plainJButton; // Declara um botão simples que terá apenas texto
   private final JButton fancyJButton; // Declara um botão com ícones

   // ButtonFrame adiciona JButtons ao JFrame
   public ButtonFrame() 
   {
      super("Testing Buttons"); // Define o título da janela
      setLayout(new FlowLayout()); // Define o layout de fluxo para organizar os componentes

      plainJButton = new JButton("Plain Button"); // Cria um botão simples com texto
      add(plainJButton); // Adiciona o botão simples à janela

      Icon bug1 = new ImageIcon(getClass().getResource("bug1.gif")); // Cria um ícone a partir da imagem "bug1.gif"
      Icon bug2 = new ImageIcon(getClass().getResource("bug2.gif")); // Cria um ícone a partir da imagem "bug2.gif"
      fancyJButton = new JButton("Fancy Button", bug1); // Cria um botão com texto e um ícone inicial
      fancyJButton.setRolloverIcon(bug2); // Define o ícone que aparece quando o mouse passa sobre o botão
      add(fancyJButton); // Adiciona o botão com ícone à janela

      // Cria um novo objeto ButtonHandler para lidar com eventos de clique
      ButtonHandler handler = new ButtonHandler(); 
      fancyJButton.addActionListener(handler); // Adiciona o handler ao botão fancyJButton
      plainJButton.addActionListener(handler); // Adiciona o handler ao botão plainJButton
   }

   // Classe interna para lidar com eventos de botão
   private class ButtonHandler implements ActionListener 
   {
      // Método que lida com os eventos de clique
      @Override
      public void actionPerformed(ActionEvent event) 
      {
         // Exibe uma caixa de mensagem mostrando qual botão foi pressionado
         JOptionPane.showMessageDialog(ButtonFrame.this, String.format(
            "You pressed: %s", event.getActionCommand())); 
      }
   } 
} // Fim da classe ButtonFrame
