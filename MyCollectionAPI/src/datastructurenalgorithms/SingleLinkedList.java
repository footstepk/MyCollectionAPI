package datastructurenalgorithms;

/**
 * Class to represent a linked list with a link from
 * each node to the next node.
 * @author KokHeng
 *
 * @param <E> the standing by for type whose implementing it.
 */
public class SingleLinkedList<E> {

	/** An inner class reference the data node. */

	private static class Node<E> {

		/** The global data fields. */

		//references the data item in the node
		private E data;
		// the node link to the next reference node
		private Node<E> next;

		/*
		 * Construct the node with reference the data item
		 * @param dataItem the reference data item in the node
		 */
		private Node(E dataItem) {
			data = dataItem;
			next = null;
		}

		/*
		 * Construct the node with reference the data item,
		 * with the next reference node.
		 * @param dataItem the reference data item in the node
		 * @param nextNode the reference of next node
		 */
		private Node(E dataItem, Node<E> nextNode) {
			data = dataItem;
			next = nextNode;
		}

	}

	// the reference of the list of head node  
	private Node<E> head = null;
	// the number data items in the node
	private int numItem;
	/** Retrieve number of items in the node. */
	public int size() {
		return numItem;
	}

	/** Ensure the head node is null and return always true. */
	public boolean isEmpty() {
		return (head == null);
	}
	/*
	 * Add an item in a time to  the front of the nlist.
	 * @param item the data item to be adding in. 
	 */
	public void addFirst(E item) {
		head = new Node<E>(item, head);
		numItem++;
	}

	/**
	 * Find the node at a specified position
	 * @param index the position of the node sought @returns The node at index or null if it does not exist 
	 * @return the node at the position
	 */
	private Node<E> getNode(int index) {
		Node<E> tempNode = head;
		for(int i = 0; i < index && tempNode != null; i=i+1) {
			tempNode = tempNode.next;
		}
		return tempNode;
	}

	/**
	 * Get the data value at index
	 * @param index The position of the element to return
	 * @returns the data at index
	 * @throws IndexOutOfBoundsException if index is out of range
	 */
	public E get(int index) {
		if(index < 0 || index >= numItem) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<E> tempNode = getNode(index);
		return tempNode.data;
	}

	/**
	 * Set the data value at index
	 * @param index The position of the item to change
	 * @param newValue The new value
	 * @returns the data value previously at index
	 * @throws IndexOutOfBoundsException if index is out of range
	 */
	public E set(int index, E newValue) {
		if(index < 0 || index >= numItem) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<E> tempNode = getNode(index);
		E result = tempNode.data;
		tempNode.data = newValue;
		return result;
	}

	/**
	 * Add item to the end of the list
	 * @param item The item to be added
	 * @returns true (as specified by the Collection interface) 
	 */
	public boolean add(E anEntry) {
		add(numItem, anEntry);
		return true;
	}

	/**
	 * Insert the specified item at index
	 * @param index The position where item is to be inserted
	 * @param item The item to be inserted
	 * @throws IndexOutOfBoundsException if index is out of range 
	 */
	public void add(int index, E anEntry) {
		if(index < 0 || index > numItem) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if(index == 0) {
			addFirst(anEntry);
		}
		else {
			Node<E> tempNode = getNode(index - 1);
			addAfter(tempNode, anEntry);
		}
	}

	/**
	 * Remove the first occurrence of element item.
	 * @param item The item to be removed
	 * @return true if item is found and removed; otherwise, return false.
	 */
	public boolean remove(E target) {
		Node<E> tempNode = head; // target if present occurs from node tempNode on
		Node<E> pred = null; // predecessor of node temptNode (if any) 
		while(tempNode != null && !tempNode.data.equals(target)) {
			pred = tempNode;
			tempNode = tempNode.next;
		}
		// target is present iff node tempNode !=null
		// & tempNode !=null => target in node tempNode
		if(tempNode == null) {
			return false; // target not found here!
		}
		if(tempNode == head) {
			head = head.next; // target in node tempNode at front
		}
		else {
			pred.next = tempNode.next; // target in node tempNode, not at front
		}
		// remove target from the list
		numItem--;
		return true;
	}

	/**
	 * Add a node after a given node.
	 * @param item the data item to be added
	 * @param node the node preceding the new item
	 */
	private void addAfter(Node<E> node, E item) {
		node.next = new Node<E>(item, node.next);
		numItem++;
	}

	/**
	 * Remove the node after a given node
	 * @param node the node before the one to be removed
	 * @returns the data item from the removed node, or null if there is no node to be removed  
	 */
	private E removeAfter(Node<E> node) {
		Node<E> tempNode = node.next;
		if(tempNode != null) {
			node.next = tempNode.next;
			numItem--;
			return tempNode.data;
		}
		else {
			return null;
		}
	}
	/**
	 * Remove the first node from the list
	 * @returns the removed node's data item, or null if the list is empty 
	 */
	private E removeFirst() {
		Node<E> tempNode = head;
		if(head != null) {
			head = head.next;
		}
		// remove the old head, or null if the list is empty
		if(tempNode != null) {
			numItem--;
			return tempNode.data;
		}
		else {
			return null;
		}
	}
	/**
	 * Traversing the single linked list
	 * @returns the string representation of the single linked list
	 */
	/**public String toString() {
		Node<E> nodeRef = head;
		StringBuilder result = new StringBuilder();
		while(nodeRef != null) {
			result.append(nodeRef.data);
			if(nodeRef.next != null) {
				result.append(" ==> ");
			}
			nodeRef = nodeRef.next;
		}
		return result.toString();
	}*/

	/**
	 * Searching the node that contains the data item
	 * @param item the item to be searched for
	 * @returns -1 if item isn't found, or else 0 if item found in the list
	 */
	public int search(E item) {
		Node<E> tempNode = head;
		int index = 0;
		while(tempNode != null) {
			if(tempNode.data.equals(item))
				return index;
			index++;
			tempNode = tempNode.next;
		}
		return -1;
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		Node<E> temp = head; // remain searching from p
		while(temp != null) {
			result.append("{" + temp.data + "}");
			if(temp.next != null) {
				result.append(",\n");
			}
			temp = temp.next;
		}
		return result.toString();
	}

}
