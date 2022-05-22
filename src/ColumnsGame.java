import enigma.console.Console;
import enigma.console.TextAttributes;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ColumnsGame {
	public static int keypr; // key pressed?
	public static int rkey; // key (for press/release)
	public static KeyListener klis;
	public static enigma.console.Console eng;
	public static MultiLevelLinkedList columns = new MultiLevelLinkedList();
	private HighScoreTable highScoreTable = new HighScoreTable();
	private static Box box;

	public ColumnsGame(Console eng) throws InterruptedException {
		ColumnsGame.eng = eng;
		box = new Box(eng);
		box.numberGenerator();
		locateFirstThirty();
		columns.display4();
		
		int x = 6;
		int y = 0;
		int z = 6;
		int k = 4;
		int selected_element = 0;
		NumNode temp2 = null;
		// printHighScoreTable(); kayma var, sort düzeltilecek
		ColumnNode temp = columns.getHead();
		boolean columnSelected = false;
		while (true) {
			red();
			eng.getTextWindow().setCursorPosition(x, 2);
			System.out.print("C" + temp.getColumnName());
			String input = keyList().toString();

			if (input.equalsIgnoreCase("B")) {
				if (selected_element == 0)
					selected_element = (int) box.representBoxElement();
				reset();

			} else if (input.equalsIgnoreCase("X")) {
				columns.addNumber(temp.getColumnName().toString(), selected_element);
				selected_element = 0;

				x = 6;
				z = 6;
				k = 4;
				red();
				eng.getTextWindow().setCursorPosition(x, 2);
				temp = columns.getHead();
				System.out.print("C" + temp.getColumnName());
				box.hideBoxElement();
				reset();
			}

			else if (input.equalsIgnoreCase("E") && !columnSelected) {
				temp2 = temp.getDown();
				yellow();
				if (temp2 != null) {
					eng.getTextWindow().setCursorPosition(z, k);
					System.out.print((int) temp2.getNumber());

				}
				columnSelected = true;
				reset();

			}

			else if (input.equalsIgnoreCase("D") && temp2 != null) {
				white();
				eng.getTextWindow().setCursorPosition(z, k);
				System.out.print((int) temp2.getNumber());
				reset();
				temp2 = temp2.getNext();
				k++;
				yellow();
				eng.getTextWindow().setCursorPosition(z, k);
				System.out.print((int) temp2.getNumber());

			}

			else if (input.equalsIgnoreCase("Ex")) {
				white();
				eng.getTextWindow().setCursorPosition(z, k);
				System.out.print((int) temp2.getNumber());
				eng.getTextWindow().setCursorPosition(x, 2);
				System.out.print("C" + temp.getColumnName());
				columnSelected = false;
				reset();
				x = 6;
				z = 6;
				k = 4;
				red();
				eng.getTextWindow().setCursorPosition(x, 2);
				temp = columns.getHead();
				System.out.print("C" + temp.getColumnName());

			}

			else if (input.equalsIgnoreCase("R") && !columnSelected) {
				white();
				eng.getTextWindow().setCursorPosition(x, 2);
				System.out.print("C" + temp.getColumnName());

				temp = temp.getRight();
				x += 5;
				z += 5;
				reset();
				red();
				eng.getTextWindow().setCursorPosition(x, 2);
				System.out.print("C" + temp.getColumnName());

			} else if (input.equalsIgnoreCase("N"))
				reset();
			white();
			columns.display4();
		}

	}

	public static MultiLevelLinkedList locateFirstThirty() {
		SingleNode temp = box.getSLL().getHead();
		for (int i = 1; i < 6; i++) {
			columns.addColumn(String.valueOf(i));
			for (int j = 0; j < 6; j++) {
				columns.addNumber(String.valueOf(i), (int) temp.getData());
				temp = temp.getLink();

			}

		}
		return columns;
	}

	public static Object keyList() {

		klis = new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				if (keypr == 0) {
					keypr = 1;
					rkey = e.getKeyCode();
				}
			}
		};
		eng.getTextWindow().addKeyListener(klis);
		int x = 0;
		int y = 0;
		while (true) {
			eng.getTextWindow().setCursorPosition(x, y);
			try {
				Thread.sleep(200);
			} catch (Exception e) {
			}

			if (keypr == 1) { // if keyboard button pressed

				for (int i = 0; i < 1; i++) {
					// if (rkey == KeyEvent.VK_UP && y > 0)
					// return "U";
					if (rkey == KeyEvent.VK_DOWN)
						return "D";
					// if (rkey == KeyEvent.VK_LEFT && x>0)
					// return "L";
					if (rkey == KeyEvent.VK_RIGHT && x < 5)
						return "R";
					if (rkey == KeyEvent.VK_B)
						return "B";
					if (rkey == KeyEvent.VK_X)
						return "X";
					if (rkey == KeyEvent.VK_ENTER)
						return "E";
					if (rkey == KeyEvent.VK_ESCAPE)
						return "Ex";
					else
						return "N";
				}
			}
		}
	}

	public static void reset() {
		keypr = 0; // last action
		rkey = 0;

	}

	public void blue() {
		TextAttributes write = new TextAttributes(Color.blue);
		eng.setTextAttributes(write);
	}

	public void white() {
		TextAttributes write = new TextAttributes(Color.white);
		eng.setTextAttributes(write);
	}

	public void green() {
		TextAttributes write = new TextAttributes(Color.green);
		eng.setTextAttributes(write);
	}

	public void red() {
		TextAttributes write = new TextAttributes(Color.red);
		eng.setTextAttributes(write);
	}

	public void yellow() {
		TextAttributes write = new TextAttributes(Color.yellow);
		eng.setTextAttributes(write);
	}

	public void magenta() {
		TextAttributes write = new TextAttributes(Color.magenta);
		eng.setTextAttributes(write);
	}

	private void printHighScoreTable() {
		
		highScoreTable.printScores();
		

	}

}
