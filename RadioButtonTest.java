// Fig. 12.20: RadioButtonTest.java
// Testing RadioButtonFrame.
import javax.swing.*; // importacao do modo generico, sendo assim da menos erro.

public class RadioButtonTest // puclic é uma declaracao de exportacao, class é a classe, depois da classe é o nome da classe, precisa ser o mesmo do arquivo
{
   public static void main(String[] args) //declaracao de método sendo main o principal, o metodo main ele vai executar o codigo, o void é o vazio sendo o tipo do retorno do metodo. String é o texto. os parenteses é o que vai definir o parametro dentro dele. colchetes [] é uma matriz do string. args é p nome do parametro
   { //é o inicio do bloco de codigo do metodo
      RadioButtonFrame radioButtonFrame = new RadioButtonFrame();//Radioobuttonframe é a declaracao do tipo, o radiobuttonframe do meio é o nome da varicel sendo o "r" minusculo. , = é a declaracao de varivel. new tem a acao de criar um novo objeto. o objeto vai ter o mesmo nome do tipo. 
      radioButtonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//radiobuttonframe é acao de chamar a variavel. "." é uma invocacao de método. "setdefaultcloseoperation" é o método de definicao de  operacao de fechamento padrao. jframe é o componente para inicializar o aplicativo. exit on close é a varivel 
      radioButtonFrame.setSize(300, 100); //radiobuttonframe é acao de chamar a variavel. "setsize" é o metodo de definicao de tamanho da tela. dentro parentese existe 2 parametro 
      radioButtonFrame.setVisible(true); //radiobuttonframe é acao de chamar a variavel."setvivible" 
   } // fechar o bloco de codigo do metodo
} //fechar o bloco de codigo da classe   end class RadioButtonTest 

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
