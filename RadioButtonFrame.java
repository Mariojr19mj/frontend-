// Fig. 12.19: RadioButtonFrame.java
// Creating radio buttons using ButtonGroup and JRadioButton.
// import é a importacao. os verde sao os componentes
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class RadioButtonFrame extends JFrame //declaracao de classe. extends significa que esta erdando. o radiobuttonfram esta erdando tudo que estiver no jframe
{
   private JTextField textField; // privat significa ser exclusivo dentro de classe. jtextfield é uma varivel.
   private Font plainFont; // font for plain text
   private Font boldFont; // font for bold text
   private Font italicFont; // font for italic text
   private Font boldItalicFont; // font for bold and italic text

   private Color blackColor; // Color for plain text
   private Color redColor; // Color for bold text
   private Color bluecColor; // Color for italic text
   private Color yellowColor;


   private JRadioButton blackJRadioButton; // selects plain text
   private JRadioButton redJRadioButton; // selects bold text
   private JRadioButton blueJRadioButton; // selects italic text
   private JRadioButton yellowJRadioButton; // bold and italic

   private JRadioButton plainJRadioButton; // selects plain text
   private JRadioButton boldJRadioButton; // selects bold text
   private JRadioButton italicJRadioButton; // selects italic text
   private JRadioButton boldItalicJRadioButton; // bold and italic
   private ButtonGroup radioGroup; // buttongroup to hold radio buttons
   private  ButtonGroup coloRadioGroup;

   // RadioButtonFrame constructor adds JRadioButtons to JFrame
   public RadioButtonFrame() // declaracao do construtor
   {//abertura do bloco de codigo do construtor
      super("RadioButton Test");// super é o texto principal na aba de cima da janela
      setLayout(new FlowLayout()); // setlayout e um metodo dentro da classe jframe, o set vaid definir o tipo de layout, é a saida das camadas com um novo objeto que é o flowlayout

      textField = new JTextField("Watch the font style change", 25);// declaracao do textfield, com o new criamos o obejto, com parametros de 
      add(textField);
      
      // create radio buttons
      plainJRadioButton = new JRadioButton("Plain", true);
      boldJRadioButton = new JRadioButton("Bold", false);
      italicJRadioButton = new JRadioButton("Italic", false);
      boldItalicJRadioButton = new JRadioButton("Bold/Italic", false);
      add(plainJRadioButton); // add plain button to JFrame
      add(boldJRadioButton); // add bold button to JFrame
      add(italicJRadioButton); // add italic button to JFrame
      add(boldItalicJRadioButton); // add bold and italic button

      // create logical relationship between JRadioButtons
      radioGroup = new ButtonGroup(); // create ButtonGroup
      radioGroup.add(plainJRadioButton); // add plain to group
      radioGroup.add(boldJRadioButton); // add bold to group
      radioGroup.add(italicJRadioButton); // add italic to group
      radioGroup.add(boldItalicJRadioButton); // add bold and italic

      // create font objects
      plainFont = new Font("Serif", Font.PLAIN, 14);
      boldFont = new Font("Serif", Font.BOLD, 14);
      italicFont = new Font("Serif", Font.ITALIC, 14);
      boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
      textField.setFont(plainFont);

      // register events for JRadioButtons
      plainJRadioButton.addItemListener(
         new RadioButtonHandler(plainFont));
      boldJRadioButton.addItemListener(
         new RadioButtonHandler(boldFont));
      italicJRadioButton.addItemListener(
         new RadioButtonHandler(italicFont));
      boldItalicJRadioButton.addItemListener(
         new RadioButtonHandler(boldItalicFont));

      blackJRadioButton = new JRadioButton("Black", true);
      redJRadioButton = new JRadioButton("Red", false);
      blueJRadioButton = new JRadioButton("Blue", false);
      yellowJRadioButton = new JRadioButton("Yellow", false);
      add(blackJRadioButton); // add plain button to JFrame
      add(redJRadioButton); // add bold button to JFrame
      add(blueJRadioButton); // add italic button to JFrame
      add(yellowJRadioButton); // add bold and italic button

      // create logical relationship between JRadioButtons
      coloRadioGroup = new ButtonGroup(); // create ButtonGroup
      coloRadioGroup.add(blackJRadioButton); // add plain to group
      coloRadioGroup.add(redJRadioButton); // add bold to group
      coloRadioGroup.add(blueJRadioButton); // add italic to group
      coloRadioGroup.add(yellowJRadioButton); // add bold and italic

      // create font objects
      blackColor = Color.BLACK;
      redColor = Color.RED;
      bluecColor = Color.BLUE;
      yellowColor = Color.YELLOW;
      textField.setForeground(blackColor);

      // register events for JRadioButtons
      blackJRadioButton.addItemListener(
         new ColorRadioButtonHandler(blackColor));
      redJRadioButton.addItemListener(
         new ColorRadioButtonHandler(redColor));
      blueJRadioButton.addItemListener(
         new ColorRadioButtonHandler(bluecColor));
      yellowJRadioButton.addItemListener(
         new ColorRadioButtonHandler(yellowColor));
   }  

   // private inner class to handle radio button events
   private class ColorRadioButtonHandler implements ItemListener 
   {
      private Font font; // font associated with this listener

      public RadioButtonHandler(Font f)
      {
         font = f; 
      } 
   
      // handle radio button events
      @Override
      public void itemStateChanged(ItemEvent event)
      {
         textField.setFont(font); 
      } 
   } 
} // end class RadioButtonFrame 

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
