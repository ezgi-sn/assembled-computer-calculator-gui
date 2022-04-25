package AssembledComputerProject;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class HomeScreen extends JFrame {
    public int price = 0;
    //calculation components of the project
    private final JTextField budget;
    private final JButton calculateButton;
    private final JTextField totalText;

    //computer component buttons
    private final JButton cpuButton;
    private final JButton ramButton;
    private final JButton graphicsButton;
    private final JButton ssdButton;

    //computer component panels
    private final JPanel ramPanel;
    private final JPanel cpuPanel;
    private final JPanel graphicPanel;
    private final JPanel ssdPanel;
    private final JPanel componentPanel;

    //cpu buttons
    ArrayList<JRadioButton> cpulist = new ArrayList<>();
    JRadioButton celeron = new JRadioButton("celeron comet lake -- 490 tl");
    JRadioButton i5_9400f = new JRadioButton("i5-9400f -- 1700 tl");
    JRadioButton ryzen = new JRadioButton("ryzen 3 -- 1700 tl ");
    JRadioButton i7_9700k = new JRadioButton("i7-9700k -- 2750 tl");
    JRadioButton i9_10900 = new JRadioButton("i9-10900 -- 4300 tl");
    ButtonGroup bg = new ButtonGroup();

    //graphic card buttons
    ArrayList<JRadioButton> graphlist = new ArrayList<>();
    JRadioButton gt1030 = new JRadioButton("asus gt130 -- 970 tl");
    JRadioButton rtx2060 = new JRadioButton("rtx 2060 -- 6400 tl");
    JRadioButton rtx3070ti = new JRadioButton("rtx 3070ti -- 16000 tl");
    JRadioButton gtx1050ti = new JRadioButton("gtx 1050ti -- 3700 tl");
    JRadioButton gtx1660 = new JRadioButton("gtx 1660 -- 6500 tl");
    ButtonGroup graphicsGroup = new ButtonGroup();

    //ssd buttons
    ArrayList<JRadioButton> ssdlist = new ArrayList<>();
    JRadioButton ssdplus_240 = new JRadioButton("ssd plus 240gb -- 295 tl");
    JRadioButton ssdplus_480 = new JRadioButton("ssd plus 480 gb -- 450 tl");
    JRadioButton ssdnow_240 = new JRadioButton("ssdnow 240 gb --  300 tl");
    JRadioButton ssdultra_500 = new JRadioButton("ssd ultra 500 gb -- 550 tl");
    JRadioButton qvo = new JRadioButton("qvo 870 1 tb -- 1300 tl");
    ButtonGroup ssdgroup = new ButtonGroup();
    //ram buttons
    ArrayList<JRadioButton> ramlist = new ArrayList<>();
    JRadioButton adata_8gb = new JRadioButton("adata 8gb --  430 tl");
    JRadioButton corsair_8g = new JRadioButton("corsair 8 gb -- 400 tl");
    JRadioButton gskill_16gb = new JRadioButton("g. skill 16 gb -- 900 tl");
    JRadioButton kingston_8gb = new JRadioButton("kingston 8 gb -- 530 tl");
    JRadioButton corsair_16gb = new JRadioButton("corsair 16 gb -- 800 tl");
    ButtonGroup ramgroup = new ButtonGroup();

    JButton deleteButton;

    //constructor
    public HomeScreen(String name) {

        //fonts
        URL fontUrl = null;
        URL fontUrl2 = null;
        try {
            fontUrl = new URL("https://www.webpagepublicity.com/free-fonts/b/Base%205.ttf");
            fontUrl2 = new URL("https://www.webpagepublicity.com/free-fonts/l/Librarian%20Regular.ttf");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Font font = null;
        Font vahikaFont = null;
        try {
            assert fontUrl != null;
            font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
            assert fontUrl2 != null;
            vahikaFont = Font.createFont(Font.TRUETYPE_FONT, fontUrl2.openStream());
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        assert font != null;
        font = font.deriveFont(Font.PLAIN, 12);
        assert vahikaFont != null;
        vahikaFont = vahikaFont.deriveFont(Font.PLAIN, 13);
        Font v2 = vahikaFont.deriveFont(Font.PLAIN, 15);
        Font vahikaFont2 = vahikaFont.deriveFont(Font.BOLD, 30);
        GraphicsEnvironment ge =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        ge.registerFont(vahikaFont2);

        //calculation panel
        String text = "Welcome " + name + "!";
        ImagePanel calculationPanel = new ImagePanel(400, 400, "AssembledComputerProject/icons/paper.jpg");
        calculationPanel.setLayout(new GridLayout(4, 1));
        JLabel welcomingLabel = new JLabel(text);
        welcomingLabel.setFont(vahikaFont2);

        //budget panel
        ImagePanel budgetPanel = new ImagePanel(400, 400, "AssembledComputerProject/icons/paper.jpg");
        JLabel learnBudget = new JLabel("      Enter your budget:");
        budget = new JTextField(13);
        budgetPanel.add(learnBudget);
        budgetPanel.add(budget);
        learnBudget.setFont(v2);

        //total cost panel
        ImagePanel totalPanel = new ImagePanel(400, 400, "AssembledComputerProject/icons/paper.jpg");
        JLabel total = new JLabel("Total value of the system:");
        totalText = new JTextField(13);
        totalPanel.add(total);
        totalPanel.add(totalText);
        total.setFont(v2);

        //cpulist
        cpulist.add(celeron);
        cpulist.add(i5_9400f);
        cpulist.add(ryzen);
        cpulist.add(i7_9700k);
        cpulist.add(i9_10900);
        int ghost_white = 0xF8F8FF;
        for (JRadioButton temp : cpulist) {
            temp.setFont(vahikaFont);
            temp.setBackground(new Color(ghost_white));
        }

        //graphic card list
        graphlist.add(gt1030);
        graphlist.add(rtx2060);
        graphlist.add(rtx3070ti);
        graphlist.add(gtx1050ti);
        graphlist.add(gtx1660);
        for (JRadioButton temp : graphlist) {
            temp.setFont(vahikaFont);
            temp.setBackground(new Color(ghost_white));
        }

        //ram list
        ramlist.add(adata_8gb);
        ramlist.add(corsair_16gb);
        ramlist.add(corsair_8g);
        ramlist.add(gskill_16gb);
        ramlist.add(kingston_8gb);
        for (JRadioButton temp : ramlist) {
            temp.setFont(vahikaFont);
            temp.setBackground(new Color(ghost_white));
        }

        //ssd list
        ssdlist.add(ssdnow_240);
        ssdlist.add(ssdplus_240);
        ssdlist.add(ssdplus_480);
        ssdlist.add(ssdultra_500);
        ssdlist.add(qvo);
        for (JRadioButton temp : ssdlist) {
            temp.setFont(vahikaFont);
            temp.setBackground(new Color(ghost_white));
        }

        //button panel
        calculateButton = new JButton("calculate");
        int light_grey = 0x778899;
        calculateButton.setBackground(new Color(light_grey));
        calculateButton.setOpaque(true);
        calculateButton.setBorderPainted(false);
        calculateButton.setFont(font);

        JButton exitButton = new JButton("exit");
        int light_green = 0xA2D9CE;
        exitButton.setBackground(new Color(light_green));
        exitButton.setOpaque(true);
        exitButton.setBorderPainted(false);
        exitButton.setFont(font);
        exitButton.addActionListener(e -> {
            setVisible(false);
            System.exit(0);
        });
        ImagePanel buttonPanel = new ImagePanel(400, 400, "AssembledComputerProject/icons/paper.jpg");
        buttonPanel.add(calculateButton);
        buttonPanel.add(exitButton);

        //adding calculation components to calculation panel
        calculationPanel.setLayout(new GridLayout(4, 1));
        calculationPanel.add(welcomingLabel);
        calculationPanel.add(budgetPanel);
        calculationPanel.add(totalPanel);
        calculationPanel.add(buttonPanel);
        add(calculationPanel);
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new BorderLayout());

        //computer components panel
        componentPanel = new JPanel();
        componentPanel.setLayout(new GridLayout(4, 1));
        JLabel chooseLabel = new JLabel(" Choose components you want to assemble:");
        chooseLabel.setFont(v2);
        JPanel componentButtons = new JPanel();
        componentButtons.setLayout(new GridLayout(1, 4, 5, 5));

        cpuButton = new JButton("cpu");
        cpuButton.setPreferredSize(new Dimension(10, 10));
        cpuButton.setFont(font);
        cpuButton.setBackground(new Color(light_green));
        cpuButton.setOpaque(true);
        cpuButton.setBorderPainted(false);
        cpuButton.addActionListener(this::actionPerformed);

        ramButton = new JButton("ram");
        ramButton.setPreferredSize(new Dimension(10, 10));
        ramButton.setBackground(new Color(light_grey));
        ramButton.setFont(font);
        ramButton.setOpaque(true);
        ramButton.setBorderPainted(false);
        ramButton.addActionListener(this::actionPerformed);

        graphicsButton = new JButton("graphics card");
        graphicsButton.setFont(font);
        graphicsButton.setPreferredSize(new Dimension(10, 10));
        graphicsButton.addActionListener(this::actionPerformed);
        graphicsButton.setBackground(new Color(light_green));
        graphicsButton.setOpaque(true);
        graphicsButton.setBorderPainted(false);

        ssdButton = new JButton("ssd card");
        ssdButton.setPreferredSize(new Dimension(10, 10));
        ssdButton.setFont(font);
        ssdButton.addActionListener(this::actionPerformed);
        ssdButton.setBackground(new Color(light_grey));
        ssdButton.setOpaque(true);
        ssdButton.setBorderPainted(false);

        calculateButton.addActionListener(this::actionPerformed);
        componentButtons.add(cpuButton);
        componentButtons.add(ramButton);
        componentButtons.add(graphicsButton);
        componentButtons.add(ssdButton);

        //cpuPanel
        for (JRadioButton temp : cpulist) {
            bg.add(temp);
            temp.addActionListener(this::actionPerformed);
        }
        cpuPanel = new JPanel();
        cpuPanel.setBackground(new Color(ghost_white));
        cpuPanel.setLayout(new GridLayout(5, 1));
        for (JRadioButton temp : cpulist) {
            cpuPanel.add(temp);
        }
        JPanel assemlePanel = new JPanel();
        assemlePanel.add(cpuPanel);
        cpuPanel.setVisible(false);

        //ramPanel
        for (JRadioButton temp : ramlist) {
            ramgroup.add(temp);
            temp.addActionListener(this::actionPerformed);
        }
        ramPanel = new JPanel();
        ramPanel.setBackground(new Color(ghost_white));
        ramPanel.setLayout(new GridLayout(5, 1));
        for (JRadioButton temp : ramlist) {
            ramPanel.add(temp);
        }
        assemlePanel.add(ramPanel);
        ramPanel.setVisible(false);

        //graphicsPanel
        for (JRadioButton temp : graphlist) {
            graphicsGroup.add(temp);
            temp.addActionListener(this::actionPerformed);
        }
        graphicPanel = new JPanel();
        graphicPanel.setLayout(new GridLayout(5, 1));
        for (JRadioButton temp : graphlist) {
            graphicPanel.add(temp);
        }
        graphicPanel.setBackground(new Color(ghost_white));
        assemlePanel.setBackground(new Color(ghost_white));
        assemlePanel.add(graphicPanel);
        graphicPanel.setVisible(false);

        //ssdPanel
        for (JRadioButton temp : ssdlist) {
            ssdgroup.add(temp);
            temp.addActionListener(this::actionPerformed);
        }
        ssdPanel = new JPanel();
        ssdPanel.setBackground(new Color(ghost_white));
        ssdPanel.setLayout(new GridLayout(5, 1));
        for (JRadioButton temp : ssdlist) {
            ssdPanel.add(temp);
        }
        ssdPanel.setVisible(false);
        assemlePanel.add(ssdPanel);

        //deleteButton
        deleteButton = new JButton("clear all selections");
        deleteButton.setFont(font);
        deleteButton.setBackground(new Color(light_grey));
        deleteButton.addActionListener(this::actionPerformed);
        JPanel deletePanel = new JPanel();
        deletePanel.add(deleteButton);
        deletePanel.setBackground(new Color(ghost_white));
        //add panels to componentPanel
        componentPanel.add(chooseLabel);
        componentPanel.add(componentButtons);
        componentPanel.add(assemlePanel);
        componentPanel.add(deletePanel);
        componentPanel.setBackground(new Color(ghost_white));
        componentButtons.setBackground(new Color(ghost_white));

        //setBorder
        Border blackline;
        blackline = BorderFactory.createLineBorder(Color.BLACK);
        componentPanel.setBorder(blackline);
        Border whiteLine;
        whiteLine = BorderFactory.createLineBorder(new Color(ghost_white));
        componentButtons.setBorder(whiteLine);

        //add panels to homePanel
        homePanel.add(calculationPanel, BorderLayout.WEST);
        homePanel.add(componentPanel, BorderLayout.CENTER);
        add(homePanel);
        setTitle("Assemble a computer");
        setSize(850, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            try {
                totalText.setText(String.valueOf(price));
                int customerBudget;
                customerBudget = Integer.parseInt(budget.getText());
                if (price > customerBudget) {
                    JOptionPane.showMessageDialog(null, "exceeded your budget", "warning", JOptionPane.WARNING_MESSAGE);
                } else
                    JOptionPane.showMessageDialog(null, "you can purchase this system", "", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "you should enter your budget", "an error occurred", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == cpuButton) {
            setVisible(false);
            setVisible(true);
            cpuPanel.setVisible(true);
            componentPanel.setVisible(true);
            ramPanel.setVisible(false);
            graphicPanel.setVisible(false);
            ssdPanel.setVisible(false);

        } else if (e.getSource() == ramButton) {
            setVisible(false);
            setVisible(true);
            ramPanel.setVisible(true);
            graphicPanel.setVisible(false);
            ssdPanel.setVisible(false);
            cpuPanel.setVisible(false);


        } else if (e.getSource() == graphicsButton) {
            setVisible(false);
            setVisible(true);
            graphicPanel.setVisible(true);
            ssdPanel.setVisible(false);
            cpuPanel.setVisible(false);
            ramPanel.setVisible(false);

        } else if (e.getSource() == ssdButton) {
            setVisible(false);
            setVisible(true);
            ssdPanel.setVisible(true);
            graphicPanel.setVisible(false);
            cpuPanel.setVisible(false);
            ramPanel.setVisible(false);
        } else if (e.getSource() == celeron) {
            for (JRadioButton temp : cpulist) {
                temp.setEnabled(false);
            }
            price += 490;
        } else if (e.getSource() == i5_9400f) {
            for (JRadioButton temp : cpulist) {
                temp.setEnabled(false);
            }
            price += 1700;
        } else if (e.getSource() == ryzen) {
            for (JRadioButton temp : cpulist) {
                temp.setEnabled(false);
            }
            price += 1700;
        } else if (e.getSource() == i7_9700k) {
            for (JRadioButton temp : cpulist) {
                temp.setEnabled(false);
            }
            price += 2750;
        } else if (e.getSource() == i9_10900) {
            for (JRadioButton temp : cpulist) {
                temp.setEnabled(false);
            }
            price += 4300;
        } else if (e.getSource() == rtx2060) {
            for (JRadioButton temp : graphlist) {
                temp.setEnabled(false);
            }
            price += 6400;
        } else if (e.getSource() == rtx3070ti) {
            for (JRadioButton temp : graphlist) {
                temp.setEnabled(false);
            }
            price += 16000;
        } else if (e.getSource() == gtx1050ti) {
            for (JRadioButton temp : graphlist) {
                temp.setEnabled(false);
            }
            price += 3700;
        } else if (e.getSource() == gtx1660) {
            for (JRadioButton temp : graphlist) {
                temp.setEnabled(false);
            }
            price += 6500;
        } else if (e.getSource() == gt1030) {
            for (JRadioButton temp : graphlist) {
                temp.setEnabled(false);
            }
            price += 970;
        } else if (e.getSource() == ssdplus_240) {
            for (JRadioButton temp : ssdlist) {
                temp.setEnabled(false);
            }
            price += 295;
        } else if (e.getSource() == ssdplus_480) {
            for (JRadioButton temp : ssdlist) {
                temp.setEnabled(false);
            }
            price += 450;
        } else if (e.getSource() == ssdnow_240) {
            for (JRadioButton temp : ssdlist) {
                temp.setEnabled(false);
            }
            price += 300;
        } else if (e.getSource() == ssdultra_500) {
            for (JRadioButton temp : ssdlist) {
                temp.setEnabled(false);
            }
            price += 550;
        } else if (e.getSource() == qvo) {
            for (JRadioButton temp : ssdlist) {
                temp.setEnabled(false);
            }
            price += 1300;
        } else if (e.getSource() == adata_8gb) {
            for (JRadioButton temp : ramlist) {
                temp.setEnabled(false);
            }
            price += 430;
        } else if (e.getSource() == corsair_8g) {
            for (JRadioButton temp : ramlist) {
                temp.setEnabled(false);
            }
            price += 400;
        } else if (e.getSource() == gskill_16gb) {
            for (JRadioButton temp : ramlist) {
                temp.setEnabled(false);
            }
            price += 900;
        } else if (e.getSource() == kingston_8gb) {
            for (JRadioButton temp : ramlist) {
                temp.setEnabled(false);
            }
            price += 530;
        } else if (e.getSource() == corsair_16gb) {
            for (JRadioButton temp : ramlist) {
                temp.setEnabled(false);
            }
            price += 800;
        } else if (e.getSource() == deleteButton) {
            price = 0;
            budget.setText("");
            totalText.setText("");
            for (JRadioButton temp : ramlist) {
                temp.setEnabled(true);
            }
            for (JRadioButton temp : cpulist) {
                temp.setEnabled(true);
            }
            for (JRadioButton temp : graphlist) {
                temp.setEnabled(true);
            }
            for (JRadioButton temp : ssdlist) {
                temp.setEnabled(true);
            }
        }
    }
}

class ImagePanel extends JPanel {
    // Picture width
    private final int width;
    // Picture height
    private final int height;
    // Picture
    private BufferedImage image = null;

    public ImagePanel(int width, int height, String path) {
        super();
        // set width and height
        this.width = width;
        this.height = height;
        try {
            // read picture
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, width, height, this);
    }
}
