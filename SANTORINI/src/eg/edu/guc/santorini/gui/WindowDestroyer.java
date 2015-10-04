package eg.edu.guc.santorini.gui;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;


public class WindowDestroyer extends WindowAdapter
{
	public WindowDestroyer(ActionEvent e)
	{
		System.exit(0);
	}
}
