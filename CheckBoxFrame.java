import java.awt.FlowLayout; // Importa o layout de fluxo para organizar os componentes na janela
import java.awt.Font; // Importa a classe Font para manipular fontes de texto
import java.awt.event.ItemEvent; // Importa a interface ItemListener para lidar com eventos de item (checkbox)
import java.awt.event.ItemListener; // Importa a classe ItemEvent para representar os eventos de item
import javax.swing.JCheckBox; // Importa a classe JFrame para criar a janela
import javax.swing.JFrame; // Importa a classe JTextField para criar campos de texto
import javax.swing.JTextField; // Importa a classe JCheckBox para criar caixas de seleção

public class CheckBoxFrame extends JFrame // Define a classe CheckBoxFrame que herda de JFrame
{
   private final JTextField textField; // Declara um campo de texto para exibir texto com fontes variadas
   private final JCheckBox boldJCheckBox; // Declara uma caixa de seleção para negrito
   private final JCheckBox italicJCheckBox; // Declara uma caixa de seleção para itálico

   // Construtor da classe CheckBoxFrame adiciona JCheckBoxes ao JFrame
   public CheckBoxFrame() 
   {
      super("JCheckBox Test"); // Define o título da janela
      setLayout(new FlowLayout()); // Define o layout de fluxo para organizar os componentes

      // Configura o campo de texto e define sua fonte inicial
      textField = new JTextField("Watch the font style change", 20); // Cria o campo de texto com uma string inicial e largura de 20 caracteres
      textField.setFont(new Font("Serif", Font.PLAIN, 14)); // Define a fonte do campo de texto como "Serif", estilo normal e tamanho 14
      add(textField); // Adiciona o campo de texto à janela

      boldJCheckBox = new JCheckBox("Bold"); // Cria uma caixa de seleção para "Bold" (negrito)
      italicJCheckBox = new JCheckBox("Italic"); // Cria uma caixa de seleção para "Italic" (itálico)
      add(boldJCheckBox); // Adiciona a caixa de seleção para negrito à janela
      add(italicJCheckBox); // Adiciona a caixa de seleção para itálico à janela

      // Registra os ouvintes para as caixas de seleção
      CheckBoxHandler handler = new CheckBoxHandler(); // Cria um manipulador de eventos para as caixas de seleção
      boldJCheckBox.addItemListener(handler); // Adiciona o ouvinte à caixa de seleção para negrito
      italicJCheckBox.addItemListener(handler); // Adiciona o ouvinte à caixa de seleção para itálico
   } 

   // Classe interna privada para manipulação de eventos de ItemListener
   private class CheckBoxHandler implements ItemListener 
   {
      // Responde aos eventos das caixas de seleção
      @Override
      public void itemStateChanged(ItemEvent event) 
      {
         Font font = null; // Declara uma variável para armazenar a nova fonte

         // Determina quais caixas de seleção estão marcadas e cria a fonte correspondente
         if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected()) // Se ambas as caixas estiverem marcadas
            font = new Font("Serif", Font.BOLD + Font.ITALIC, 14); // Cria uma fonte em negrito e itálico
         else if (boldJCheckBox.isSelected()) // Se apenas a caixa de negrito estiver marcada
            font = new Font("Serif", Font.BOLD, 14); // Cria uma fonte em negrito
         else if (italicJCheckBox.isSelected()) // Se apenas a caixa de itálico estiver marcada
            font = new Font("Serif", Font.ITALIC, 14); // Cria uma fonte em itálico
         else // Se nenhuma caixa estiver marcada
            font = new Font("Serif", Font.PLAIN, 14); // Cria uma fonte normal (sem negrito ou itálico)

         textField.setFont(font); // Define a nova fonte para o campo de texto
      } 
   }
} // Fim da classe CheckBoxFrame
