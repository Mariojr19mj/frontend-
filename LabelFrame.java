// Fig. 12.6: LabelFrame.java
// JLabels with text and icons.
// esta importando da biblioteca pacote java, e seus componentes
import java.awt.FlowLayout; // specifies how components are arranged
import javax.swing.JFrame; // provides basic window features
import javax.swing.JLabel; // displays text and images
import javax.swing.SwingConstants; // common constants used with Swing
import javax.swing.Icon; // interface used to manipulate images
import javax.swing.ImageIcon; // loads images

//esta declarando a classe labelframe com "extends" que esta herdando o componente jframe
public class LabelFrame extends JFrame
//iniciando a chave com bloco de codigos da classe LabelFrame, sao 3 linhas com declaracoes de variaveis de movo generico
{
//"private" significa que apenas o que esta dentro do bloco de notas pode ser ultilizado, e nao exporta variavel.
// "final" serve para declarar uma variavel somente leitura
// "Jlabel" é o tipo da variavel, é a variavel deuso exclusivo da clase, somente leitura e do tipo Jframe

   private final JLabel label1; // JLabel with just text
   private final JLabel label2; // JLabel constructed with text and icon
   private final JLabel label3; // JLabel with added text and icon

   // LabelFrame constructor adds JLabels to JFrame
   // é acao de construtor usando as variaveis da classe, ele traz as acoes organizadas.OBS:CONTRUTOR PRECISA TER O NOME DA CLASSE E O MESMO NOME DO ARQUIVO. 
   public LabelFrame()
   //inicio do bloco de notas do construtor, o "super" significa que estamos definindo o tipo da janela, declarando o titulo com aspas duplas.
   {
      super("Testing JLabel");
   // o "setLayout" vai definir o desenho das quadro, vai mostrar a saida das camadas
      setLayout(new FlowLayout()); // set frame layout
      // JLabel constructor with a string argument
      //label1 esta recebendo o novo objeto com "new" e declarando um testo
      label1 = new JLabel("Label with text");
      //estamos invocando"." difinindo um texto como parametro com ferramenta de dica, que aparecera quando por o mouse ficar em cima do elemento
      label1.setToolTipText("This is label1");
      //"add" é a acao de adicionar, esta adicionando o "label1 confome codigo acima" na saida de camada
      add(label1); // add label1 to JFrame

      // JLabel constructor with string, Icon and alignment arguments
      // declarando uma variavem do tipo Icon que esta recebendo uma variavel
// que é um valor de objeto do tipo imageicon, que estasendo enviado um parametro com metodos irao coletar a classe Labelframe e pegar o recurso "getrecurso" que é
// o o texto "bug.png"
      Icon bug = new ImageIcon(getClass().getResource("bug1.png"));
   // esta recebendo um novo objeto com "," que é um separador de parametros,usando o swingconstants que contem informaçoes sobre alinhamente que esta invocando a varivel LEFT que é o alinhamento do bug
      label2 = new JLabel("Label with text and icon", bug, 
         SwingConstants.LEFT);
      label2.setToolTipText("This is label2");
      add(label2); // add label2 to JFrame
   //declaracao de variavel esta recebendo um novo texto do Jlabel
      label3 = new JLabel(); // JLabel constructor no arguments
   //e a deficnicao do texto
      label3.setText("Label with icon and text at bottom");
   //e a definicao do icone reultilizando o mesmo objeto bug que a variavel
      label3.setIcon(bug); // add icon to JLabel
   //e a definicao do texto horizontal do texto como "center" traduzindo é o centro
      label3.setHorizontalTextPosition(SwingConstants.CENTER);
   //e a definicao do texto horizontal do texto como "BOTTOM" traduzindo é PRA BAIXO
      label3.setVerticalTextPosition(SwingConstants.BOTTOM);
   //e A DICA que é a acao onde o passamento do mouse em cima do texto ira trazer a dica
      label3.setToolTipText("This is label3");
      add(label3); // add label3 to JFrame
   } 
} // end class LabelFrame


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
