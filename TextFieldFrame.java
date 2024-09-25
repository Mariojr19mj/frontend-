// Fig. 12.9: TextFieldFrame.java
// JTextFields and JPasswordFields.
import java.awt.FlowLayout; //biblio
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class TextFieldFrame extends JFrame // declaracao da classe TextfieldFrame herdando o componete jframe
{// inicio do bloco textefieldframw
   //sao declaracoes de variavei, private é uso exclusivo da classe, 
   private final JTextField textField1; // text field with set size // 
   private final JTextField textField2; // text field with text
   private final JTextField textField3; // text field with text and size
   private final JPasswordField passwordField; // password field with text

   // TextFieldFrame constructor adds JTextFields to JFrame
   public TextFieldFrame() // public signica exporta, nesse caso esta exportando o cconstrutor
   { //inicio bloco de codigo do construtor
      super("Testing JTextField and JPasswordField");  // o super é definicao do titulo da janela
      setLayout(new FlowLayout());// é o tipo da saida das camadas, o que for renderizado primeito vai mandando na tela

      // construct textfield with 10 columns
      textField1 = new JTextField(10); // declaracao de variavel, porem como atribuicao, um novo objeto do construtor, trazendo as larguras das colunas 
      add(textField1); // add textField1 to JFrame// adicionando o texfield na renderizacao do quadro

      // construct textfield with default text
      textField2 = new JTextField("Enter text here"); // definicao de texto atribuindo o textfield a adicionando no frame
      add(textField2); // add textField2 to JFrame

      // construct textfield with default text and 21 columns
      textField3 = new JTextField("Uneditable text field", 21); // estamos atribuindo um noo textfiel com um texto,
      textField3.setEditable(false); // disable editing//é o metodo que vai definir que esse textfield nao seja editado
      add(textField3); // add textField3 to JFrame

      // construct passwordfield with default text
      passwordField = new JPasswordField("Hidden text"); //estamos atribuindo um novo objeto " Hidden text", 
      add(passwordField); // add passwordField to JFrame //adicionar na renderizacao do quadriho

      // register event handlers
      TextFieldHandler handler = new TextFieldHandler(); // handler é manuseador do campos textfield, esta declarando uma varivel atribuindo um construtor
      textField1.addActionListener(handler); //add um escutador de acao enviando o "handler"
      textField2.addActionListener(handler); //add um escutador de acao
      textField3.addActionListener(handler); //add um escutador de acao
      passwordField.addActionListener(handler); // 
   } // end TextFieldFrame constructor

   // private inner class for event handling
   private class TextFieldHandler implements ActionListener // esta injetando o objeto dentro da classe actionListener dentro da classe
   { //inicio do bloco da lasse TextFieldHandler
      // process textfield events
      @Override // subscrever por cima, reforca o sistema alterar o "@" é pra nao notificar os avisos tipo um alerta de perigo
      public void actionPerformed(ActionEvent event) //é metodo clarado que vem dentro do actionlistener, o actionperfomed sao os fatos que vao acontecer no bloco de codigo abaixo,e pra receber as informaçoes do é precito ter o parametro "event"
      { //
         String string = "";  // atribuicao da variavel com texto vazio
         // user pressed Enter in JTextField textField1
         if (event.getSource() == textField1) //o if é um algoritimo de validacao, ele permite realizaer as acoeds que tiver depois da linha dele, "==" é operador de comparacao, nessa compara ele pede para trazer algo verdadeiro
            string = String.format("textField1: %s", // string.format é  mtodo que vai entregar o texto formatado, 
               event.getActionCommand());//segundo parametro, siginifica pegar o comando da acao, no caso o texto

         // user pressed Enter in JTextField textField2
         else if (event.getSource() == textField2) //
            string = String.format("textField2: %s",
               event.getActionCommand());

         // user pressed Enter in JTextField textField3
         else if (event.getSource() == textField3)
            string = String.format("textField3: %s", 
               event.getActionCommand());

         // user pressed Enter in JTextField passwordField
         else if (event.getSource() == passwordField)
            string = String.format("passwordField: %s", 
               event.getActionCommand());

         // display JTextField content
         JOptionPane.showMessageDialog(null, string); // comando para exibir uma caixa de dialogo 
      } 
   } // end private inner class TextFieldHandler
} // end class TextFieldFrame

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
