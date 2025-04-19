package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 *
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel.
	 * 
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 */
	JFrame frame;
	JPanel panel;
	JLabel label;
	Stack<Character> collin = new Stack<Character>();
	StringBuilder text = new StringBuilder();

	public void builldUI() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		frame.add(panel);
		frame.setVisible(true);
		label.setVisible(true);
		panel.setVisible(true);
		panel.add(label);
		
		frame.setSize(400,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		panel.addKeyListener(this);	
		
		frame.pack();
		
	}

	public static void main(String[] args) {
		_02_TextUndoRedo m = new _02_TextUndoRedo();
		m.builldUI();

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int keycode = arg0.getKeyCode();
		char w = arg0.getKeyChar();
		text.append(w);
		System.out.println(text.length());
		label.setText(text.toString());
		
		  if (keycode == KeyEvent.VK_BACK_SPACE && text.length() > 0) {
	            char deletedChar = text.charAt(text.length() - 1);  
	            text.deleteCharAt(text.length() - 1);  
	            collin.push(deletedChar);  
	        }
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
