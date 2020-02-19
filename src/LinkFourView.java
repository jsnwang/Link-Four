import javax.swing.*;  

public class LinkFourView {
	
	public void CreateView()
	{
		JFrame frame = new JFrame();
		JButton button = new JButton("Button");
		
		button.setBounds(130,100,100, 40);
		
		frame.add(button);
		
		frame.setSize(400, 500);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}
