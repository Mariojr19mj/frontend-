import javax.swing.JFrame; // Importa a classe JFrame, usada para criar uma janela gráfica

public class ListTest  // Define a classe ListTest
{
   public static void main(String[] args)  // Método principal, ponto de entrada do programa
   { 
      ListFrame listFrame = new ListFrame(); // Cria uma instância da classe ListFrame (janela com JList de cores)
      listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define que, ao fechar a janela, o programa será encerrado
      listFrame.setSize(350, 150); // Define o tamanho da janela como 350x150 pixels
      listFrame.setVisible(true); // Torna a janela visível para o usuário
   } 
} // Fim da classe ListTest



