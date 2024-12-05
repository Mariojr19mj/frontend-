import java.awt.FlowLayout; // Importa o layout que organiza os componentes em uma linha (FlowLayout)
import java.awt.Color; // Importa a classe Color, usada para definir cores
import javax.swing.JFrame; // Importa a classe JFrame, usada para criar uma janela gráfica
import javax.swing.JList; // Importa a classe JList, usada para exibir uma lista de itens
import javax.swing.JScrollPane; // Importa a classe JScrollPane, usada para adicionar rolagem à lista
import javax.swing.event.ListSelectionListener; // Importa a interface ListSelectionListener, usada para tratar eventos de seleção
import javax.swing.event.ListSelectionEvent; // Importa a classe ListSelectionEvent, que representa o evento de seleção
import javax.swing.ListSelectionModel; // Importa a classe ListSelectionModel, usada para definir o modo de seleção da lista

public class ListFrame extends JFrame  // Define a classe ListFrame, que herda de JFrame
{
   private final JList<String> colorJList; // Declara o JList para exibir os nomes das cores
   // Define um array de nomes de cores
   private static final String[] colorNames = {"Black", "Blue", "Cyan",
      "Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
      "Orange", "Pink", "Red", "White", "Yellow"};
   // Define um array de cores correspondentes aos nomes das cores
   private static final Color[] colors = {Color.BLACK, Color.BLUE,
      Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, 
      Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, 
      Color.RED, Color.WHITE, Color.YELLOW};

   // Construtor ListFrame adiciona JScrollPane contendo o JList à janela JFrame
   public ListFrame()
   {
      super("List Test"); // Chama o construtor da classe JFrame com o título "List Test"
      setLayout(new FlowLayout()); // Define o layout da janela para FlowLayout (organiza os componentes em linha)

      colorJList = new JList<String>(colorNames); // Cria o JList usando o array de nomes de cores
      colorJList.setVisibleRowCount(5); // Define que 5 itens da lista serão visíveis ao mesmo tempo

      // Define o modo de seleção da lista para permitir apenas uma seleção por vez
      colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      // Adiciona o JScrollPane que contém o JList à janela
      add(new JScrollPane(colorJList));

      // Adiciona um ouvinte para tratar eventos de seleção da lista
      colorJList.addListSelectionListener(
         new ListSelectionListener() // Classe interna anônima que implementa ListSelectionListener
         {   
            // Trata o evento de seleção de itens da lista
            @Override
            public void valueChanged(ListSelectionEvent event)
            {
               // Muda a cor de fundo da janela para a cor correspondente ao item selecionado na lista
               getContentPane().setBackground(
                  colors[colorJList.getSelectedIndex()]); // Altera a cor de fundo com base na seleção
            } 
         } 
      ); 
   } 
} // Fim da classe ListFrame


