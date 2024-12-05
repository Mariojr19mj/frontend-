import java.awt.FlowLayout; // Importa o layout de fluxo, que organiza os componentes em linha
import java.awt.Font; // Importa a classe Font, usada para definir fontes
import java.awt.event.ItemEvent; // Importa o ItemListener, interface para ouvir mudanças em itens
import java.awt.event.ItemListener; // Importa a classe ItemEvent, que representa eventos de itens
import javax.swing.ButtonGroup; // Importa a classe JFrame, que cria uma janela para o aplicativo gráfico
import javax.swing.JFrame; // Importa a classe JTextField, usada para criar um campo de texto
import javax.swing.JRadioButton; // Importa a classe JRadioButton, usada para criar botões de rádio
import javax.swing.JTextField; // Importa a classe ButtonGroup, usada para agrupar botões de rádio

public class RadioButtonFrame extends JFrame  // Define a classe RadioButtonFrame que herda de JFrame
{
   private JTextField textField; // Declara um campo de texto usado para exibir mudanças de fonte
   private Font plainFont; // Declara uma fonte para texto normal
   private Font boldFont; // Declara uma fonte para texto em negrito
   private Font italicFont; // Declara uma fonte para texto em itálico
   private Font boldItalicFont; // Declara uma fonte para texto em negrito e itálico
   private JRadioButton plainJRadioButton; // Declara o botão de rádio para texto normal
   private JRadioButton boldJRadioButton; // Declara o botão de rádio para texto em negrito
   private JRadioButton italicJRadioButton; // Declara o botão de rádio para texto em itálico
   private JRadioButton boldItalicJRadioButton; // Declara o botão de rádio para texto em negrito e itálico
   private ButtonGroup radioGroup; // Declara um grupo de botões para agrupar os botões de rádio

   // Construtor da classe RadioButtonFrame, que adiciona os JRadioButtons à janela JFrame
   public RadioButtonFrame()
   {
      super("RadioButton Test"); // Chama o construtor de JFrame com o título "RadioButton Test"
      setLayout(new FlowLayout()); // Define o layout da janela para FlowLayout (organiza os componentes em linha)

      textField = new JTextField("Watch the font style change", 25); // Cria um campo de texto com a mensagem inicial
      add(textField); // Adiciona o campo de texto à janela JFrame

      // Cria os botões de rádio para diferentes estilos de fonte
      plainJRadioButton = new JRadioButton("Plain", true); // Cria o botão de rádio para texto normal (marcado por padrão)
      boldJRadioButton = new JRadioButton("Bold", false); // Cria o botão de rádio para texto em negrito (não marcado por padrão)
      italicJRadioButton = new JRadioButton("Italic", false); // Cria o botão de rádio para texto em itálico (não marcado por padrão)
      boldItalicJRadioButton = new JRadioButton("Bold/Italic", false); // Cria o botão de rádio para texto em negrito e itálico (não marcado por padrão)
      add(plainJRadioButton); // Adiciona o botão de rádio para texto normal à janela
      add(boldJRadioButton); // Adiciona o botão de rádio para texto em negrito à janela
      add(italicJRadioButton); // Adiciona o botão de rádio para texto em itálico à janela
      add(boldItalicJRadioButton); // Adiciona o botão de rádio para texto em negrito e itálico à janela

      // Cria um grupo lógico entre os JRadioButtons
      radioGroup = new ButtonGroup(); // Cria um novo ButtonGroup
      radioGroup.add(plainJRadioButton); // Adiciona o botão de texto normal ao grupo
      radioGroup.add(boldJRadioButton); // Adiciona o botão de texto em negrito ao grupo
      radioGroup.add(italicJRadioButton); // Adiciona o botão de texto em itálico ao grupo
      radioGroup.add(boldItalicJRadioButton); // Adiciona o botão de texto em negrito e itálico ao grupo

      // Cria objetos Font para os diferentes estilos de texto
      plainFont = new Font("Serif", Font.PLAIN, 14); // Cria a fonte normal com tamanho 14
      boldFont = new Font("Serif", Font.BOLD, 14); // Cria a fonte em negrito com tamanho 14
      italicFont = new Font("Serif", Font.ITALIC, 14); // Cria a fonte em itálico com tamanho 14
      boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14); // Cria a fonte em negrito e itálico com tamanho 14
      textField.setFont(plainFont); // Define a fonte do campo de texto como a fonte normal

      // Registra os eventos dos JRadioButtons
      plainJRadioButton.addItemListener(
         new RadioButtonHandler(plainFont)); // Registra um ItemListener para o botão de texto normal
      boldJRadioButton.addItemListener(
         new RadioButtonHandler(boldFont)); // Registra um ItemListener para o botão de texto em negrito
      italicJRadioButton.addItemListener(
         new RadioButtonHandler(italicFont)); // Registra um ItemListener para o botão de texto em itálico
      boldItalicJRadioButton.addItemListener(
         new RadioButtonHandler(boldItalicFont)); // Registra um ItemListener para o botão de texto em negrito e itálico
   } 

   // Classe privada interna para tratar eventos dos botões de rádio
   private class RadioButtonHandler implements ItemListener 
   {
      private Font font; // Fonte associada a este listener

      public RadioButtonHandler(Font f)
      {
         font = f; // Inicializa a fonte com o valor passado no construtor
      } 
   
      // Trata os eventos de mudança nos botões de rádio
      @Override
      public void itemStateChanged(ItemEvent event)
      {
         textField.setFont(font); // Altera a fonte do campo de texto para a fonte associada
      } 
   } 
} // Fim da classe RadioButtonFrame

