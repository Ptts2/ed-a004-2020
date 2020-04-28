package ule.edi.recursiveList;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ule.edi.exceptions.EmptyCollectionException;

public class AbstractLinkedListImpl<T> implements ListADT<T> {

	// Estructura de datos, lista simplemente enlazada
	//
	// Este es el primer nodo de la lista
	protected Node<T> front = null;

	// Clase para cada nodo en la lista
	protected  class Node<T> {

		T elem;

		Node<T> next;

		Node(T element) {
			this.elem = element;
			this.next = null;
		}

		@Override
		public String toString() {
			return "(" + elem + ")";
		}

	}
	
	private class IteratorImpl implements Iterator<T> {
     // TODO Implementar el iterador normal
		
		@Override
		public boolean hasNext() {

		return false;
		}

		@Override
		public T next() {

			

			return null;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}


	// Ejemplos de ejercicios de recursividad
	//



	@Override
	public String toString() {

		//	Construye y devuelve con el formato adecuado "(A B C )" 

		return toStringRec(front);
	}
	
	private String toStringRec(Node<T> nodo) {
		
		if(nodo == null)
			return "";
		
		return nodo.elem.toString()+" "+toStringRec(nodo.next);
	}
	
	@Override
	public boolean contains(T target) {
		
		if(target == null)
			throw new NullPointerException();
		
		return containsRec(front, target);
	}
	
	private boolean containsRec(Node<T> nodo, T target) {
		
		if(nodo == null)
			return false;
		if(nodo.elem.equals(target))
			return true;
		
		return containsRec(nodo.next, target);
	}
	
	@Override
	public int count(T element) {
		
		
	  return countRec(front, element);
		
	}
	
	private int countRec(Node<T> nodo, T element) {
		
		int num = 0;
		
		if(nodo == null)
			return 0;
		if(nodo.elem.equals(element))
			num = 1;
		
		return countRec(nodo.next, element)+num;
	}

	@Override
	public T getLast() throws EmptyCollectionException {
		
		if(this.front == null)
			throw new EmptyCollectionException("vacia");
		
		return getLastRec(front);
	}
	
	private T getLastRec(Node<T> nodo) {
		
		if(nodo.next == null)
			return nodo.elem;
		else
			return getLastRec(nodo.next);
	}


	
	@Override
	public boolean isOrdered() {
     
		return isOrdererRec(this.front);
		
	}
	
	
	private boolean isOrdererRec(Node<T> nodo) {
		
		if(nodo==null || nodo.next == null)
			return true;
		
		
		if(((Comparable<T>)nodo.elem).compareTo(nodo.next.elem) >=0) 
			return false;
		
		return isOrdererRec(nodo.next);
	}
	
	@Override
	public T remove(T element) throws EmptyCollectionException {
    // TODO RECURSIVO
		return null;
		
	}


	@Override
	public T removeLast(T element) throws EmptyCollectionException {
     // TODO RECURSIVO
		return null;
	}


	@Override
	public boolean isEmpty() {
		// TODO 
		return false;
	}

	@Override
	public int size() {
		// TODO RECURSIVO
		return 0;
	}

	@Override
	public T getFirst() throws EmptyCollectionException {
		// TODO RECURSIVO
		return null;
	}

	@Override
	public String toStringFromUntil(int from, int until) {
		// TODO RECURSIVO
		
		return null;
		
	}


	@Override
	public String toStringReverse() {
		// TODO RECURSIVE
		return null;
	}
	

	@Override
	public int removeDuplicates() {
		// TODO RECURSIVE
		// Implementar teniendo en cuenta que la lista está desordenada
		return 0;
	
	}

	
	@Override
	public Iterator<T> iterator() {
		// TODO 
		return null;
	}


}
