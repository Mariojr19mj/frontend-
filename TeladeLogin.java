import java.out.swing.*;
import java.*;
import javax.swing.Jframe.*;
import awt.*;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeLogin extends jFrame{
    private final JLabel login;
    private final JTextfield TxtLogin;
    private final Jlabel Senha;
    private final jTestField txtSenha;
    private final jButton Btn;


public TelaDeLogin ()
{
    super(title:"Tela De Login");
    Setlayout(new FlowLayout());

    login = new Jlabel("Login")

    TxtLogin = new jTexfield(10);
     
    Senha = new jlabel("senha")

}

public static void main(String[] args)
{
    TelaDeLogin teladelogin = new TelaDeLogin();
    teladelogin.setDeFaultCloseOperatio(jFrame.EXIT_ON_CLOSE);

}