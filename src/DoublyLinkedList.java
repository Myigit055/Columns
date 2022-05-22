
public class DoublyLinkedList {
	private DoubleNode head;
	private DoubleNode tail;
	private int length;
	
	public DoublyLinkedList() {
		head = null;
		tail = null;
	}

	public DoubleNode getHead() {	
		return head;
	}

	public void add(Object dataToAdd) {
		if (head == null && tail == null) {
			DoubleNode newNode = new DoubleNode(dataToAdd);
			head = newNode; /* pointing the first node */
			tail = newNode; /* pointing the last node */
		} else {
			DoubleNode newnode = new DoubleNode(dataToAdd);
			newnode.setPrev(tail);
			tail.setNext(newnode);
			tail = newnode;

		}
		length++;
	}
	
	
	public void display() {
		if (head == null)
			System.out.println("List is Empty!");
		else {
			DoubleNode temp = head;

			while (temp != null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getNext();
			}
			System.out.println();
		}
	}
	

	public int length() {		
		return length;
	}
	
	public DoubleNode getIndex(int index) {
		DoubleNode temp = head;
        if (index > length() - 1) {
            return null;
        }

        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }

        return temp;
    }
	
	public synchronized void insertAtEnd(DoubleNode node) {
        if (head == null) {
            head = node;
        } else {
        	DoubleNode p, q;
            for (p = head; (q = p.getNext()) != null; p = q) {
            }
            p.setNext(node);
        }
        length++;
    }
	
	  
	
	public void insert(Object data, int position) {
        // fix the position
        if (position < 0) {
            position = 0;
        }
        if (position > length) {
            position = length;
        }

        // if the list is empty, make it be the only element
        if (head == null) {
            head = new DoubleNode(data);
        }
        // if adding at the front of the list...
        else if (position == 0) {
        	DoubleNode temp = new DoubleNode(data);
            temp.setNext(head);
            head = temp;
        }
        // else find the correct position and insert
        else {
        	DoubleNode temp = head;
            for (int i = 1; i < position; i += 1) {
                temp = temp.getNext();
            }
            DoubleNode newNode = new DoubleNode(data);
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
        // the list is now one value longer
        length += 1;
    }
	
	

	
	
	
	
}
