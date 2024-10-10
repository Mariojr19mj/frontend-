// Fig. 12.25: MultipleSelectionFrame.java
// JList that allows multiple selections.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MultipleSelectionFrame extends JFrame // 
{
   private final JList<String> colorJList; // list to hold color names//
   private final JList<String> copyJList; // list to hold copied names
   private JButton copyJButton; // button to copy selected names
   private static final String[] colorNames = {"Black", "Blue", "Cyan",
      "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", 
      "Pink", "Red", "White", "Yellow"};
   private final JList<String> frutJList; // list to hold color names//
   private final JList<String> copyFrutJList; // list to hold copied names
   private JButton copyFrutJButton2; // button to copy selected names
   private static final string[] frutNames = {"maça", "banana", "uva","pessego"}
    
   // MultipleSelectionFrame constructor
   public MultipleSelectionFrame()
   {
      super("Multiple Selection Lists");
      setLayout(new FlowLayout());

      colorJList = new JList<String>(colorNames); // list of color names
      colorJList.setVisibleRowCount(5); // show five rows
      colorJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      add(new JScrollPane(colorJList)); // add list with scrollpane

      copyJButton = new JButton("Copy >>>"); 
      copyJButton.addActionListener(
         new ActionListener() // anonymous inner class 
         {  
            // handle button event
            @Override//subescrever
            public void actionPerformed(ActionEvent event) // 
            {
               // place selected values in copyJList
               copyJList.setListData(// configurar dados da lista 
                  colorJList.getSelectedValuesList().toArray( // to array se remete a conversao 
                     new String[0]));
            }
         } 
      ); 

      add(copyJButton); // add copy button to JFrame

      copyJList = new JList<String>(); // declaracao de um novo objeto, dentro da matriz de string
      copyJList.setVisibleRowCount(5); // mostra a quantidade de linhas 
      copyJList.setFixedCellWidth(100); // efinicao da largura da celular fixada  set height
      copyJList.setFixedCellHeight(15); //definicao da altura da celular fixada  set height
      copyJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); // definicao do modo de seleção, o single_inter.... unico intervalo de selecao.  o listselectionmoldel é um modelo de lista
      add(new JScrollPane(copyJList)); // add list with scrollpane

      frutJList = new JList<String>(frutNames); // list of color names
      frutJList.setVisibleRowCount(5); // show five rows
      frutJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      add(new JScrollPane(frutJList)); // add list with scrollpane

      copyJButton2 = new JButton("Copy >>>"); 
      copyJButton2.addActionListener(
         new ActionListener() // anonymous inner class 
         {  
            // handle button event
            @Override//subescrever
            public void actionPerformed(ActionEvent event); // 
            {
               // place selected values in copyJList
               copyJList2.setListData(// configurar dados da lista 
              frutJList.getSelectedValuesList().toArray( // to array se remete a conversao 
                     new String[0]));
            }
         } 
      )

      add(copyJButton2); // add copy button to JFrame

      copyJList2 = new JList<String>(); // declaracao de um novo objeto, dentro da matriz de string
      copyJList2.setVisibleRowCount(5); // mostra a quantidade de linhas 
      copyJList2.setFixedCellWidth(100); // efinicao da largura da celular fixada  set height
      copyJList2.setFixedCellHeight(15); //definicao da altura da celular fixada  set height
      copyJList2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); // definicao do modo de seleção, o single_inter.... unico intervalo de selecao.  o listselectionmoldel é um modelo de lista
      add(new JScrollPane(copyJList2));


   } 
} // end class MultipleSelectionFrame


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
