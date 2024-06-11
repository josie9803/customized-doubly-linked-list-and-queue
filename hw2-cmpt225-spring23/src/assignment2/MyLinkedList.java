package assignment2;

import java.util.NoSuchElementException;

/**
 *
 * This is a generic class representing a list of objects.
 * The operations on the list are as follows:
 * - adding and removing elements from the left and from the right.
 * - reversing the list
 * - obtaining the middle element
 * - getting the size of the list
 * 
 * **All operations must run in O(1) time.**
 */
public class MyLinkedList<T> {

	private class Node{
		T value; //only type of value that the node holds is generic, not the node itself
		Node next; //'reference' to next node/element in the list
		Node prev;
		public Node(T value){
			this.value = value;
		}
	}
	private Node head; //automatically null if not defined
	private Node tail;
	private Node middle;
	private int size;
	private boolean isReversed;
	/**
	 * The constructor creates an empty list
	 */
	public MyLinkedList() {
		this.size = 0;
		this.isReversed = false;
	}

	/**
	 * Adds the new item to the left of the list. 
	 */

	//1. create newNode then:
	//1.1. newNode.prev always null because will make this newNode become currentHead
	//1.2 need to check if list is empty

	//2. newNode.next = ???
	//2.1. if empty list, newNode.next = null, or can just do head = newNode
	//2.2. if not:
	// newNode.next = currentHead --> newNode points to the ADDRESS that currentHead pointing to
	// ==> then we do NOT copy and paste value between nodes

	//3. head.prev = newNode --> to make newNode become head
	// ==> if empty list don't need this step because newNode will become the head

	//4. set currentHead = newNode

	public void addLeft(T item) {
		Node newNode = new Node(item);
		// newNode.prev = null; //don't need this because Node created automatically sets its prev and next be null
		if (isEmpty()){ //which equals to this.head == null
			// newNode.next = null;
			this.tail = newNode;
        }
		else{
			newNode.next = this.head;
			this.head.prev = newNode;
        }
        this.head = newNode; //before doing this line, head was a null -> accessing to head.prev will be nullpointerexception
		this.size++;
	}

	/**
	 * Adds the new item to the right of the list. 
	 */
	public void addRight(T item) {
		Node newNode = new Node(item);
		if (isEmpty()){
			this.head = newNode;
        }
		else{
			newNode.prev = this.tail;
			this.tail.next = newNode;
		}
		this.tail = newNode;
		size++;
	}

	/**
	 * Removes the leftmost item from the list and returns it.
	 * If the list is empty, throws NoSuchElementException.
	 */
	public T removeLeft() {
		if (isEmpty()){
			throw new NoSuchElementException();
		}
		Node removedElement = this.head;
		if (this.size == 1){ //rmb the case list have 1 element left
			this.head = null;
			this.tail = null;
		}
		else {
			this.head = this.head.next;
			this.head.prev = null;
		}
		this.size--;
		return removedElement.value;
	}

	/**
	 * Removes the rightmost item from the list and returns it.
	 * If the list is empty, throws NoSuchElementException.
	 */
	public T removeRight() {
		if (isEmpty()){
			throw new NoSuchElementException();
		}
		Node removedElement = this.tail;
		if (this.size == 1){
			this.head = null;
			this.tail = null;
		}
		else {
			this.tail = this.tail.prev;
			this.tail.next = null;
		}
		this.size--;
		return removedElement.value;
	}


	/**
	 * Reverses the list
	 */
	//can not just simply swap head and tail here
	public void reverse() {
		isReversed = true;
	}

	/**
	 * Returns the item in the middle of the list.
	 * If the list is empty, throws NoSuchElementException.
	 */
	public T getMiddle() {
		return null;
	}

	/** 
	 * Returns the size of the list.
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Returns true if list is empty, and returns false otherwise.
	 */
	public boolean isEmpty() {
        return this.size == 0;
    }

}
