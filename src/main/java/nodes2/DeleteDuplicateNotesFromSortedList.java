package nodes2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class SinglyLinkedListNode {
	public int data;
	public SinglyLinkedListNode next;

	public SinglyLinkedListNode(int nodeData) {
		this.data = nodeData;
		this.next = null;
	}
}

class SinglyLinkedList {
	public SinglyLinkedListNode head;
	public SinglyLinkedListNode tail;

	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void insertNode(int nodeData) {
		SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

		if (this.head == null) {
			this.head = node;
		} else {
			this.tail.next = node;
		}

		this.tail = node;
	}
}

class SinglyLinkedListPrintHelper {
	public static void printList(SinglyLinkedListNode node, String sep) throws IOException {
		while (node != null) {
			System.out.println((node.data));

			node = node.next;

			if (node != null) {
				System.out.println(sep);
			}
		}
	}
}

class Result {

	/*
	 * Complete the 'removeDuplicates' function below.
	 *
	 * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
	 * The function accepts INTEGER_SINGLY_LINKED_LIST llist as parameter.
	 */

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode {
	 *     int data;
	 *     SinglyLinkedListNode next;
	 * }
	 *
	 */

	public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {
		SinglyLinkedListNode currentNode = llist;
		SinglyLinkedListNode prevNode = currentNode;

		while (currentNode != null) {
			if (prevNode.data == currentNode.data) {
				// we are on the tail
				if (currentNode.next == null) {
					prevNode.next = null;
				} else if (prevNode != null) {
					prevNode.next = currentNode.next;
					currentNode = prevNode;
				}
			}
			prevNode = currentNode;
			currentNode = currentNode.next;

		}
		return llist;
	}

}

public class DeleteDuplicateNotesFromSortedList {
	/*
	You are given the pointer to the head node of a sorted linked list, where the data in the nodes is in ascending order.
	 Delete nodes and return a sorted list with each distinct value in the original list.
	 The given head pointer may be null indicating that the list is empty.
	 Input
			1
			5
			1
			2
			2
			3
			4
	Expected Output
		1 2 3 4
	* */
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				SinglyLinkedList llist = new SinglyLinkedList();

				int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

				IntStream.range(0, llistCount).forEach(i -> {
					try {
						int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

						llist.insertNode(llistItem);
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}
				});

				SinglyLinkedListNode llist1 = Result.removeDuplicates(llist.head);

				SinglyLinkedListPrintHelper.printList(llist1, " ");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();

	}
}
