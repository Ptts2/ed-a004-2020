package ule.edi.recursiveList;

import ule.edi.exceptions.EmptyCollectionException;

public class OrderedLinkedListImpl<T extends Comparable<? super T>> extends
		AbstractLinkedListImpl<T> implements OrderedListADT<T> {

	public OrderedLinkedListImpl() {
		// Vacia
	}

	public OrderedLinkedListImpl(T... v) {
		// Añade todos los elementos del array 'v'
		for (T Vi : v) {
			add(Vi);
		}
	}

	
	@Override
	public void add(T element) {
		
		if(element == null)
			throw new NullPointerException();
	
		if(this.front == null) {
			this.front = new Node<T>(element);
			
		}else if (this.front.elem.compareTo(element) >=0) {
			Node<T> aux = new Node<T>(element);
			aux.next=front;
			front = aux;
		}else {
			addRec(front, element);
		}
		
	}
	
	private void addRec(Node<T> nodo, T element) {
		
		if(nodo.next == null) {
			nodo.next= new Node<T>(element);
		
		}else if(nodo.next.elem.compareTo(element) >=0) {
			Node<T> anyadir = new Node<T>(element);
			anyadir.next = nodo.next;
			nodo.next = anyadir;
		}else {
			addRec(nodo.next, element);
		}
		
	}
	
	

	@Override
	public int removeDuplicates() throws EmptyCollectionException{
		// Redefinir para listas ordenadas (los duplicados estaran consecutivos)
		
		if(isEmpty())
			throw new EmptyCollectionException("vacia");
		
		
		return removeDuplicatesRec(front, 0);
	}
	
	private int removeDuplicatesRec(Node<T> nodo, int duplicados) {
		
		if(nodo.next == null)
			return duplicados;
		
		if(nodo.next.elem.equals(nodo.elem)) {
			nodo.next = nodo.next.next;
			return removeDuplicatesRec(nodo, duplicados+1);
		}
		
		return removeDuplicatesRec(nodo.next, duplicados);
	}
	
	



	

		

}
