
public class SinglyLinkedList {
	private Node head;

	public class Node {

		Object data;
		Node link;

		public Node(Object data) {
			this.data = data;
			link = null;
		}

		public Object getData() {
			return data;
		}

		public Node getLink() {
			return link;
		}

		public void setLink(Node link) {
			this.link = link;
		}

	}

	public Node setNode(Object data, Node link) {
		Node node = new Node(data);
		node.setLink(link);
		return node;
	}

	public Node getHead() {
		return head;
	}

	public void Add(Object data) {
		if (head == null) {
			Node newNode = new Node(data);
			head = newNode;
		} else {
			Node temp = head;
			while (temp.getLink() != null) {
				temp = temp.getLink();
			}
			Node newNode = new Node(data);
			temp.setLink(newNode);
		}
	}

	public int size() {
		if (head == null)
			return 0;
		else {
			int count = 0;

			Node temp = head;

			while (temp != null) {
				temp = temp.getLink();
				count++;
			}

			return count;
		}
	}

	public void display() {
		if (head == null)
			System.out.println("List is Empty!");
		else {
			Node temp = head;

			while (temp != null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getLink();
			}
		}
	}

	public void remove(Object dataToDelete) {
		if (head == null)
			System.out.println("Linked list is empty");
		else {
			while ((Integer) head.getData() == (Integer) dataToDelete)
				head = head.getLink();

			Node temp = head;
			Node previous = null;
			while (temp != null) {
				if ((Integer) temp.getData() == (Integer) dataToDelete) {
					previous.setLink(temp.getLink());
					temp = previous;
				}
				previous = temp;
				temp = temp.getLink();
			}
		}
	}

	public int findMax() {
		if (head == null) {
			System.err.println("Linked List is empty");
			return Integer.MIN_VALUE;
		} else {
			int maxVal = Integer.MIN_VALUE;
			Node temp = head;

			while (temp != null) {
				if ((int) temp.getData() > maxVal) {
					maxVal = (int) temp.getData();
				}
				temp = temp.getLink();
			}
			return maxVal;
		}
	}

	public boolean search(Object data) {
		if (head == null) {
			System.out.println("List is empty");
			return false;
		} else {
			Node temp = head;
			while (temp != null) {
				if ((Integer) temp.getData() == (Integer) data)
					return true;
				temp = temp.getLink();
			}
			return false;
		}
	}

	public boolean equality() {
		if (head == null) {
			System.out.println("List is empty!");
			return true;
		} else {
			int firstHalf = 0;
			int secondHalf = 0;
			int count = size();
			if (count % 2 != 0) {
				System.out.println("The element count should be even");
				return false;
			} else {
				Node temp = head;
				for (int i = 0; i < count; i++) {
					if (i > count / 2)
						firstHalf += Integer.parseInt(temp.getData().toString());
					else
						secondHalf += Integer.parseInt(temp.getData().toString());
					temp = temp.getLink();
				}
			}
			if (firstHalf == secondHalf)
				return true;
			else
				return false;
		}

	}

}