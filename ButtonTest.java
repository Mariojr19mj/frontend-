import javax.swing.JFrame; // Importa a classe JFrame para criar a janela da aplicação

public class ButtonTest // Define a classe ButtonTest
{
   public static void main(String[] args) // Método principal, ponto de entrada do programa
   {
      ButtonFrame buttonFrame = new ButtonFrame(); // Cria um objeto ButtonFrame (janela com botões)
      buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define que o programa será encerrado quando a
                                                                  // janela for fechada
      buttonFrame.setSize(275, 110); // Define o tamanho da janela para 275 pixels de largura e 110 pixels de altura
      buttonFrame.setVisible(true); // Torna a janela visível na tela
   }
} // Fim da classe ButtonTest
