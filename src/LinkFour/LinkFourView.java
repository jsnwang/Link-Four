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
  //  private JFrame closeFrame = new JFrame();
    public JLabel[][] slots;
   // public JLabel label;
    public JButton[] buttons;
   // public String p1 = "Player 1";
    //public String p2 = "Player 2";
    public ImageIcon black;
    public ImageIcon yellow;
    public ImageIcon white;
    JTextField field1 = new JTextField();
    JTextField field2 = new JTextField();
    JTextField field3 = new JTextField();
    JTextField field4 = new JTextField();
    CoreLogic coreLogic = new CoreLogic();
    
    Image image;
    Image scaledImage;

 //   private int gridX = 7;
   // private int gridY = 6;
	
    Board board = new Board();
	public void CreateMenuBar()
	{
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
                selectPieceColor();

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
        
        //m1.addActionListener(menu); 
        
        // add menubar to frame 
        frame.setJMenuBar(menuBar); 
		
	}

	public void  selectPieceColor(){
        Object[] text ={
                "Player 1", field3,
                "Player 2", field4,
        };
        int option = JOptionPane.showConfirmDialog(null, text, "Select your piece color", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION)
        {
            ImageIcon p1Image ;
            ImageIcon p2Image ;
        }
    }

public void newGamePopUp(){
   Object[] input ={
           "Player 1", field1,
           "Player 2", field2,
   };
    int option = JOptionPane.showConfirmDialog(null, input, "Enter all your values", JOptionPane.OK_CANCEL_OPTION);
    if (option == JOptionPane.OK_OPTION)
    {
        String p1 = field1.getText();
        String p2 = field2.getText();
    }


}



//bring out a pop-window to confirm the exit action
    public void Close() {

       int  choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?",
                "Confirmation", JOptionPane.YES_NO_OPTION);

        if (choice == 0) {
            System.out.println("Exit Button Clicked. Right? ");
            frame.setVisible(false);
            frame.dispose();
        }
    }

	public void CreateGrid()
	{
		
		board = new Board();
		panel.removeAll();

		white = new ImageIcon("white.png");
		image = white.getImage(); // transform it
        scaledImage = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		white = new ImageIcon(scaledImage);  // transform it back
		
		panel.setLayout(new GridLayout(7, 7));
		slots = new JLabel[6][7];
        buttons = new JButton[7];
		buttons[0] = new JButton("1");
		buttons[1]= new JButton("2");
        buttons[2]= new JButton("3");
        buttons[3]= new JButton("4");
        buttons[4]= new JButton("5");
        buttons[5]= new JButton("6");
        buttons[6]= new JButton("7");
        panel.add(buttons[0]);
        panel.add(buttons[1]);
        panel.add(buttons[2]);
        panel.add(buttons[3]);
        panel.add(buttons[4]);
        panel.add(buttons[5]);
        panel.add(buttons[6]);
        
        int max=0;
      
        for(int i = 0; i < 7; i++){
          buttons[i].setActionCommand("" + i);
          buttons[i].addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  int a = Integer.parseInt(e.getActionCommand());
                  int y = board.CheckColumn(a);
                 // int c=0;
                  //int d=0;
                  InputPiece(y, a);
                  board.ChangePlayer();
                  
                  CoreLogic.GameOver(CoreLogic.WinHorizontal());
                  CoreLogic.GameOver(CoreLogic.WinVertical());
                  CoreLogic.GameOver(CoreLogic.WinDiagonal());
                  
                 
                  //coreLogic.gameover();
                  //if(){
                    //  buttons[0].setEnabled(false);

                  //}
                 // coreLogic.gameover();


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
		
		frame.setContentPane(panel);
        frame.setSize(700, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	
	
	public void InputPiece(int x, int y)
	{
        black = new ImageIcon("black.png");
        image = black.getImage(); // transform it
        scaledImage = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        black = new ImageIcon(scaledImage);  // transform it back

        yellow = new ImageIcon("yellow.png");
        image = yellow.getImage(); // transform it
        scaledImage = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        yellow = new ImageIcon(scaledImage);  // transform it back
        
		if(board.playerTurn == 1)
		{
			slots[x][y].setIcon(black);
		}
		
		else
		{
			slots[x][y].setIcon(yellow);
		}
		
		
	}
	
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

