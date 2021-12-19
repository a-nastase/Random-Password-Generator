import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class App extends JFrame implements MouseListener {

    private static JTextField Password = new JTextField("Click GO to generate new password (check clipboard)", SwingConstants.CENTER);
    static JButton go = new JButton("GO!");

    JLabel nothing = new JLabel();

    App() {
        Password.setBounds(60, 10, 300, 50);
        Password.setEditable(false);
        Password.setForeground(Color.black);
        Password.setBackground(Color.white);
        Password.setFont(new Font("DialogInput", Font.BOLD, (int) 9.8));
        Password.setOpaque(true);
        Password.setVisible(true);

        go.setBounds((int) 117.5, 80, 185, 50);
        go.setOpaque(true);
        go.setVisible(true);
        go.addMouseListener(this);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(420, 280);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Random Password Generator");

        this.add(go);
        this.add(Password);
        this.add(nothing);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == go) {
            String RandPass = "";
            Random r = new Random();

            String fn = "45";
            int Char1 = fn.charAt(r.nextInt(fn.length()));
            String sn = "1234567890";
            int Char2 = sn.charAt(r.nextInt(sn.length()));
            int chars = (Char1 * 10) + Char2;

            String alphabet = "123456789abcdefghijklmnopqrstuvwxyz`/*-+.,<>?_=)(&^%$#@!";
            for (int i = 0; i < Math.random() * chars; i++) {
                RandPass = alphabet.charAt(r.nextInt(alphabet.length())) + RandPass;
            }

            Password.setText(RandPass);

            Toolkit.getDefaultToolkit()
                    .getSystemClipboard()
                    .setContents(
                            new StringSelection(Password.getText()),
                            null
                    );
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
