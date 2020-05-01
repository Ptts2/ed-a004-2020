package ule.edi.exceptions;


public class TypeIsNotComparableException extends RuntimeException {


	private static final long serialVersionUID = 4468275233875850541L;

	public TypeIsNotComparableException(String mensaje) {
		super(mensaje);
	}
}
