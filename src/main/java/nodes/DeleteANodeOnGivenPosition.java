package nodes;

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
	 * Complete the 'deleteNode' function below.
	 *
	 * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
	 * The function accepts following parameters:
	 *  1. INTEGER_SINGLY_LINKED_LIST llist
	 *  2. INTEGER position
	 */

	/*
	 * For your reference:
	 *
	 * nodes.SinglyLinkedListNode {
	 *     int data;
	 *     nodes.SinglyLinkedListNode next;
	 * }
	 *
	 */

	public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
		if (position == 0)
			return llist.next;

		SinglyLinkedListNode currentNode = llist;
		SinglyLinkedListNode prevNode = currentNode;
		int currentPosition =0;
		while (currentNode != null) {
			if (currentPosition == position) {
				prevNode.next = currentNode.next;
				currentNode = prevNode;
			}
			currentPosition++;
			prevNode = currentNode;
			currentNode = currentNode.next;

		}
		return llist;
	}

}

public class DeleteANodeOnGivenPosition {
	/*Delete the node at a given position in a linked list and return a reference to the head node.
	The head is at position 0. The list may be empty after you delete the node. In that case, return a null value.
	Sample input:
		8
		20
		6
		2
		19
		7
		4
		15
		9
		3
	Expected Output:
		20 6 2 7 4 15 9
	url: https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem
	* */
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


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

		int position = Integer.parseInt(bufferedReader.readLine().trim());

		SinglyLinkedListNode llist1 = Result.deleteNode(llist.head, position);

		SinglyLinkedListPrintHelper.printList(llist1, " ");


		bufferedReader.close();

	}
}
