// Fig. 12.16: ButtonTest.java
// Testing ButtonFrame.
import javax.swing.JFrame;

public class ButtonTest //declaracao do botao teste
{ //inicio da chave bloco de nota Buttontest
   public static void main(String[] args) //declaracao do metodo main(executor)
   { // inicio da chave do metodo principal
      ButtonFrame buttonFrame = new ButtonFrame();  //declaracao de um tipo novo de arquivo da variavel ButtonFrame 
      buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //operacao de fechamento padrao
      buttonFrame.setSize(275, 110);  // opercao de definicao de tamanho (largura e altura)
      buttonFrame.setVisible(true); // deficicao de visibilidade, é a acao de mostrat a tela 
   }  //final da chave bo bloco de nota Buttontest
} // end class ButtonTest

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
