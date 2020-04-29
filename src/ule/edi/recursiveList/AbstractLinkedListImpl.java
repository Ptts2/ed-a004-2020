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

		return "("+toStringRec(front)+")";
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
		
		if(this.isEmpty())
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
		
		if(element == null)
			throw new NullPointerException();
		if(this.isEmpty())
			throw new EmptyCollectionException("vacio");
		
		//Si el nodo es el 1
		if(front.elem.equals(element)) {
			T elemento = front.elem;
			front = null;
			return elemento;
		}
			
		T eliminado = removeRec(front, element);

		if(eliminado == null)
			throw new NoSuchElementException();
		
		return eliminado;
		
	}
	
	private T removeRec(Node<T> nodo, T element) {
		
		//Si es el ultimo
		if(nodo.next==null) 
			return null;
			
		//Si esta en el medio
		if(nodo.next.elem.equals(element)) {
			T elemento = nodo.next.elem;
			nodo.next = nodo.next.next;
			return elemento;
		}
		
		return removeRec(nodo.next, element);
	}


	@Override
	public T removeLast(T element) throws EmptyCollectionException {
		
		if(element == null) 
			throw new NullPointerException();
		if(this.isEmpty())
			throw new EmptyCollectionException("vacia");
		
		T elementoEliminado = null;
		//Si el ultimo elemento es el primero
		if(front.elem.equals(element))
			elementoEliminado = removeLastRec(front, front, element);
		
		elementoEliminado = removeLastRec(front, null, element);
		
		if(elementoEliminado == null)
			throw new NoSuchElementException();
		
		return elementoEliminado;
	}
	
	private T removeLastRec(Node<T> nodo, Node<T> anteriorAUltimaAparicion, T element ) {
		
		
		if(nodo == null && anteriorAUltimaAparicion == null)
			return null;
		
		if(nodo == null) {
			T elemento;
			
			//Si el elemento es el primero
			if(anteriorAUltimaAparicion == front) {
				elemento = anteriorAUltimaAparicion.elem;
				front = front.next;
			}else { //Si esta en el medio
				elemento = anteriorAUltimaAparicion.next.elem;
				anteriorAUltimaAparicion.next = anteriorAUltimaAparicion.next.next;
			}
			
			return elemento;
		}
		
		if(nodo.next.elem.equals(element))
			return removeLastRec(nodo.next, nodo, element);
		
		return removeLastRec(nodo.next, anteriorAUltimaAparicion, element);
	}


	@Override
	public boolean isEmpty() {
		return this.front==null;
	}

	@Override
	public int size() {
		return sizeRec(front);
	}
	
	private int sizeRec(Node<T> nodo) {
		
		if(nodo == null)
			return 0;
		
		return sizeRec(nodo.next)+1;
	}

	@Override
	public T getFirst() throws EmptyCollectionException {
		
		if(this.isEmpty())
			throw new EmptyCollectionException("vacio");
		
		return front.elem;
	}

	@Override
	public String toStringFromUntil(int from, int until) {
		
		if(from>size())
			return "()";
		
		if(until>size())
			until = size();
		
		return "("+toStringFromUntilRec(from, until, front, 1)+")";
		
	}
	private String toStringFromUntilRec(int from, int until, Node<T> nodo, int posicion) {
		
		if(nodo == null || posicion > until)
			return "";
		
		if(posicion < from)
			return toStringFromUntilRec(from, until, nodo.next, posicion++);
		
		return nodo.elem.toString()+" "+toStringFromUntilRec(from, until, nodo.next, posicion++);
	}

	@Override
	public String toStringReverse() {
		
		return "("+toStringReverseRec(front)+")";
	}
	
	private String toStringReverseRec(Node<T> nodo) {
		
		
		if(nodo==front)
			return toStringRec(nodo.next)+" "+nodo.elem.toString()+" ";
		if(nodo.next == null)
			return nodo.elem.toString();
		
		return toStringRec(nodo.next)+" "+nodo.elem.toString();
	}

	@Override
	public int removeDuplicates() throws EmptyCollectionException{
		// TODO RECURSIVE
		// Implementar teniendo en cuenta que la lista está desordenada
		
		if(isEmpty())
			throw new EmptyCollectionException("vacia");
		return 0;
	
	}

	
	@Override
	public Iterator<T> iterator() {
		// TODO 
		return null;
	}


}
