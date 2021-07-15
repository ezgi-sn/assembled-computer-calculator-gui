package AssembledComputerProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class LoginScreen extends JFrame {
    private final JTextField usernameText;
    private final JPasswordField passwordText;
    int ghost_white = 0xF8F8FF;
    int light_grey = 0x778899;
    int light_green = 0xA2D9CE;
    public LoginScreen() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel signInPanel = new JPanel();
        JLabel usernameLabel = new JLabel("username: ");
        usernameText = new JTextField(15);
        JLabel passwordLabel = new JLabel("password: ");
        passwordText = new JPasswordField(15);
        JButton signInButton = new JButton("sign in");
        JButton signUpButton = new JButton("sign up");

        JLabel welcomeLabel = new JLabel("  Welcome To Assembler!  ");
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon("AssembledComputerProject/icons/computer.png");
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(100, 80, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        welcomeLabel.setIcon(icon);
        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);
        ImageIcon loginIcon = new ImageIcon("AssembledComputerProject/icons/login.png");
        Image loginImage = loginIcon.getImage();
        Image scaledLogin = loginImage.getScaledInstance(12, 12, Image.SCALE_SMOOTH);
        loginIcon = new ImageIcon(scaledLogin);
        signInButton.setIcon(loginIcon);
        ImageIcon signupIcon = new ImageIcon("AssembledComputerProject/icons/signup.png");
        Image signupImage = signupIcon.getImage();
        Image scaledSignup = signupImage.getScaledInstance(12, 12, Image.SCALE_SMOOTH);
        signupIcon = new ImageIcon(scaledSignup);
        signUpButton.setIcon(signupIcon);
        signInButton.setFont(new Font("Arial", Font.PLAIN, 12));
        signUpButton.setFont(new Font("Arial", Font.PLAIN, 12));
        URL fontUrl = null;
        try {
            fontUrl = new URL("http://www.webpagepublicity.com/free-fonts/b/Base%205.ttf");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Font font = null;
        try {
            assert fontUrl != null;
            font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        font = font.deriveFont(Font.PLAIN, 15);
        GraphicsEnvironment ge =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        usernameLabel.setForeground(Color.white);
        usernameLabel.setFont(font);
        passwordLabel.setFont(font);
        passwordLabel.setForeground(Color.white);
        welcomeLabel.setFont(font);
        signInButton.addActionListener(e -> {
            String name;
            String password;
            name = usernameText.getText();
            password = passwordText.getText();
            setVisible(false);
            int flag = 0;
            try {
                FileReader fw = new FileReader("AssembledComputerProject/userInfo.txt");
                Scanner reader = new Scanner(fw);
                while (reader.hasNextLine()) {
                    String input = reader.nextLine();
                    String[] splittedInput = input.split(":");
                    if ((name.equals(splittedInput[0]) && password.equals(splittedInput[1]))) {
                        flag = 1;
                        break;
                    }
                }
            } catch (FileNotFoundException er) {
                er.printStackTrace();
            }
            if (flag == 0) {
                JOptionPane.showMessageDialog(null, "couldn't find the user", "error", JOptionPane.WARNING_MESSAGE);
                setVisible(true);
            } else {
                HomeScreen homeScreen = new HomeScreen(name);
                homeScreen.setLocationRelativeTo(null);
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                SignupScreen signupScreen = new SignupScreen();
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 45, 15));
        buttonPanel.add(signInButton);
        buttonPanel.add(signUpButton);
        JPanel usernamePanel = new JPanel();
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameText);
        JPanel passwordPanel = new JPanel();
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordText);
        signInPanel.setLayout(new GridLayout(4, 3, 3, 3));
        signInPanel.add(welcomePanel);
        signInPanel.add(usernamePanel);
        signInPanel.add(passwordPanel);
        signInPanel.add(buttonPanel);

        welcomePanel.setBackground(new Color(ghost_white));
        usernamePanel.setBackground(new Color(light_grey));
        passwordPanel.setBackground(new Color(light_green));
        buttonPanel.setBackground(new Color(ghost_white));
        add(signInPanel);
        setTitle("Login Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 400);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
