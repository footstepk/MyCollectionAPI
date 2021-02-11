package datastructureandalgorithms;

import java.util.ArrayList;

/**
 * MySet Class to represent a doubly linked list with a link from
 * each node to the next node.
 * @author KokHeng
 *
 * @param <U> the standing by for type whose implementing it.
 */

public class MyTree<U extends Comparable<U>> {
	
	private static class Node<U> {

		private U item;
		private Node<U> left;
		private Node<U> right;

		public Node(U items) {
			item = items;
		}

		public Node(U items, Node<U> lefts, Node<U> rights) {
			item = items;
			left = lefts;
			right = rights;
		}

	}

	private int numItem = 0;
	private Node<U> root;

	public MyTree() {
		root = null;
	}

	public int size() {
		return numItem;
	}

	public boolean isEmpty() {
		return (root == null);
	}

	public void add(U item) {
			root = add(root, item);
	}

	private Node<U> add(Node<U> p, U item) {
		// Insert item (preserving BST property) at or below node.
		// Returns node at/under which the item was inserted.

		if(p == null) {
			return new Node<U>(item);
		} else {
			// if item is less than or equal to data at node
			// insert below node’s left
			if(item.compareTo(p.item) <= 0) {
				p.left = add(p.left, item);
			} else {
				// item is greater than item at node
				// insert below node’s right

				p.right = add(p.right, item);
			}
		}
		return p;
	}

	/**
	 * Determine whether the tree contains an object with the same value as the
	 * argument.
	 *
	 * @param item reference to Comparable object whose value will be searched for.
	 * @return true if the value is found.
	 */
	public boolean contains(U item) {
		return contains(root,item);
	}

	/**
	 * Determine whether the tree contains an object with the same value as the
	 * argument.
	 * @param p the root path to searching for
	 * @param obj reference to Comparable object whose value will be searched for.
	 * @return true if the value is found.
	 */
	private boolean contains(Node<U> p, U item) {
		if(p == null) {
			return false;
		} else if(p.item.compareTo(item) > 0) {
			return contains(p.left,item);
		} else if(p.item.compareTo(item) < 0) {
			return contains(p.right,item);
		} else {
			return true;
		}
	}

	/**
	 * Method to find an item in the tree.
	 * @param u the item to be find from the tree.
	 */
	public U find(U u) {
		if(isEmpty()) return null;

		// starting from root
		Node<U> p = root;
		int compareResult;
		while((compareResult = p.item.compareTo(u)) != 0) {
			if (compareResult > 0) {
				if (p.left != null)
					p = p.left;
				else
					return null;
			} else {
				if (p.right != null)
					p = p.right;
				else
					return null;
			}
		}
		return p.item;
	}
	/**
	 * Method to remove an item
	 * from the tree.
	 * @param e the item to be removed from the tree
	 */
	public void remove(E e) {
		root = remove(root, e);
		numItem--;
	}

	/**
	 * Method to recursively remove an item
	 * from a subtree.
	 */
	private Node<U> remove(Node<U> p, U e) {
		if(p == null) throw new NullPointerException(e.toString());
		if(e.compareTo(p.item) < 0)
			p.left = remove(p.left, e);
		else if(e.compareTo(p.item) > 0)
			p.right = remove(p.right, e);
		else if (numItem > 1) {
			numItem--;
			return p;
		}
		else if(p.left != null && p.right != null ) // Two children
		{
			p.item = findMin(p.right).item;
			p.right = removeMin(p.right);
		} else
			p = (p.left != null) ? p.left : p.right;

		return p;
	}

	/**
	 * Method to recursively remove a minimum  item
	 *  from a subtree.
	 *  @param p the node to be search for
	 */
	private Node<U> removeMin(Node<U> p) {
		if(p == null ) throw new NullPointerException();
		else if(p.left != null ) {
			p.left = removeMin(p.left);
			return p;
		} else
			return p.right;
	}

	/**
	 * Method to recursively find the smallest item in a subtree.
	 * @param p the node to be search for 
	 */
	private Node<U> findMin(Node<U> p) {
		if(p != null )
			while(p.left != null )
				p = p.left;

		return p;
	}

	/**
	 * Method to sorting the items in the list accordingly
	 * 
	 * @return the sorted list of the list
	 */
	private ArrayList<U> toListInOrder() {
		ArrayList<U> items = new ArrayList<>();
		inOrder(root, items);
		return items;
	}
	
	/**
	 * Method to sorting the items in the list accordingly
	 * @param p the root path of the node
	 * @param items the item in the list.
	 */
	private void inOrder(Node<U> p, ArrayList<U> items) {
		if(p != null) {
			inOrder(p.left, items);
			items.add(p.item);
			inOrder(p.right, items);
		}
	}

	/**
	 * Method to presort the items in the list prior to accordingly
	 * 
	 * @return the presorting list of the list
	 */
	private ArrayList<U> toListPreOrder() { 
		ArrayList<U> items = new ArrayList<>();
		preOrder(root, items);
		return items;
	}

	/**
	 * Method to pre-sorting the items in the list prior to accordingly
	 * @param p the root path of the node
	 * @param items the item in the list.
	 */
	private void preOrder(Node<U> p, ArrayList<U> items) { 
		items.add(p.item);

		if(p.left != null) {
			preOrder(p.left, items);
		}

		if(p.right != null) { 
			preOrder(p.right, items);
		}
	}

	/**
	 * Method to post sorting the items in the list prior to accordingly
	 * 
	 * @return the post sorted list of the list
	 */
	private ArrayList<U> toListPostOrder() {
		ArrayList<U> items = new ArrayList<>();
		postOrder(root, items);
		return items;
	}

	/**
	 * Method to post sorting the items in the list prior to accordingly
	 * @param p the root path of the node
	 * @param items the item in the list.
	 */
	private void postOrder(Node<U> p, ArrayList<U> items) {
		if(p.left != null) {
			postOrder(p.left, items);
		}

		if(p.right != null) {
			postOrder(p.right, items);
		}

		items.add(p.item);
	}

	/**
	 * Method to display the items in the list in ordered
	 * to the console.
	 */
	public void displayInOrder() {
		String str = new String();

		str = "The List in ordered: " + toListInOrder().toString();

		System.out.println(str);
	}

	/**
	 * Method to display the items in the list in preordered
	 * to the console.
	 */
	public void displayPreOrder() {
		String str = new String();

		str = "The List in preordered: \n" + toListPreOrder().toString() + "\n";

		System.out.println("\n" + str + "\n");
	}

	/**
	 * Method to display the items in the list in post ordered
	 * to the console.
	 */
	public void displayPostOrder() {
		String str = new String();

		str = "The List in postordered: \n" + toListPostOrder().toString() + "\n";

		System.out.println("\n\n" + str);
	}

	/**
	 * Method to return String representation of this Binary Tree.
	 * @return the string representation of this tree.
	 */
	public String toString () {
		String tmp=getString(root);
		if (tmp.length()>1)
			return "[" + tmp.substring(0, tmp.length()-1) + "]";
		else
			return "[" + tmp + "]";
	}

	/**
	 * Method to recursively get the remaining string representation
	 * of this tree.
	 * @param p
	 * 	 * @return the string representation of this tree.
	 */
	private String getString(Node<U> p) {
		if (p == null)
			return "";
		String str = "";
		str = str + getString(p.left);
		str = str + p.item + ",\n";
		str = str + getString(p.right);
		return str;
	}

}
