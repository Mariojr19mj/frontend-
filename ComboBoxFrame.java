import java.awt.FlowLayout; // Importa a classe FlowLayout, que organiza os componentes em linha
import java.awt.event.ItemListener; // Importa a interface ItemListener, usada para tratar eventos de seleção de itens
import java.awt.event.ItemEvent; // Importa a classe ItemEvent, que representa eventos de itens
import javax.swing.JFrame; // Importa a classe JFrame, usada para criar uma janela gráfica
import javax.swing.JLabel; // Importa a classe JLabel, usada para exibir um texto ou ícone
import javax.swing.JComboBox; // Importa a classe JComboBox, usada para criar um componente de lista suspensa
import javax.swing.Icon; // Importa a interface Icon, usada para representar ícones gráficos
import javax.swing.ImageIcon; // Importa a classe ImageIcon, usada para criar ícones a partir de imagens

public class ComboBoxFrame extends JFrame  // Define a classe ComboBoxFrame, que herda de JFrame
{
   private final JComboBox<String> imagesJComboBox; // Declara o JComboBox para armazenar os nomes das imagens
   private final JLabel label; // Declara o JLabel para exibir o ícone selecionado

   // Define um array de nomes de imagens (arquivos GIF)
   private static final String[] names = 
      {"bug1.gif", "bug2.gif",  "travelbug.gif", "buganim.gif"};
   // Define um array de ícones criados a partir dos arquivos de imagem
   private final Icon[] icons = { 
      new ImageIcon(getClass().getResource(names[0])), // Cria o ícone para o primeiro arquivo de imagem
      new ImageIcon(getClass().getResource(names[1])), // Cria o ícone para o segundo arquivo de imagem
      new ImageIcon(getClass().getResource(names[2])), // Cria o ícone para o terceiro arquivo de imagem
      new ImageIcon(getClass().getResource(names[3]))}; // Cria o ícone para o quarto arquivo de imagem

   // Construtor ComboBoxFrame adiciona o JComboBox à janela JFrame
   public ComboBoxFrame()
   {
      super("Testing JComboBox"); // Chama o construtor JFrame com o título "Testing JComboBox"
      setLayout(new FlowLayout()); // Define o layout da janela para FlowLayout (organiza os componentes em linha)

      imagesJComboBox = new JComboBox<String>(names); // Cria o JComboBox com os nomes das imagens
      imagesJComboBox.setMaximumRowCount(3); // Define que o JComboBox exibirá no máximo três linhas

      // Adiciona um ItemListener para tratar mudanças de seleção no JComboBox
      imagesJComboBox.addItemListener(
         new ItemListener() // Classe interna anônima que implementa ItemListener
         {
            // Trata o evento de seleção no JComboBox
            @Override
            public void itemStateChanged(ItemEvent event)
            {
               // Verifica se o item foi selecionado
               if (event.getStateChange() == ItemEvent.SELECTED)
                  label.setIcon(icons[  // Atualiza o ícone exibido no JLabel com base na seleção
                     imagesJComboBox.getSelectedIndex()]);
            } 
         } // Fim da classe interna anônima
      ); // Fim da chamada para addItemListener

      add(imagesJComboBox); // Adiciona o JComboBox à janela JFrame
      label = new JLabel(icons[0]); // Cria o JLabel com o primeiro ícone
      add(label); // Adiciona o JLabel à janela JFrame
   }
} // Fim da classe ComboBoxFrame
