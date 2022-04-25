package AssembledComputerProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class SignupScreen extends JFrame {
    private final JTextField userText;
    private final JPasswordField passwordField;
    private final JPasswordField passwordField_2;

    public SignupScreen() {
        setTitle("Sign up");
        URL fontUrl = null;
        try {
            fontUrl = new URL("https://www.webpagepublicity.com/free-fonts/b/Base%205.ttf");
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
        assert font != null;
        font = font.deriveFont(Font.PLAIN, 15);
        GraphicsEnvironment ge =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        ImageIcon icon = new ImageIcon("AssembledComputerProject/icons/signup_2.png");
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        JLabel addUserLabel = new JLabel("create a new account");
        addUserLabel.setIcon(icon);
        addUserLabel.setFont(font);
        JPanel addUserPanel = new JPanel();
        addUserPanel.setLayout(new BorderLayout());
        addUserPanel.add(addUserLabel, BorderLayout.WEST);
        setLayout(new GridLayout(5, 1));
        JPanel usernamePanel = new JPanel();
        JLabel username = new JLabel("username:");
        userText = new JTextField(10);
        usernamePanel.add(username);
        username.setFont(font);
        usernamePanel.add(userText);
        int light_green = 0xA2D9CE;
        usernamePanel.setBackground(new Color(light_green));

        JPanel passwordPanel = new JPanel();
        JLabel password = new JLabel("password:");
        passwordField = new JPasswordField(10);
        passwordPanel.add(password);
        passwordPanel.add(passwordField);
        password.setFont(font);
        int light_grey = 0x778899;
        passwordPanel.setBackground(new Color(light_grey));
        password.setForeground(Color.white);

        JPanel passwordPanel2 = new JPanel();
        JLabel password_2 = new JLabel("password again:");
        passwordField_2 = new JPasswordField(10);
        passwordPanel2.add(password_2);
        passwordPanel2.add(passwordField_2);
        password_2.setFont(font);
        passwordPanel2.setBackground(new Color(light_green));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 5, 5));
        JButton signupButton = new JButton("sign up");
        ImageIcon signupIcon = new ImageIcon("AssembledComputerProject/icons/signup.png");
        Image signupImage = signupIcon.getImage();
        Image scaledSignup = signupImage.getScaledInstance(12, 12, Image.SCALE_SMOOTH);
        signupIcon = new ImageIcon(scaledSignup);
        signupButton.setIcon(signupIcon);

        JButton exitButton = new JButton("exit");
        ImageIcon exitIcon = new ImageIcon("AssembledComputerProject/icons/exit.png");
        Image exitImage = exitIcon.getImage();
        Image scaledexit = exitImage.getScaledInstance(12, 12, Image.SCALE_SMOOTH);
        exitIcon = new ImageIcon(scaledexit);
        exitButton.setIcon(exitIcon);
        signupButton.setFont(new Font("Arial", Font.PLAIN, 12));
        exitButton.setFont(new Font("Arial", Font.PLAIN, 12));

        buttonPanel.add(signupButton);
        buttonPanel.add(exitButton);
        int ghost_white = 0xF8F8FF;
        buttonPanel.setBackground(new Color(ghost_white));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                System.exit(0);
            }
        });
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name;
                String password;
                String checkPassword;
                name = userText.getText();
                password = passwordField.getText();
                checkPassword = passwordField_2.getText();
                int nameLength = name.length();
                int passwordLength = password.length();
                if (!password.equals(checkPassword)) {
                    JOptionPane.showMessageDialog(null, "passwords do not match", "error", JOptionPane.ERROR_MESSAGE);
                } else if ((nameLength == 0) || passwordLength == 0) {
                    JOptionPane.showMessageDialog(null, "fill the blank areas", "error", JOptionPane.ERROR_MESSAGE);
                } else if (!checkUsername(name)) {
                    JOptionPane.showMessageDialog(null, "username is already taken", "error", JOptionPane.ERROR_MESSAGE);
                } else {
                    FileWriter userInfo = null;
                    try {
                        userInfo = new FileWriter("AssembledComputerProject/userInfo.txt", true);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    String data = name + ":" + password + "\n";
                    try {
                        userInfo.append(data);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    try {
                        userInfo.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    setVisible(false);
                    LoginScreen loginScreen = new LoginScreen();
                    loginScreen.setLocationRelativeTo(null);
                    loginScreen.setVisible(true);
                }
            }
        });
        add(addUserPanel);
        add(usernamePanel);
        add(passwordPanel);
        add(passwordPanel2);
        add(buttonPanel);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public boolean checkUsername(String s) {
        try {
            FileReader fw = new FileReader("AssembledComputerProject/userInfo.txt");
            Scanner reader = new Scanner(fw);
            while (reader.hasNextLine()) {
                String input = reader.nextLine();
                String[] splittedInput = input.split(":");
                if (s.equals(splittedInput[0])) {
                    return false;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
