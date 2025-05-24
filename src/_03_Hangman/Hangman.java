package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener{
	JPanel panel = new JPanel();
	StringBuilder currentGuess;
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	boolean found;
	int life  =  100000000;
	Stack<String> stack = new Stack<String>();
	String str;
	public static void main(String[] args) {
		Hangman h = new Hangman();
		h.start();
	}

	private void start() {
		// TODO Auto-generated method stub
		frame.addKeyListener(this);
		String response = JOptionPane
				.showInputDialog("pick a number less than " + Utilities.getTotalWordsInFile("dictionary.txt"));

		int r = Integer.parseInt(response);
		for (int i = 0; i < r; i++) {

			String random = Utilities.readRandomLineFromFile("dictionary.txt");
			if (!stack.contains(random)) {
				stack.push(random);

			}

		}
		frame.setSize(500, 500);
		panel.setSize(500, 500);
		frame.add(panel);
		panel.add(label);
		panel.setVisible(true);
		frame.setVisible(true);
		label.setVisible(true);
		str = stack.pop();
		currentGuess = new StringBuilder();	

	    for (int i = 0; i < str.length(); i++) {
	        currentGuess.append("_");
	    }
	    label.setText(currentGuess.toString());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		found = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c) {
			currentGuess.setCharAt(i, c);
			found = true;
			}
		}
		if(!found) {
			life--;
			JOptionPane.showMessageDialog(null,"You lost a life " + life);
		}
		 label.setText(currentGuess.toString());

		}	
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
