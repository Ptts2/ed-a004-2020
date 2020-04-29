package ule.edi.recursiveList;

import java.util.NoSuchElementException;


public class UnorderedLinkedListImpl<T> extends AbstractLinkedListImpl<T> implements UnorderedListADT<T> {

	public UnorderedLinkedListImpl() {
		//	Vac√≠a
	}
	
	public UnorderedLinkedListImpl(T ... v) {
		//	AÒadir en el mismo orden que en 'v'
		for (T Vi : v) {
			addLast(Vi);
		}
	}
	
	@Override
	public void addFirst(T element) {
		
		if(element == null)
			throw new NullPointerException();
		
		Node<T> aux = new Node<T>(element);
		aux.next = this.front;
		this.front = aux;
	}
	
	
	@Override
	public void addLast(T element) {
		
		if(element == null)
			throw new NullPointerException();
		
		if(this.isEmpty())
			this.addFirst(element);
		else
			addLastRec(front, element);
	
	}
	private void addLastRec(Node<T> nodo, T element) {
		
		if(nodo.next == null) 
			nodo.next = new Node<T>(element);
		else 
			this.addLastRec(nodo.next, element);
		
		
	}

	@Override
	public void addBefore(T element, T target) {
		
		if(element == null || target == null)
			throw new NullPointerException();
		
		//Miro si el elemento es el primero
		if(this.front.elem.equals(target)) {
			this.addFirst(element);
		}else if(!addBeforeRec(this.front, element, target)){
			throw new NoSuchElementException();
		}
	}
	
	private boolean addBeforeRec(Node<T> nodo, T element, T target) {
		
		if(nodo.next == null)
			return false;
		
		if(nodo.next.elem.equals(target)) {
			
			Node<T> aux = new Node<T>(element);
			aux.next = nodo.next;
			nodo.next = aux;
			
			return true;
		}
		
		return addBeforeRec(nodo.next, element, target);
	}

		
}
