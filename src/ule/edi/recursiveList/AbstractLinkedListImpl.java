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
		// TODO RECURSIVO
		//	Construye y devuelve con el formato adecuado "(A B C )" 
		
		return null;
	}
	
	
	@Override
	public boolean contains(T target) {
		// TODO RECURSIVO
		
		
		return false;
	}

	
  @Override
	public int count(T element) {
	// TODO RECURSIVO
	  return 0;
		
	}


	@Override
	public T getLast() throws EmptyCollectionException {
		// TODO RECURSIVO
		
		return null;
	}


	
	@Override
	public boolean isOrdered() {
     // TODO RECURSIVO
		return false;
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
