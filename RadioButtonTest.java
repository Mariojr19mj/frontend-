import javax.swing.JFrame; // Importa a classe JFrame, usada para criar uma janela gráfica

public class RadioButtonTest // Define a classe RadioButtonTest
{
   public static void main(String[] args) // Método principal que inicia a execução do programa
   {
      RadioButtonFrame radioButtonFrame = new RadioButtonFrame(); // Cria uma instância de RadioButtonFrame (uma janela
                                                                  // com botões de rádio)
      radioButtonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define que ao fechar a janela, o programa será
                                                                       // encerrado
      radioButtonFrame.setSize(300, 100); // Define o tamanho da janela como 300x100 pixels
      radioButtonFrame.setVisible(true); // Torna a janela visível para o usuário
   }
}
