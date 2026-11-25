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
        fondo.setLayout(null);
        setContentPane(fondo);

        JPanel caja = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setColor(new Color(0, 0, 0, 140));
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.dispose();
            }
        };
        caja.setOpaque(false);
        caja.setBounds(210, 8, 480, 555);
        fondo.add(caja);

        JLabel titulo = new JLabel("INICIAR SESIÓN", SwingConstants.CENTER);
        titulo.setOpaque(true);
        titulo.setBackground(cafe);
        titulo.setForeground(oro);
        titulo.setFont(new Font("Arial", Font.BOLD, 34));
        titulo.setBounds(0, 0, 480, 72);
        caja.add(titulo);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 18));
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setBounds(36, 92, 140, 28);
        caja.add(lblUsuario);

        usuario = new JTextField();
        usuario.setBounds(36, 122, 408, 40);
        usuario.setBackground(cafe);
        usuario.setForeground(Color.WHITE);
        usuario.setCaretColor(Color.WHITE);
        usuario.setFont(new Font("Arial", Font.PLAIN, 16));
        usuario.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        caja.add(usuario);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setFont(new Font("Arial", Font.BOLD, 18));
        lblPass.setForeground(Color.WHITE);
        lblPass.setBounds(36, 176, 180, 28);
        caja.add(lblPass);

        contrasena = new JPasswordField();
        contrasena.setBounds(36, 206, 348, 40);
        contrasena.setBackground(cafe);
        contrasena.setForeground(Color.WHITE);
        contrasena.setCaretColor(Color.WHITE);
        contrasena.setFont(new Font("Arial", Font.PLAIN, 16));
        contrasena.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        contrasena.setEchoChar('•');
        caja.add(contrasena);

        cargarOjo();
        ojo = new JButton(tachado);
        ojo.setBounds(392, 206, 52, 40);
        ojo.setBackground(cafe);
        ojo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        ojo.setFocusPainted(false);
        ojo.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        ojo.addActionListener(e -> verContrasena());
        caja.add(ojo);

        JButton iniciar = new JButton("Iniciar sesión");
        iniciar.setBounds(125, 285, 230, 48);
        estilo(iniciar);
        iniciar.addActionListener(e -> iniciar());
        caja.add(iniciar);

        JButton crear = new JButton("Crear Cuenta");
        crear.setBounds(125, 348, 230, 48);
        estilo(crear);
        crear.addActionListener(e -> crearCuenta());
        caja.add(crear);

        JButton salir = new JButton("Salir Aplicacion.");
        salir.setBounds(125, 411, 230, 48);
        estilo(salir);
        salir.addActionListener(e -> System.exit(0));
        caja.add(salir);

        setVisible(true);
    
        
}
    private void cargarOjo() {
        try {
            BufferedImage original = ImageIO.read(getClass().getResource("/cuttherope/imagenes/ver.png"));
            BufferedImage listo = new BufferedImage(26, 26, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = listo.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(original, 0, 0, 26, 26, null);
            g.dispose();
            normal = new ImageIcon(listo);

            BufferedImage cruz = new BufferedImage(26, 26, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = cruz.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawImage(listo, 0, 0, null);
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(3f));
            g2.drawLine(1, 1, 25, 25);
            g2.dispose();
            tachado = new ImageIcon(cruz);
        } catch (Exception ex) {
            normal = new ImageIcon();
            tachado = new ImageIcon();
        }
    }

    private void estilo(JButton b) {
        b.setFont(new Font("Arial", Font.BOLD, 18));
        b.setForeground(oro);
        b.setBackground(cafe);
        b.setOpaque(true);
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        b.setUI(new javax.swing.plaf.basic.BasicButtonUI());
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
