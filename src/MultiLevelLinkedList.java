
public class MultiLevelLinkedList {

	private ColumnNode head;

	private class ColumnNode {

		private Object columnName;
		private ColumnNode right;
		private NumNode down;

		public ColumnNode(Object columnName) {
			this.columnName = columnName;
			right = null;
			down = null;
		}

		public Object getColumnName() {
			return columnName;
		}

		public void setColumnName(Object columnName) {
			this.columnName = columnName;
		}

		public ColumnNode getRight() {
			return right;
		}

		public void setRight(ColumnNode right) {
			this.right = right;
		}

		public NumNode getDown() {
			return down;
		}

		public void setDown(NumNode down) {
			this.down = down;
		}
	}

	private class NumNode {
		private Object number;
		private NumNode next;

		public NumNode(Object number) {
			this.number = number;
			next = null;
		}

		public Object getNumber() {
			return number;
		}

		public void setNumber(Object number) {
			this.number = number;
		}

		public NumNode getNext() {
			return next;
		}

		public void setNext(NumNode next) {
			this.next = next;
		}

	}

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

	public void addNumber(String column, Object number) {
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

	public void display() {

		if (head == null)
			System.out.println("linked list is empty");
		else {
			System.out.println("");
			ColumnNode temp = head;
			ColumnNode temp2 = temp.getRight();
			ColumnNode temp3 = temp2.getRight();
			ColumnNode temp4 = temp3.getRight();
			ColumnNode temp5 = temp4.getRight();

			System.out.print("   " + "C" + temp.getColumnName() + "   " + "C" + temp2.getColumnName() + "   " + "C"
					+ temp3.getColumnName() + "   " + "C" + temp4.getColumnName() + "   " + "C" + temp5.getColumnName()
					+ "\n");
			System.out.print("   --   --   --   --   -- \n");
			while (temp != null && temp2 != null && temp3 != null && temp4 != null && temp5 != null) {
				NumNode tempn = temp.getDown();
				NumNode tempn2 = temp2.getDown();
				NumNode tempn3 = temp3.getDown();
				NumNode tempn4 = temp4.getDown();
				NumNode tempn5 = temp5.getDown();

				while (tempn != null && tempn2 != null && tempn3 != null && tempn4 != null && tempn5 != null) {

					System.out.print("    " + tempn.getNumber());
					for (int j = 0; j < 3 - tempn.getNumber().toString().length(); j++) {
						System.out.print(" ");
					}
					System.out.print("  " + tempn2.getNumber());
					for (int j = 0; j < 3 - tempn2.getNumber().toString().length(); j++) {
						System.out.print(" ");
					}
					System.out.print("  " + tempn3.getNumber());
					for (int j = 0; j < 3 - tempn3.getNumber().toString().length(); j++) {
						System.out.print(" ");
					}
					System.out.print("  " + tempn4.getNumber());
					for (int j = 0; j < 3 - tempn4.getNumber().toString().length(); j++) {
						System.out.print(" ");
					}
					System.out.print("  " + tempn5.getNumber());
					for (int j = 0; j < 3 - tempn5.getNumber().toString().length(); j++) {
						System.out.print(" ");
					}
					System.out.println("\n");
					// System.out.print(" " + tempn.getNumber() + " " + tempn2.getNumber() + " " +
					// tempn3.getNumber() + " " + tempn4.getNumber() + " " +tempn5.getNumber() +
					// "\n");
					tempn = tempn.getNext();
					tempn2 = tempn2.getNext();
					tempn3 = tempn3.getNext();
					tempn4 = tempn4.getNext();
					tempn5 = tempn5.getNext();
				}
				temp = temp.getRight();
				temp2 = temp.getRight();
				temp3 = temp2.getRight();
				temp4 = temp3.getRight();
				temp5 = temp4.getRight();
			}

		}

	}

}
