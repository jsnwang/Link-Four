import javax.swing.*;  
import java.awt.*;

public class LinkFourView {
	
	JFrame frame = new JFrame("Link Four");
	JButton button;
	JPanel panel1 = new JPanel();
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
		
		
		ImageIcon black = new ImageIcon("black.png");
		Image image = black.getImage(); // transform it 
		Image scaledImage = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		black = new ImageIcon(scaledImage);  // transform it back
		
		ImageIcon yellow = new ImageIcon("black.png");
		image = yellow.getImage(); // transform it 
		scaledImage = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		yellow = new ImageIcon(scaledImage);  // transform it back

		panel1.setLayout(new GridBagLayout());

		
		button = new JButton("1");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel1.add(button, c);

		button = new JButton("2");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panel1.add(button, c);
		
		button = new JButton("3");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		panel1.add(button, c);
		
		button = new JButton("4");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 0;
		panel1.add(button, c);
		
		button = new JButton("5");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 0;
		panel1.add(button, c);
		
		button = new JButton("6");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 5;
		c.gridy = 0;
		panel1.add(button, c);
		
		button = new JButton("7");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 6;
		c.gridy = 0;
		panel1.add(button, c);
		
		for (int i = 0; i <= 6; i++)
		{
			for (int j = 1; j <= 6; j++)
			{
				label = new JLabel(black);
				label.setBorder(BorderFactory.createLineBorder(Color.black));
				c.fill = GridBagConstraints.HORIZONTAL;
				c.ipadx = 10;
				c.ipady = 10;
				c.gridx = i;
				c.gridy = j;
				panel1.add(label, c);
				
			}
		}
		
		CreatePlayerTags();
		
		frame.setResizable(false);
		frame.add(panel1);
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
