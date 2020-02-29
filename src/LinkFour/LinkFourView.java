package LinkFour;


import javax.swing.*;  
import java.awt.*;
import java.awt.event.*; 
import java.io.*; 
public class LinkFourView implements ActionListener {
	
    private JFrame frame = new JFrame("Link Four");
    private JLabel[][] slots;
    private JButton[] buttons;

    private int gridX = 7;
    private int gridY = 6;
	
    
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
	public void CreateGrid()
	{
		
		JPanel panel = (JPanel) frame.getContentPane();
		panel.removeAll();
		
		
		ImageIcon black = new ImageIcon("black.png");
		Image image = black.getImage(); // transform it 
		Image scaledImage = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		black = new ImageIcon(scaledImage);  // transform it back
		
		ImageIcon white = new ImageIcon("white.png");
		image = white.getImage(); // transform it 
		scaledImage = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		white = new ImageIcon(scaledImage);  // transform it back
		
		ImageIcon yellow = new ImageIcon("yellow.png");
		image = yellow.getImage(); // transform it 
		scaledImage = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		yellow = new ImageIcon(scaledImage);  // transform it back

		panel.setLayout(new GridLayout(gridX,gridY));
		slots = new JLabel[7][7];
        buttons = new JButton[10];
		
        for (int i = 1; i <= 7; i++)
        {
        	buttons[i] = new JButton(""+i);
        	panel.add(buttons[i]);
        }

		
		
        
        for (int i = 0; i < gridX; i++) {
            for (int j = 1; j <= gridY; j++) {
            	System.out.println(i +", " +j);
                slots[i][j] = new JLabel(white);
                slots[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                slots[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                panel.add(slots[i][j]);
            }
        }
		slots[0][1] = new JLabel(black);
		//panel.add(slots[0][1]);
		//CreatePlayerTags();
		
		frame.setContentPane(panel);
        frame.setSize(700, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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

