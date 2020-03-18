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
    static ImageIcon p1Image;
    static ImageIcon p2Image;
    public String buttonText1 = "1";
    public String buttonText2 = "2";
    public String buttonText3 = "3";
    public String buttonText4 = "4";
    public String buttonText5 = "5";
    public String buttonText6 = "6";
    public String buttonText7 = "7";
    public ImageIcon black;
    public ImageIcon yellow;
    public ImageIcon white;
    public ImageIcon blue;
    public ImageIcon red;
    //  JTextField field1 = new JTextField();
    //JTextField field2 = new JTextField();
    //JTextField field3 = new JTextField();
    //JTextField field4 = new JTextField();
    //CoreLogic coreLogic = new CoreLogic();

    Image image;
    Image scaledImage;


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
                CreateGrid();
                board = new Board();

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
                JOptionPane.showMessageDialog(frame2, "Game Rules \n Welcome to LinkFour \n The game rules are same as the traditional Connect Four game. \n Use the buttons above to drop a piece in the column. \n PLayer 1 will be black and player 2 will be yellow. \n Take turns to drop a piece in the column until one player Links Four pieces in any direction.");
            }
        });
        menu.add(m);


        m = new JMenuItem("About");
        m.setMnemonic(KeyEvent.VK_A);
        m.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame2, "Developed by Jason Wang and Siddharth Shah. \n Developed the game to bring the classic Connect Four board game to your desktop! \n We really enjoy playing the game, hope you do too.");
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
            p1Image= red;
        }
        else if(selectionp1 == "blue"){
            p1Image =blue;
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
        Object Obj = JOptionPane.showInputDialog(frame, "Player 2 Choose a color please", "Token Color", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        String selectionp2 = Obj.toString();
        if(selectionp2 == "red"){
            p2Image= red;
        }
        else if(selectionp2 == "blue"){
            p2Image =blue;
        }
        else if (selectionp2 == "black"){
            p2Image = black;
        }
        else if (selectionp2 == "yellow"){
            p2Image = yellow;
        }
        return p2Image;
    }

    public void newGamePopUp() {
        int option = JOptionPane.showConfirmDialog(null, "If yes, then click OK", "Are you sure?", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            p1Name = JOptionPane.showInputDialog("Enter a name for player 1:");
            p2Name = JOptionPane.showInputDialog("Enter a name for player 2:");
        }
        frame.setVisible(false);
        frame.dispose();
    }


    //bring out a pop-window to confirm the exit action
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

        white = new ImageIcon("white.png");
        image = white.getImage(); // transform it
        scaledImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        white = new ImageIcon(scaledImage);  // transform it back

        panel.setLayout(new GridLayout(7, 7));
        slots = new JLabel[6][7];


        buttons = new JButton[7];
     /*  for(int i=0;i<7;i++){
           buttons[i] = new JButton(""+buttonText1);
           buttonText1++;
           panel.add(buttons[i]);
       }
*/
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


        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                String button = KeyEvent.getKeyText(e.getKeyCode());

                if (buttonText1.equals("1")) {
                    int a = Integer.parseInt(button);
                    int y = board.CheckColumn(a);
                    InputPiece(y, a);
                    board.ChangePlayer();
                    CoreLogic.GameOver(CoreLogic.WinHorizontal());
                    CoreLogic.GameOver(CoreLogic.WinVertical());
                    CoreLogic.GameOver(CoreLogic.WinDiagonal());
                } else if (buttonText2.equals("2")) {
                    int a = Integer.parseInt(button);
                    int y = board.CheckColumn(a);
                    InputPiece(y, a);
                    board.ChangePlayer();
                    CoreLogic.GameOver(CoreLogic.WinHorizontal());
                    CoreLogic.GameOver(CoreLogic.WinVertical());
                    CoreLogic.GameOver(CoreLogic.WinDiagonal());
                } else if (buttonText3.equals("3")) {
                    int a = Integer.parseInt(button);
                    int y = board.CheckColumn(a);
                    InputPiece(y, a);
                    board.ChangePlayer();
                    CoreLogic.GameOver(CoreLogic.WinHorizontal());
                    CoreLogic.GameOver(CoreLogic.WinVertical());
                    CoreLogic.GameOver(CoreLogic.WinDiagonal());
                } else if (buttonText4.equals("4")) {
                    int a = Integer.parseInt(button);
                    int y = board.CheckColumn(a);
                    InputPiece(y, a);
                    board.ChangePlayer();
                    CoreLogic.GameOver(CoreLogic.WinHorizontal());
                    CoreLogic.GameOver(CoreLogic.WinVertical());
                    CoreLogic.GameOver(CoreLogic.WinDiagonal());
                } else if (buttonText5.equals("5")) {
                    int a = Integer.parseInt(button);
                    int y = board.CheckColumn(a);
                    InputPiece(y, a);
                    board.ChangePlayer();
                    CoreLogic.GameOver(CoreLogic.WinHorizontal());
                    CoreLogic.GameOver(CoreLogic.WinVertical());
                    CoreLogic.GameOver(CoreLogic.WinDiagonal());
                } else if (buttonText6.equals("6")) {
                    int a = Integer.parseInt(button);
                    int y = board.CheckColumn(a);
                    InputPiece(y, a);
                    board.ChangePlayer();
                    CoreLogic.GameOver(CoreLogic.WinHorizontal());
                    CoreLogic.GameOver(CoreLogic.WinVertical());
                    CoreLogic.GameOver(CoreLogic.WinDiagonal());
                } else if (buttonText7.equals("7")) {
                    int a = Integer.parseInt(button);
                    int y = board.CheckColumn(a);
                    InputPiece(y, a);
                    board.ChangePlayer();
                    CoreLogic.GameOver(CoreLogic.WinHorizontal());
                    CoreLogic.GameOver(CoreLogic.WinVertical());
                    CoreLogic.GameOver(CoreLogic.WinDiagonal());
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


        frame.setFocusable(true);
        frame.setContentPane(panel);
        frame.setSize(700, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }


    public void InputPiece(int x, int y) {
        black = new ImageIcon("black.png");
        image = black.getImage(); // transform it
        scaledImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        black = new ImageIcon(scaledImage);  // transform it back

        blue = new ImageIcon("blue.png");
        image = blue.getImage(); // transform it
        scaledImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        blue = new ImageIcon(scaledImage);  // transform it back

        yellow = new ImageIcon("yellow.png");
        image = yellow.getImage(); // transform it
        scaledImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        yellow = new ImageIcon(scaledImage);  // transform it back

        red = new ImageIcon("red.png");
        image = red.getImage(); // transform it
        scaledImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        red = new ImageIcon(scaledImage);  // transform it back

        if (board.playerTurn == 1) {
            //AssignColortogridp1(x,y);
            slots[x][y].setIcon(p1Image);
        } else {
            // AssignColortogridp2(x,y);
            slots[x][y].setIcon(p2Image);
        }


    }

   /* public void AssignColortogridp1(int x, int y) {

        switch (selectPieceColorp1()) {
            case "red":
               slots[x][y] == selectPieceColorp1;
                break;
            case "blue":
                slots[x][y].setIcon(blue);
                break;
            case "yellow":
                slots[x][y].setIcon(yellow);
                break;
            case "black":
                slots[x][y].setIcon(black);
                break;
            default:
                slots[x][y].setIcon(black);
        }
}


public void AssignColortogridp2(int x, int y){
    switch (selectPieceColorp2()) {
        case "red":
            if(selectPieceColorp1()== "red"){
                //a dialog pops up saying, cant have the same color as p1
            }else{
                slots[x][y].setIcon(red);
            }

            break;
        case "blue":
            if(selectPieceColorp1()== "blue"){
                //a dialog pops up saying, cant have the same color as p1
            }else{
                slots[x][y].setIcon(blue);
            }

            break;
        case "yellow":
            if(selectPieceColorp1()== "yellow"){
                //a dialog pops up saying, cant have the same color as p1
            }else{
                slots[x][y].setIcon(yellow);
            }
            break;
        case "black":
            if(selectPieceColorp1()== "black"){
                //a dialog pops up saying, cant have the same color as p1
            }else{
                slots[x][y].setIcon(black);
            }

            break;
        default:
            slots[x][y].setIcon(yellow);
    }
}
*/


    public void NewGame()
    {
        CreateGrid();
        CreateMenuBar();
    }
	/*public void CreatePlayerTags()
	{
		JPanel panel2 = new JPanel();
		label = new JLabel("Player 1 Wins:", SwingConstants.CENTER);
		label.setBorder(BorderFactory.createLineBorder(Color.black));

		label = new JLabel("Player 2 Wins:", SwingConstants.CENTER);
		label.setBorder(BorderFactory.createLineBorder(Color.black));
	}
*/







    public void actionPerformed(ActionEvent e)
    {
        NewGame();
        //coreLogic.gameover();
        // set the label to the menuItem that is selected

    }
}

