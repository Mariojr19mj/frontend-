import java.awt.*;
import java.awt.event.*;
import java.sql.*;


import javax.swing.*;

public class TelaDeLogin extends JFrame 
{
    private final JLabel labelLogin;
    private final JTextField textLogin;
    private final JLabel labelSenha;
    private final JPasswordField textSenha;
    private final JButton btnLogin;
    private final JLabel lblNotificacoes;


    public TelaDeLogin(){
    

    super("tela De Login");
    setLayout(new FlowLayout());

    labelLogin = new JLabel("lOGIN");
    add(labelLogin);

    textLogin = new JTextField(10);
    add(textLogin);

    labelSenha = new JLabel("SENHA");
    add(labelSenha);

    textSenha = new JPasswordField(10);
    add(textSenha);

    btnLogin = new JButton("LOGAR");
    add(btnLogin);

    lblNotificacoes = new JLabel("Notificacoes");
    add(lblNotificacoes);

    ButtonHandler buttonHandler = new ButtonHandler();
    btnLogin.addActionListener(buttonHandler);
    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event){
        // aqui sera invocado o metodo do logar
        }


    }

    public void logar() {  
       try{
      Connection conexao = MySQLConnector.conectar(); 
    String strdString = "select * from `db_senac`.`tbl_senac` where `email` = '" + textLogin.getText() + "'and `senha` = '" + String.valueOf(textSenha.getPassword()) + "';";

    Statement stmSqlLogin = conexao.createStatement();
    ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strdString);
    if  (rstSqlLogin.next()) { 
      lblNotificacoes.setText("Login realizado com sucesso");

    } else{
      lblNotificacoes.setText("Não foi possivel encontrar o login e/ou senha digitados. por favor, verifique e tente novamente");

    }

  } catch (Exception e) {
    lblNotificacoes.setText("houve um problema e não será possivel realizar o login neste momento. por favor, tente novamente mais tarde");
      System.err.println("Ops! Deu ruim, se liga no erro" + e);
  }
      
    }

public String setHtmlFormat(String txt) {
  return "<html><body>" + txt + "</body></html>";
}

public void notificarUsuarios(String strTexto) {
  lblNotificacoes.setText(setHtmlFormat(strTexto));
}

      
    
    




public static void main(String[] args) {

    TelaDeLogin telaDelogin = new TelaDeLogin();
    telaDelogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    telaDelogin.setSize(150,200);
    telaDelogin.setVisible(true);
}
}
