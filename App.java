import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class App extends JFrame implements MouseListener {

    private static JTextField Password = new JTextField("Click GO to generate new password (check clipboard)", SwingConstants.CENTER);
    static JButton go = new JButton("GO!");
    static JTextField NrChars = new JTextField("10", SwingConstants.CENTER);
    static JLabel C = new JLabel("Please enter a valid number of characters:", SwingConstants.CENTER);

    JLabel nothing = new JLabel();

    App() {
        Password.setBounds(60, 10, 300, 50);
        Password.setEditable(false);
        Password.setForeground(Color.black);
        Password.setBackground(Color.white);
        Password.setFont(new Font("DialogInput", Font.BOLD, (int) 9.8));
        Password.setOpaque(true);
        Password.setVisible(true);

        C.setBounds(60, 70, 300, 20);
        C.setOpaque(true);
        C.setVisible(true);

        NrChars.setBounds(60, 100, 300, 50);
        NrChars.setEditable(true);
        NrChars.setForeground(Color.black);
        NrChars.setBackground(Color.white);
        NrChars.setFont(new Font("DialogInput", Font.BOLD, (int) 9.8));
        NrChars.setOpaque(true);
        NrChars.setVisible(true);

        go.setBounds((int) 117.5, 160, 185, 50);
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
        this.add(C);
        this.add(NrChars);
        this.add(nothing);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == go) {
            String RandPass = "";
            Random r = new Random();
            int chars = 10;
            try {
                chars = Integer.parseInt(NrChars.getText());
            } catch(Error err) {
                chars = 10;
            }

            String alphabet = "123456789abcdefghijklmnopqrstuvwxyz`/*-+.,<>?_=)(&^%$#@!";
            for (int i = 0; i < chars; i++) {
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
