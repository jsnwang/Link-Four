import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class LinkFourView {
	private int rowSize=7;
	private int colSize=6;
	private JLabel[][] spots;
	JFrame frame = new JFrame("Link Four");
	JPanel panel1 = (JPanel) frame.getContentPane();
	JLabel label;
	GridBagConstraints c = new GridBagConstraints();
	
	public void CreateMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu menu;
		JMenuItem m;
		  
        // create a menubar 
        menuBar = new JMenuBar(); 
  
        // create File Menu
        menu = new JMenu("File"); 
  
        // create menuitems 
        m = new JMenuItem("New"); 
        menu.add(m); 
        
        m = new JMenuItem("Exit"); 
        menu.add(m);
        
        // add menu to menu bar 
        menuBar.add(menu); 
        
        menu = new JMenu("Help"); 
        m = new JMenuItem("About"); 
        menu.add(m); 
        menuBar.add(menu);
  
        // add menubar to frame 
        frame.setJMenuBar(menuBar);

	}

	public void CreateGrid()
	{
		JButton button;
		Board gameBoard = new Board();
		panel1.setLayout(new GridLayout(rowSize, colSize +1));
		spots = new JLabel[rowSize][colSize];

		for (int csize =0; csize < colSize; csize++){
			for(int rsize =0; rsize<rsize; rsize++){
				spots[rsize][csize] = new JLabel();
				spots[rsize][csize].setHorizontalAlignment(SwingConstants.CENTER);
				spots[rsize][csize].setBorder(BorderFactory.createLineBorder(Color.black));
				panel1.add(spots[rsize][csize]);
			}
		}


		CreatePlayerTags();
		frame.setContentPane(panel1);
		frame.setSize(700, 600);
		//frame.add(panel1);
		frame.pack();
		frame.setVisible(true);
	}

	public void CreatePlayerTags()
	{
		JPanel panel2 = new JPanel();
		label = new JLabel("Player 1 Wins:", SwingConstants.CENTER);
		label.setBorder(BorderFactory.createLineBorder(Color.black));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weighty = 10.0;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 7;
		panel1.add(label, c);
		label = new JLabel("Player 2 Wins:", SwingConstants.CENTER);
		label.setBorder(BorderFactory.createLineBorder(Color.black));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weighty = 10.0;
		c.gridwidth = 2;
		c.gridx = 4;
		c.gridy = 7;
		panel1.add(label, c);
	}
}
