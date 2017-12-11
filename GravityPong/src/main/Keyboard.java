package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

//Keyboard Listener Class
public class Keyboard implements KeyListener
{
	
	private final Set<Character> pressed = new HashSet<Character>();

	@Override
	public synchronized void keyPressed(KeyEvent e)
	{
		pressed.add(e.getKeyChar());
		System.out.println("Add");
		if (pressed.size() > 1)
		{
			
			// More than one key is currently pressed.
			// Iterate over pressed to get the keys.
		}

	}

	@Override
	public synchronized void keyReleased(KeyEvent e)
	{
		pressed.remove(e.getKeyChar());
		System.out.println("Remove");
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	public int SizeOfPressed()
	{
		return (int)pressed.size();
	}


}
