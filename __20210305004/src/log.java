import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

interface Authenticator {
    boolean authenticate(String username, String password);
}

class DefaultAuthenticator implements Authenticator {
    private static final String PREDEFINED_USERNAME = "account1";
    private static final String PREDEFINED_PASSWORD = "pass1";

    @Override
    public boolean authenticate(String username, String password) {
        return username.equals(PREDEFINED_USERNAME) && password.equals(PREDEFINED_PASSWORD);
    }
}

public class log extends JFrame implements ActionListener {

    private JFrame frame = new JFrame();
    private JButton loginButton = new JButton("Login");
    private JTextField user = new JTextField();
    private JPasswordField pass = new JPasswordField();
    private JLabel userIDLabel = new JLabel("Username:");
    private JLabel userPasswordLabel = new JLabel("Password:");
    private JLabel messageLabel = new JLabel();
    private JLabel messageLabel3 = new JLabel();
    private JLabel messageLabel2 = new JLabel("(Username is 'account1' and password is 'pass1'.)");
    private JLabel messageLabel1 = new JLabel("Welcome, please login to the system down below.");
    private JLabel loginfotosu = new JLabel();
    private Authenticator authenticator = new DefaultAuthenticator();

    log() {
        userIDLabel.setBounds(139, 311, 100, 100);
        userPasswordLabel.setBounds(140, 361, 100, 100);

        messageLabel.setBounds(200, 422, 250, 35);
        messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

        messageLabel3.setBounds(410, 393, 250, 35);
        messageLabel3.setFont(new Font("Tahoma", Font.PLAIN, 15));

        messageLabel2.setBounds(190, 535, 450, 35);
        messageLabel2.setFont(new Font("Tahoma", Font.PLAIN, 10));

        ImageIcon loginfoto = new ImageIcon("logo1.png");
        loginfotosu.setIcon(loginfoto);
        loginfotosu.setOpaque(true);
        loginfotosu.setVisible(true);
        loginfotosu.setHorizontalTextPosition(JLabel.CENTER);
        loginfotosu.setVerticalTextPosition(JLabel.BOTTOM);
        loginfotosu.setBounds(150, 0, 300, 300);

        messageLabel1.setBounds(100, 290, 500, 35);
        messageLabel1.setFont(new Font("Tahoma", Font.PLAIN, 18));

        JLabel[] messages = {messageLabel, messageLabel1, messageLabel2, messageLabel3};

        user.setBounds(205, 350, 200, 25);
        pass.setBounds(205, 400, 200, 25);

        loginButton.setBounds(250, 455, 100, 25);
        loginButton.addActionListener(
                (e) -> {
                    String enteredUsername = user.getText();
                    String enteredPassword = pass.getText();
                    if (authenticator.authenticate(enteredUsername, enteredPassword)) {
                        frame.dispose();
                        new thepage();
                    } else {
                        this.messageLabel3.setForeground(Color.red);
                        this.messageLabel3.setText("");
                        this.messageLabel.setForeground(Color.red);
                        this.messageLabel.setText("Username or password is wrong!");
                    }
                }
        );
        loginButton.setFocusable(false);
        loginButton.setBackground(Color.WHITE);

        ImageIcon littleicon = new ImageIcon("logo1.jpg");

        frame.setTitle("Clothing Boutique Inventory System");
        frame.add(loginfotosu);
        frame.add(messages[3]);
        frame.add(messages[2]);
        frame.add(messages[1]);
        frame.add(loginButton);
        frame.add(user);
        frame.add(pass);
        frame.add(messages[0]);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setIconImage(littleicon.getImage());
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new log();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
