import javax.swing.JFrame; // Importa a classe JFrame para criar a janela da aplicação

public class CheckBoxTest // Define a classe CheckBoxTest
{
   public static void main(String[] args) // Método principal, ponto de entrada do programa
   { 
      CheckBoxFrame checkBoxFrame = new CheckBoxFrame(); // Cria um objeto CheckBoxFrame (janela com caixas de seleção)
      checkBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define que o programa será encerrado quando a janela for fechada
      checkBoxFrame.setSize(275, 100); // Define o tamanho da janela para 275 pixels de largura e 100 pixels de altura
      checkBoxFrame.setVisible(true); // Torna a janela visível na tela
   } 
} // Fim da classe CheckBoxTest

