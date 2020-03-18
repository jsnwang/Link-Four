package LinkFour;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.security.BasicPermission;

public class LinkFourView implements ActionListener {

    public JFrame frame = new JFrame("Link Four");
    public JFrame frame2 = new JFrame("About");
    JPanel panel = (JPanel) frame.getContentPane();
    public JLabel[][] slots;
    public JButton[] buttons;
    static String p1Name;
    static String p2Name;
    
    public String buttonText1 = "1";
    public String buttonText2 = "2";
    public String buttonText3 = "3";
    public String buttonText4 = "4";
    public String buttonText5 = "5";
    public String buttonText6 = "6";
    public String buttonText7 = "7";
    public static ImageIcon black;
    public static ImageIcon yellow;
    public static ImageIcon white;
    public static ImageIcon blue;
    public static ImageIcon red;
    
    static ImageIcon p1Image = black;
    static ImageIcon p2Image = red;

    Image image;
    Image scaledImage;
    static KeyListener key;

    Board board = new Board();

    public void CreateMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu;
        JMenuItem m;

        // create a menubar
        menuBar = new JMenuBar();

        // create File Menu
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);

        // create menuitems
        m = new JMenuItem("New Game");
        m.setMnemonic(KeyEvent.VK_N);
        m.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newGamePopUp();
                NewGame();


            }
        });
        menu.add(m);

        m = new JMenuItem("Preferences");
        m.setMnemonic(KeyEvent.VK_N);
        m.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectPieceColorp1();
                selectPieceColorp2();

            }
        });
        menu.add(m);

        m = new JMenuItem("Exit");
        m.setMnemonic(KeyEvent.VK_E);
        m.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Close();
            }
        });
        menu.add(m);

        // add menu to menu bar
        menuBar.add(menu);

        menu = new JMenu("Help");
        menu.setMnemonic(KeyEvent.VK_H);

        m = new JMenuItem("Rules");
        m.setMnemonic(KeyEvent.VK_A);
        m.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame2, "Game Rules \n Welcome to LinkFour \n The game rules are the same as the traditional Connect Four game. \n Use the buttons above to drop a piece in a column. \n Take turns dropping pieces down the board until one player Links Four pieces in a row.");
            }
        });
        menu.add(m);


        m = new JMenuItem("About");
        m.setMnemonic(KeyEvent.VK_A);
        m.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame2, "Developed by Jason Wang and Siddharth Shah.");
            }
        });
        menu.add(m);
        menuBar.add(menu);

        // add menubar to frame
        frame.setJMenuBar(menuBar);

    }

    public ImageIcon selectPieceColorp1() {
        Object[] options = {"red", "blue", "black", "yellow"};
        Object Obj1 = JOptionPane.showInputDialog(frame, "Player 1 Choose a color please", "Token Color", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        String selectionp1 = Obj1.toString();
        if(selectionp1 == "red"){
            p1Image = red;
        }
        else if(selectionp1 == "blue"){
            p1Image = blue;
        }
        else if (selectionp1 == "black"){
            p1Image = black;
        }
        else if (selectionp1 == "yellow"){
            p1Image = yellow;
        }
        return p1Image;

    }

    public ImageIcon selectPieceColorp2() {
        Object[] options = {"red", "blue", "black", "yellow"};
        Object Obj = JOptionPane.showInputDialog(frame, "Player 2 Choose a color: ", "Token Color", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        String selectionp2 = Obj.toString();
        if(selectionp2 == "red"){
            p2Image = red;
            if (p2Image == p1Image)
            {
            	System.out.print(p1Image + " " + p2Image);
            	JOptionPane.showMessageDialog(frame, "Color cannot be the same as Player 1.");
            	selectPieceColorp2();
            }
        }
        else if(selectionp2 == "blue"){
            p2Image = blue;
            if (p2Image == p1Image)
            {
            	System.out.print(p1Image + " " + p2Image);
            	JOptionPane.showMessageDialog(frame, "Color cannot be the same as Player 1.");
            	selectPieceColorp2();
            }
        }
        else if (selectionp2 == "black"){
            p2Image = black;
            if (p2Image == p1Image)
            {
            	System.out.print(p1Image + " " + p2Image);
            	JOptionPane.showMessageDialog(frame, "Color cannot be the same as Player 1.");
            	selectPieceColorp2();
            }
        }
        else if (selectionp2 == "yellow"){
            p2Image = yellow;
            if (p2Image == p1Image)
            {
            	System.out.print(p1Image + " " + p2Image);
            	JOptionPane.showMessageDialog(frame, "Color cannot be the same as Player 1.");
            	selectPieceColorp2();
            }
        }
        
        
        return p2Image;
    }

    public void newGamePopUp() {
        int option = JOptionPane.showConfirmDialog(null, "New Game?", "Are you sure?", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            p1Name = JOptionPane.showInputDialog("Enter a name for Player 1:");
            p2Name = JOptionPane.showInputDialog("Enter a name for Player 2:");
        }
        frame.setVisible(false);
        frame.dispose();
    }



    public void Close() {

        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?",
                "Confirmation", JOptionPane.YES_NO_OPTION);

        if (choice == 0) {
            System.out.println("Exit Button Clicked. Right? ");
            frame.setVisible(false);
            frame.dispose();
        }
    }

    public void CreateGrid() {
        board = new Board();
        panel.removeAll();

        //white = new ImageIcon("./res/white.png");
        white = new ImageIcon(getClass().getClassLoader().getResource("white.png"));
        image = white.getImage(); // transform it
        scaledImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        white = new ImageIcon(scaledImage);  // transform it back

        panel.setLayout(new GridLayout(7, 7));
        slots = new JLabel[6][7];


        buttons = new JButton[7];
        
        buttons[0] = new JButton(buttonText1);
        buttons[1] = new JButton(buttonText2);
        buttons[2] = new JButton(buttonText3);
        buttons[3] = new JButton(buttonText4);
        buttons[4] = new JButton(buttonText5);
        buttons[5] = new JButton(buttonText6);
        buttons[6] = new JButton(buttonText7);


        panel.add(buttons[0]);
        panel.add(buttons[1]);
        panel.add(buttons[2]);
        panel.add(buttons[3]);
        panel.add(buttons[4]);
        panel.add(buttons[5]);
        panel.add(buttons[6]);


        p1Image = black;
        p2Image = blue;
        
        key = new KeyListener() {
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {
                String button = KeyEvent.getKeyText(e.getKeyCode());
               
                int a = Integer.parseInt(button);
                a--;
                int y = board.CheckColumn(a);
                InputPiece(y, a);
                board.ChangePlayer();
                CoreLogic.GameOver(CoreLogic.WinHorizontal());
                CoreLogic.GameOver(CoreLogic.WinVertical());
                CoreLogic.GameOver(CoreLogic.WinDiagonal());
                

            }
            public void keyReleased(KeyEvent e) {

            }
        };
        
         frame.addKeyListener(key);
        for (int i = 0; i < 7; i++) {
            buttons[i].setActionCommand("" + i);
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int a = Integer.parseInt(e.getActionCommand());
                    int y = board.CheckColumn(a);
                    InputPiece(y, a);
                    board.ChangePlayer();
                    CoreLogic.GameOver(CoreLogic.WinHorizontal());
                    CoreLogic.GameOver(CoreLogic.WinVertical());
                    CoreLogic.GameOver(CoreLogic.WinDiagonal());

                }
            });
        }


        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                slots[i][j] = new JLabel(white);
                slots[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                slots[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                panel.add(slots[i][j]);
            }
        }

        

            
        


        frame.setFocusable(true);
        frame.setContentPane(panel);
        frame.setSize(700, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }


    public void InputPiece(int x, int y) {
        black = new ImageIcon(getClass().getClassLoader().getResource("black.png"));
        image = black.getImage(); // transform it
        scaledImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        black = new ImageIcon(scaledImage);  // transform it back

        blue = new ImageIcon(getClass().getClassLoader().getResource("blue.png"));
        image = blue.getImage(); // transform it
        scaledImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        blue = new ImageIcon(scaledImage);  // transform it back

        yellow = new ImageIcon(getClass().getClassLoader().getResource("yellow.png"));
        image = yellow.getImage(); // transform it
        scaledImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        yellow = new ImageIcon(scaledImage);  // transform it back

        red = new ImageIcon(getClass().getClassLoader().getResource("red.png"));
        image = red.getImage(); // transform it
        scaledImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        red = new ImageIcon(scaledImage);  // transform it back

        if (p1Image != null) {
        	if (board.playerTurn == 1 )
        	{
        		slots[x][y].setIcon(p1Image);
        	}
        	
        	else {
        		slots[x][y].setIcon(p2Image);
        	}
        }
        
        else
        {
        	if (board.playerTurn == 1 )
        	{
        		slots[x][y].setIcon(black);
        	}
        	
        	else {
        		slots[x][y].setIcon(blue);
        	}
        }


    }

    public void NewGame()
    {
    	frame.removeKeyListener(key);
    	frame.dispose();
    	CreateMenuBar();
    	
        CreateGrid();
        
        Board.movesLeft = 42;
    }

    public void actionPerformed(ActionEvent e)
    {
        NewGame();


    }
}

