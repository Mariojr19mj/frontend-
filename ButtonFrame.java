// Fig. 12.15: ButtonFrame.java
// Command buttons and action events.
import java.awt.FlowLayout; //é a forma da  renderizacao da estrutura dos objetos
import java.awt.event.ActionListener;// (executador) é o que espera a cao 
import java.awt.event.ActionEvent;// captura de eventos das telas depois da acao 
import javax.swing.JFrame;// responsvel para aparecer toda estrutura da tela  pronta 
import javax.swing.JButton;// é os botoes que apara
import javax.swing.Icon;// responsavel por fornecer o icone na estrutura e seus tributos
import javax.swing.ImageIcon;// responsavel por carregar a imagem
import javax.swing.JOptionPane;// é a mensagem que aparece quando clica os botoes

// declaracao de classe "ButtonFrame" extends=herdou Jframe é que o Buttonframe esta recebendo
public class ButtonFrame extends JFrame 

{  // inicnio da chave de bloco de notas ButtonFrame

   //declaracao de variaveis é  botao com texto
   private final JButton plainJButton; // button with just text

   //declaracao da variavel é o botao com icone
   private final JButton fancyJButton; // button with icons

   // contrutor , o public faz o papel de exportacao usnado como nome do construtor o mesmo da classe
   public ButtonFrame()// ButtonFrame adds JButtons to JFrame

   {//inicio da chave 

      //é o definidor do titulo na estrutura
      super("Testing Buttons")
      // definir o layout, a saida das camadas
      setLayout(new FlowLayout()); 

      //declaracao da variavel plainbutton, definindo o nome do botao 
      plainJButton = new JButton("Plain Button"); // button with text
      // add o botao plainButton no jframe
      add(plainJButton); // add plainJButton to JFrame

      //é a imagem do tipo icon, atribuicao do objeto icon, o parametro getclaa:
      Icon bug1 = new ImageIcon(getClass().getResource("bug1.gif"));
      // enviando capturador de classe  que ira coletar um recurso da imagem propriamente dita
      Icon bug2 = new ImageIcon(getClass().getResource("bug2.gif"));

      //  envio do texto fancybutton 
      fancyJButton = new JButton("Fancy Button", bug1); // set image

      // invocando o metodo serroloveicon, (quando colocar o mouse em cima do icone ele ira fazer a animacao de trocar o bug1 e o bug2)
      fancyJButton.setRolloverIcon(bug2); // set rollover image

      //acao de adiconar na renderizacao
      add(fancyJButton); // add fancyJButton to JFrame

      // executador da operacao manual, 
      ButtonHandler handler = new ButtonHandler(); // create new ButtonHandler for button event handling 
      //escutardor de acho atravez do objeto handler
      fancyJButton.addActionListener(handler);
      //
      plainJButton.addActionListener(handler);
   }

   // inner class for button event handling
   private class ButtonHandler implements ActionListener 
   {
      // handle button event
      @Override
      public void actionPerformed(ActionEvent event)
      {
         JOptionPane.showMessageDialog(ButtonFrame.this, String.format(
            "You pressed: %s", event.getActionCommand()));
      }
   } 
} // end class ButtonFrame

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
