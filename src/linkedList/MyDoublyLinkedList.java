package linkedList;

public class MyDoublyLinkedList {
	DoublyListNode head;
	DoublyListNode tail;
	int length = 0;

	class DoublyListNode {
		int val;
		DoublyListNode next, prev;

		DoublyListNode(int x) {
			val = x;
		}
	}

	public MyDoublyLinkedList() {
	}

	public int get(int index) {
		if (index >= length) {
			return -1;
		}
		DoublyListNode temp = head;
		int i = 0;
		while (i < index && temp.next != null) {
			temp = temp.next;

			i++;
		}
		return temp.val;
	}

	public void addAtHead(int val) {
		if (head == null) {
			head = new DoublyListNode(val);
			tail = head;
		} else {
			DoublyListNode temp = new DoublyListNode(val);
			temp.next = head;
			head.prev = temp;
			head = temp;
		}
		length++;
	}

	public void addAtTail(int val) {
		if (head == null) {
			head = new DoublyListNode(val);
			tail = head;
		} else {
			DoublyListNode temp = new DoublyListNode(val);
			temp.next = null;
			temp.prev = tail;
			tail.next = temp;
			tail = temp;
		}
		length++;
	}

	public void addAtIndex(int index, int val) {
		if (index > length)
			return;
		if (index == 0) {
			addAtHead(val);
			length++;
			return;
		}

		if (index == length) {
			addAtTail(val);
			length++;
			return;
		}

		length++;
		int i = 0;
		index -= 1;
		DoublyListNode temp = head;
		while (i < index) {
			temp = temp.next;
			i++;
		}

		DoublyListNode previous = temp.prev;
		DoublyListNode newNode = new DoublyListNode(val);
		newNode.next = temp;
		newNode.prev = previous;
		previous.next = newNode;
		temp.prev = newNode;

	}

	public void deleteAtIndex(int index) {
		if (index < 0 || index > length)
			return;

		if (length == 1) {
			head = null;
			tail = null;
			length--;
			return;
		}

		if (index == 0) {
			head.next.prev = null;
			head = head.next;
			length--;
			return;
		}

		if (index == length - 1) {
			tail.prev.next = null;
			tail = tail.prev;
			length--;
			return;
		}

		length--;
		int i = 0;
		index -= 1;
		DoublyListNode temp = head;
		while (i < index) {
			temp = temp.next;
			i++;
		}

		DoublyListNode previous = temp.prev;
		DoublyListNode nextDoublyNode = temp.next;

		previous.next = nextDoublyNode;
		nextDoublyNode.prev = previous;
	}

	public void printLinkedList(DoublyListNode head) {
		DoublyListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + "\t");
			temp = temp.next;
		}
	}
}