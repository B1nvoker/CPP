import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyListener;

public class MyGUI {
    private JButton startButton;
    private JButton guessButton;
    private JTextField textField;
    private JLabel label;
    private JMenuBar menuBar;
    private JFrame frame;
    private GameLogic gameLogic;

    public void runGUI(final int border){
        constructFrame(border);
        setIcon();
        makeMenu();
        addComponentsToFrame();
        finalSettingOfFrame();
    }

    private void constructFrame(final int border) {
        frame = new JFrame("Guess the random");
        label = new JLabel("Начните игру");
        textField = new JTextField();
        startButton = new JButton ("Новая игра");
        guessButton = new JButton ("Угадать!");
        menuBar = new JMenuBar();
        gameLogic = new GameLogic(border);

        startButton.addActionListener(new RandomListener());
        guessButton.addActionListener(new GuessListener());
        final KeyListener keyListener = new KeyListener() {
            public void keyTyped(final KeyEvent e) { }
            public void keyPressed(final KeyEvent e) {
                if (KeyEvent.VK_ENTER == e.getKeyCode()) {
                    gameLogic.setUserNumber(textField.getText());
                    gameLogic.incCounter();
                    printResultText();
                    textField.setText("");
                }
            }
           public void keyReleased(final KeyEvent e) { }
        };
        textField.addKeyListener(keyListener);
    }

    private void setIcon() {
        ImageIcon icon = new ImageIcon("src/image/icon.png");
        frame.setIconImage(icon.getImage());

    }

    private void makeMenu() {
        JMenu mainMenu = new JMenu("Меню");

        JMenuItem newGameItem = new JMenuItem("Новая игра");
        mainMenu.add(newGameItem);
        newGameItem.addActionListener(new RandomListener());

        JMenuItem aboutItem = new JMenuItem("О программе");
        mainMenu.add(aboutItem);
        aboutItem.addActionListener(new AboutListener());

        mainMenu.addSeparator();

        JMenuItem exitItem = new JMenuItem("Выход");
        mainMenu.add(exitItem);
        exitItem.addActionListener(new ExitListener());

        menuBar.add(mainMenu);
        frame.setJMenuBar(menuBar);
    }

    private void addComponentsToFrame() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        textField.setBounds(20,15,150,20);
        panel.add (textField);

        label.setBounds(20,35, 200, 20);
        panel.add(label);

        guessButton.setBounds (20, 60, 90,30);
        panel.add(guessButton);

        startButton.setBounds (120, 60, 150, 30);
        panel.add(startButton);

        frame.getContentPane().add(panel);
    }

    private void finalSettingOfFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,165);
        frame.setLocation(800,400);
        frame.setUndecorated(false);
        frame.setVisible(true);
    }

    class ExitListener implements ActionListener {
        public void actionPerformed (ActionEvent event){
            System.exit(0);
        }
    }

    class AboutListener implements ActionListener {
        public void actionPerformed (ActionEvent event){
            JOptionPane.showMessageDialog(
                    null,
                    "Первая лаба",
                    "О программе",
                    JOptionPane.PLAIN_MESSAGE
                    );
        }
    }

    class GuessListener implements ActionListener {
        public void actionPerformed (ActionEvent event) {
            gameLogic.setUserNumber(textField.getText());
            gameLogic.incCounter();
            printResultText();
            textField.setText("");
        }
    }

    private void printResultText(){
        switch (gameLogic.compareOfNumbers()) {
            case NOT_STARTED: label.setText("Начните новую игру"); break;
            case NOT_ENTERED: label.setText("Число не введено"); break;
            case MORE: label.setText("Число "+ gameLogic.getUserNumber()+" больше загаданного"); break;
            case LESS: label.setText("Число "+ gameLogic.getUserNumber()+" меньше загаданного"); break;
            case WIN: {
                label.setText("Победа!");
                JOptionPane.showMessageDialog(
                        null,
                        "Вы угадали число "+ gameLogic.getComputerNumber()+"!\nКоличество попыток: "+
                                gameLogic.getCounter(),
                        "Победа!", JOptionPane.PLAIN_MESSAGE);

                gameLogic.setNegativeComputerNumber();
                label.setText("Начните игру заново");
                textField.setText("");
                break;
            }
        }
    }

    class RandomListener implements ActionListener{
        public void actionPerformed (ActionEvent event) {
            gameLogic.setRandomNumber();
            gameLogic.setCounterToZero();
            label.setText("Новое число сгенерировано");
            textField.setText("");
        }
    }
}