import java.util.*;
class LinkedList<Integer> implements Iterable<Integer> {
	//primul si ultimul nod din lista
	Node<Integer> first, last;
	private static class Node<Integer>{
		 Integer data;
		 Node<Integer> next;
		 private Node(Integer data, Node<Integer> next) {
			this.data=data;
			this.next=next;
		}
		
		 private Node(Integer data) {
			this.data=data;
			this.next=null;
		}
		 
		private void setNext(Node<Integer> next) { 
			this.next=next;
		}
		
		private Integer getData() {
			return this.data;
		}	
		
		private Node getNext() {
			return next;
		}
	}
	
	class ListIterator<Integer> implements Iterator<Integer> {
		Node<Integer> current;
		public ListIterator(LinkedList<Integer> list) {
			current=(Node)list.getNode();
		}
		public boolean hasNext() {
			return current!=null;
		}
		public Integer next() {
			Integer data=current.getData();
			current=current.getNext();
			return data;
		}
		public void remove() {
			throw new UnsupportedOperationException(); 
		}
	}
	
	//Insereaza un nod la inceputul listei
	public void addFirst(Integer data) {
		Node node = new Node(data, first);
		if(first==null)
			first=node;
		else {
			node.setNext(this.first);
			this.first=first;
		}
	}
	
	//Insereaza un nod la sfarsitul listei
	public void add(Integer data) {
		Node node = new Node(data, null);
		if(first==null)
			first=last=node;
		else {
			last.setNext(node);
			last=node;
		}
		
	}
	//Returneaza primul nod din lista
	public Integer getNode() {
		return (Integer)this.first;
	}
	//Returneaza un obiect de tip ListIterator
	public Iterator<Integer> iterator() {
		return new ListIterator<Integer>(this);
	}
	
	
}
