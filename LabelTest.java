// Fig. 12.7: LabelTest.java
// Testing LabelFrame.
// A linha abaixo importara o componente jframe do modulo swing da biblioteca (pacote) javax
import javax.swing.JFrame;
// A linha baixo esta declarando a classe labeltest
public class LabelTest
 //...
{
//...
// a linha abaixo esta declarando o metodo main
   public static void main(String[] args)
//...
{ 
//  esta linha de codigo esta declarando uma linha de codido labelframe, do tipo labelframe, toda vez que tem um "nem" voce esta atribuindo um novo objeto, camelkase
      LabelFrame labelFrame = new LabelFrame(); 
//esta linha de codigo esta invocando com "." pra direita, definicao de padrao de fechamento operação, dentro do parenteses tem parametros "EXIT_ON_CLOSE"(PADRAO SKIN_CASE) que é um numero que esta definido na interface deese componente, acha de sair ao fechar."
      labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//esta linha de codigo ESTASETANDO, QUE É DEFINIR O TAMANHO COM "SETSIZE" COM UNIDADES DE MEDIDAS PADRAO PIXEL
      labelFrame.setSize(260, 180); 
//esta linha de codigo ESTA COM A ACAO DE TORNAR VISIVEL NA TELA COM a opcao  "setVisible", mostrando com o metodo verdadeiro "true"
      labelFrame.setVisible(true); 
   } 
// enceramento de codigo da classe

} // end class LabelTest



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
