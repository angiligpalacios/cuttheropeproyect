/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuttherope;

/**
 *
 * @author ANGILI PALACIOS
 */
import cuttherope.excepciones.CamposVacios;
import cuttherope.excepciones.ContrasenaIncorrecta;
import cuttherope.excepciones.ErrorJuego;
import cuttherope.excepciones.UsuarioInexistente;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
public class Login extends JFrame{
    
private JTextField usuario;
    private JPasswordField contrasena;
    private JButton ojo;
    private ImageIcon normal, tachado;
    private boolean ver = false;  
    private final Color cafe = new Color(141, 94, 52);
    private final Color oro = new Color(232, 210, 80);
    public Login() {
        setTitle("Cut the Rope");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel fondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon img = new ImageIcon(getClass().getResource("/cuttherope/imagenes/Imagendefondo.jpg"));
                g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        
}
    private void verContrasena() {
        ver = !ver;
        if (ver) {
            contrasena.setEchoChar((char) 0);
            ojo.setIcon(normal);
        } else {
            contrasena.setEchoChar('•');
            ojo.setIcon(tachado);
        }
    }
    private void iniciar() {
    try {
        String user = usuario.getText().trim();
        String pass = new String(contrasena.getPassword());

        if (user.isEmpty() || pass.isEmpty()) {
            throw new CamposVacios();
        }

        if (!existe(user)) {
            throw new UsuarioInexistente();
        }

        if (!correcta(user, pass)) {
            throw new ContrasenaIncorrecta();
        }

        JOptionPane.showMessageDialog(this, "Bienvenido " + user);
        dispose();
    } catch (ErrorJuego ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
    }
}

    private void crearCuenta() {
        dispose();
    }

    private boolean existe(String user) {
        return true;
    }

    private boolean correcta(String user, String pass) {
        return true;
    }

}
