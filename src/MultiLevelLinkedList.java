
public class MultiLevelLinkedList {
	
	private ColumnNode head;
	
	private class ColumnNode{

		private Object columnName;
		private ColumnNode right;
		private NumNode down;
		
		public ColumnNode(Object columnName) {
			this.columnName = columnName;
			right=null;
			down=null;
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
	
	private class NumNode{
		private Object number;
		private NumNode next;
		
		public NumNode(Object number) {
			this.number = number;
			next=null;
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
		if(head==null) {
			ColumnNode colNode = new ColumnNode(columnName);
			head = colNode;
		}else {
			ColumnNode temp = head;
			while(temp.getRight() != null) 
				temp = temp.getRight();
			ColumnNode colNode = new ColumnNode(columnName);
			temp.setRight(colNode);
		}
	}
	
	public void addNumber(String column , int number) {
		if(head==null)
			System.out.println("HEAD IS NULL");
		else {
			ColumnNode temp = head;
			while(temp!= null) {
				if(column.equals(temp.getColumnName())) {
					NumNode temp2 = temp.getDown();
					if(temp2 == null) {
						NumNode newNode = new NumNode(number);
						temp.setDown(newNode);
					}else {
						while(temp2.getNext() != null)
							temp2=temp2.getNext();
						NumNode newnode = new NumNode(number);
						temp2.setNext(newnode);
					}
				}
				temp = temp.getRight();
			}
		}
	}
	
	public void display() {
		if(head==null)
			System.out.println("linked list is empty");
		else {
			ColumnNode temp = head;
			while(temp!=null) {
				System.out.print(temp.getColumnName() + " --> ");
				NumNode temp2 = temp.getDown();
				while(temp2!=null) {
					System.out.print(temp2.getNumber()+ " ");
					temp2 = temp2.getNext();
				}
				temp=temp.getRight();
				System.out.println();
			}
		}
		
	}
	
	
}
