// Fig. 12.10: TextFieldTest.java
// Testing TextFieldFrame.
import javax.swing.JFrame;  // esta importando o componete jframe do modo swing (blblioteca.modulo.componente)

public class TextFieldTest // declaracao da classe textfieldtext
{ // inicio do bloco de notas da classe textefieldtext
   public static void main(String[] args) // metodo executor main que é metodo principal
   {//inicio do bloco de notas do metodo
      TextFieldFrame textFieldFrame = new TextFieldFrame(); // 
      textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // declarando o metodo de definir o fechamento padrao buscando a bariavel EXIT ON CLOSE que esta dentro do JFRAME.
      textFieldFrame.setSize(350, 100); //DEFINICAO DO TAMANHO
      textFieldFrame.setVisible(true); // DEFINIR VISIBILIDADE, TRUE É VERDADEIRO
   }  //fim do bloco de codigo main
} // end class TextFieldTest // fim do codigo de bloco da classe

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
