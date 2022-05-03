
public class DoublyLinkedList {
	private Node head;
	private Node tail;

	public DoublyLinkedList() {
		head = null;
		tail = null;
	}

	private class Node {
		Object data;
		Node prev;
		Node next;

		public Node(Object data) {
			this.data = data;
			prev = null;
			next = null;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node previous) {
			this.prev = previous;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

	public void add(Object dataToAdd) {
		if (head == null && tail == null) {
			Node newNode = new Node(dataToAdd);
			head = newNode; /* pointing the first node */
			tail = newNode; /* pointing the last node */
		} else {
			Node newnode = new Node(dataToAdd);
			newnode.setPrev(tail);
			tail.setNext(newnode);
			tail = newnode;

		}
	}
}
