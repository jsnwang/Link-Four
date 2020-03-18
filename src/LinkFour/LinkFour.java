package LinkFour;

import javax.swing.*;
import java.awt.event.*;

public class LinkFour {
	public static void main(String[] args)
	{
		LinkFourView view = new LinkFourView();
		view.CreateMenuBar();
		view.CreateGrid();


		view.frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				view.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				view.Close();
			}

		});

	}


}
