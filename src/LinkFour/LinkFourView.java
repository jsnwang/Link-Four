package LinkFour;


import javax.swing.*;  
import java.awt.*;
import java.awt.event.*; 
import java.io.*;
import java.security.BasicPermission;

public class LinkFourView implements ActionListener {
	
    private JFrame frame = new JFrame("Link Four");
    public JLabel[][] slots;
    public JButton[] buttons;
    public String p1 = "Player 1";
    public String p2 = "Player 2";
    public ImageIcon black;
    public ImageIcon yellow;
    public ImageIcon white;
    
    Image image;
    Image scaledImage;

    private int gridX = 7;
    private int gridY = 6;
	
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
                CreateGrid();
            }
        });
        menu.add(m); 
        
        m = new JMenuItem("Exit"); 
        m.setMnemonic(KeyEvent.VK_E);
        m.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });
        menu.add(m);
        
        // add menu to menu bar 
        menuBar.add(menu); 
        
        menu = new JMenu("Help"); 
        menu.setMnemonic(KeyEvent.VK_H);
        
        m = new JMenuItem("About"); 
        m.setMnemonic(KeyEvent.VK_A);
        menu.add(m); 
        menuBar.add(menu); 
        
        //m1.addActionListener(menu); 
        
        // add menubar to frame 
        frame.setJMenuBar(menuBar); 
		
	}

	
//	public void setPlayerColor() {
    //  }


	public void CreateGrid()
	{
		
		JPanel panel = (JPanel) frame.getContentPane();
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
        
      for(int i = 0; i < 7; i++){
          buttons[i].setActionCommand("" + i);
          buttons[i].addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  int a = Integer.parseInt(e.getActionCommand());
                  int y = board.CheckColumn(a);
                  InputPiece(y, a);
                  board.ChangePlayer();
                  System.out.println(a);
                  System.out.println(y);
              }
          });
      }

        
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
            	System.out.println(i +", " +j);
                slots[i][j] = new JLabel(white);
                slots[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                slots[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                panel.add(slots[i][j]);
            }
        }
		
		frame.setContentPane(panel);
        frame.setSize(700, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
	/*
	public void CreatePlayerTags()
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
        CreateGrid();
  
        // set the label to the menuItem that is selected 
       
    } 
} 

