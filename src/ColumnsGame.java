import enigma.console.Console;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ColumnsGame {
	public static int keypr; // key pressed?
	public static int rkey; // key (for press/release)
	public static KeyListener klis;
	public static enigma.console.Console eng ;
	
	private static Box box ;
	public ColumnsGame(Console eng) throws InterruptedException {
		ColumnsGame.eng = eng;
		box = new Box(eng);
		box.numberGenerator();
		locateFirstThirty();
		
		while(true) {
			String input = keyList().toString();
			if(input.equalsIgnoreCase("B")) {
				box.representBoxElement();
			}
			reset();
			Thread.sleep(1000);
			box.hideBoxElement();
		}
	}


	public static void locateFirstThirty() {
        MultiLevelLinkedList columns = new MultiLevelLinkedList();
        SinglyLinkedList.Node temp = box.getSLL().getHead();
        for (int i = 1; i < 6; i++) {
            columns.addColumn(String.valueOf(i));        
            for (int j = 0; j < 6; j++) {                
                columns.addNumber(String.valueOf(i),temp.getData());
                temp = temp.getLink();
                
                
            }
            
        }
        columns.display();

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

		while (true) {

			try {
				Thread.sleep(200);
			} catch (Exception e) {
			}

			if (keypr == 1) { // if keyboard button pressed

				for (int i = 0; i < 1; i++) {
					if (rkey == KeyEvent.VK_B)
						return "B";
					if (rkey == KeyEvent.VK_X)
						return "X";
					if (rkey == KeyEvent.VK_ESCAPE)
						return 3;
				}
			}
		}
	}

	public static void reset() {
		keypr = 0; // last action
		rkey = 0;
		eng.getTextWindow().removeKeyListener(klis);
	}

}
