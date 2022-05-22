import enigma.core.Enigma;

public class MultiLevelLinkedList {
	private MultiLevelLinkedList MLL;
	public ColumnNode head;
	enigma.console.Console eng =Enigma.getConsole("Columns Game", 40, 25, 30);

	public void addColumn(String columnName) {
		if (head == null) {
			ColumnNode colNode = new ColumnNode(columnName);
			head = colNode;
		} else {
			ColumnNode temp = head;
			while (temp.getRight() != null)
				temp = temp.getRight();
			ColumnNode colNode = new ColumnNode(columnName);
			temp.setRight(colNode);
		}
	}

	public void addNumber(String column, int number) {
		if (head == null)
			System.out.println("HEAD IS NULL");
		else {
			ColumnNode temp = head;
			while (temp != null) {
				if (column.equals(temp.getColumnName())) {
					NumNode temp2 = temp.getDown();
					if (temp2 == null) {
						NumNode newNode = new NumNode(number);
						temp.setDown(newNode);
					} else {
						while (temp2.getNext() != null)
							temp2 = temp2.getNext();
						NumNode newnode = new NumNode(number);
						temp2.setNext(newnode);
					}
				}
				temp = temp.getRight();
			}
		}
	}
	public ColumnNode getHead() {
		return head;
		
	}
	public int sizeColumns() {
		int count = 0;
		if (head == null)
			System.out.println("linked list is empty");
		else {
			ColumnNode temp = head;
			while (temp != null) {
				count++;
				temp = temp.getRight();
			}
		}
		return count;
	}

	

	public void display4() { // vertical print 
		if (head == null)
			System.out.println("linked list is empty");
		else {
			ColumnNode temp = head;
			int x = 6;
			int y = 0;
			int z = 6;
			int k = 4;
			while (temp != null) {
				eng.getTextWindow().setCursorPosition(x, 2);
				System.out.print("C" + temp.getColumnName() + "\n      --   --   --   --   -- ");
				NumNode temp2 = temp.getDown();
				while (temp2 != null) {
					eng.getTextWindow().setCursorPosition(z, k);
					System.out.print((int) temp2.getNumber());
					temp2 = temp2.getNext();
					k++;
				}
				temp = temp.getRight();
				System.out.println();
				k = 4;
				x += 5;
				z += 5;
			}
		}
	}	

}
