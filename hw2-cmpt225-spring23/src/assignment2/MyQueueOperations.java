package assignment2;

import basicdatastructures.queue.*;
import basicdatastructures.stack.Stack;
import basicdatastructures.stack.StackLinkedListBased;

public class MyQueueOperations {
	/**
	 * Returns the number of elements in q.
	 */
	public static <T> int size(Queue<T> q) {
		int count = 0;
		Queue<T> temp = clone(q); //to preserve orig queue
        while (!temp.isEmpty()) {
            temp.dequeue();
            count++;
        }
        return count;
	}

	/**
	 * Returns a copy of orig. The items are copied from orig to the new queue using
	 * = operator. For the concrete type of the returned object, you may use either
	 * QueueArrayBased or QueueLinkedListBased, up to you.
	 */
	public static <T> Queue<T> clone(Queue<T> orig) {
		Queue<T> result = new QueueLinkedListBased<>();
		Queue<T> temp = new QueueLinkedListBased<>();

		while (!orig.isEmpty()) {
			T element = orig.dequeue();
			temp.enqueue(element);
			result.enqueue(element);
		}

		while (!temp.isEmpty()) {
			orig.enqueue(temp.dequeue());
		}

		return result;
	}

	/**
	 * Reverses the order of the elements in q.
	 */
	public static <T> void reverse(Queue<T> q) {
		Stack<T> stack = new StackLinkedListBased<>();
		while (!q.isEmpty()){
			stack.push(q.dequeue());
		}
		while (!stack.isEmpty()){
			q.enqueue(stack.pop());
		}
	}

	/**
	 * Checks if the two queues have the same items in the same order. The items in
	 * the queues are compared using == operator.
	 */
	public static <T> boolean areEqual(Queue<T> q1, Queue<T> q2) {
		if (size(q1) != size(q2)) {
			return false;
		}

		Queue<T> temp1 = clone(q1);
		Queue<T> temp2 = clone(q2);

		while (!temp1.isEmpty() && !temp2.isEmpty()) {
			T element1 = temp1.dequeue();
			T element2 = temp2.dequeue();
			if (element1 != element2) {
				return false;
			}
		}
		return temp1.isEmpty() && temp2.isEmpty();
	}
}
