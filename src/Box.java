import java.util.Iterator;
import java.util.Random;

public class Box {

	private SinglyLinkedList singleLinkedList;

	public Box() {
		singleLinkedList = new SinglyLinkedList();
	}

	public void numberGenerator() {
		int content = 1;
		for (int i = 0; i < 50 ; i++) {
			singleLinkedList.Add(content);
			content++;
			if (content % 10 == 1)
				content = 1;
		}
		singleLinkedList.display();
		System.out.println();
		for (int i = 0; i < 1000; i++) {
			shuffle();
		}
		singleLinkedList.display();
	}

	public void shuffle() {
		
		Random random = new Random();
		int random_1 = random.nextInt(51);
		int random_2 = random.nextInt(51);
		while(random_1==random_2) {
			random_2 = random.nextInt(51);
		}
		
		SinglyLinkedList.Node first_node  = singleLinkedList.getHead();
		SinglyLinkedList.Node second_node  = singleLinkedList.getHead();

		// select first node
		for (int i = 1; i<random_1-1; i++) {
			first_node = first_node.getLink();
		}
		
		// select second node
		for (int i = 1; i<random_2-1; i++) {
			second_node = second_node.getLink();
		}
		
		SinglyLinkedList.Node tempNode = singleLinkedList.setNode(first_node.getLink().getData(),second_node.getLink().getLink());
		SinglyLinkedList.Node tempNode2 = singleLinkedList.setNode(second_node.getLink().getData(),first_node.getLink().getLink());
		first_node.setLink(tempNode2);
		second_node.setLink(tempNode);

	}
}
