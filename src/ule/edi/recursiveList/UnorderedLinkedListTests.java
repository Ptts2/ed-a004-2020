package ule.edi.recursiveList;



import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.*;

import ule.edi.exceptions.EmptyCollectionException;



public class UnorderedLinkedListTests {

	

	private UnorderedLinkedListImpl<String> lS;
	private UnorderedLinkedListImpl<String> lSABC;
	

	@Before
	public void setUp() {
		this.lS = new UnorderedLinkedListImpl<String>();
		
		
		this.lSABC = new UnorderedLinkedListImpl<String>("A", "B", "C");
	}
	
   @Test
   public void constructorElemens(){
	   lS=new UnorderedLinkedListImpl<String>("A", "B", "C", "D");
	   Assert.assertEquals("(A B C D )", lS.toString());
   }

// TESTS DE addFirst
   @Test
   public void addFirstTest(){
	   
	   lS.addFirst("D");
	   Assert.assertEquals("(D )", lS.toString());
	   lS.addFirst("C");
	   Assert.assertEquals("(C D )", lS.toString());
	   lS.addFirst("B");
	   Assert.assertEquals("(B C D )", lS.toString());
	   lS.addFirst("A");
	   Assert.assertEquals("(A B C D )", lS.toString());
   }
   
   // TESTS DE addBefore
   
   @Test
   public void addBeforeTest(){
	   
	   lS.addFirst("D");
	   Assert.assertEquals("(D )", lS.toString());
	   lS.addBefore("C", "D");
	   Assert.assertEquals("(C D )", lS.toString());
	   lS.addBefore("A","C");
	   Assert.assertEquals("(A C D )", lS.toString());
	   lS.addBefore("B", "C");
	   Assert.assertEquals("(A B C D )", lS.toString());
   }
   
   //Tests toStringReverse 
 
   @Test
   public void toStringReverse(){
	   lS=new UnorderedLinkedListImpl<String>("A", "B", "C", "D");
	   Assert.assertEquals("(A B C D )", lS.toString());
	   Assert.assertEquals("(D C B A )", lS.toStringReverse());
		  
   }
// Tests eliminar duplicados
	
   @Test
	public void testRemoveDuplicates() throws EmptyCollectionException{
	    UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>("A", "A", "B", "C", "B", "A", "C"); 
		Assert.assertEquals(lista.removeDuplicates(),4); 
		Assert.assertEquals(lista.toString(), "(A B C )");
		Assert.assertEquals(lSABC.removeDuplicates(),0); // 0 repetids
		Assert.assertEquals(lSABC.toString(), "(A B C )");	
	
	}
  
   
   
// AÑADIR MAS TESTS para el resto de casos especiales y para el resto de métodos
 // de las clases AbstractLinkedListImpl y UnorderedLinkedListImpl
	
 
   
   @Test
   public void testCointains() {
	   Assert.assertTrue(lSABC.contains("A"));
	   Assert.assertTrue(lSABC.contains("C"));
	   Assert.assertFalse(lSABC.contains("Y"));
   }
   
   @Test
   public void testCount() {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>("A", "A", "B", "C", "B", "A", "C"); 
	   
	   Assert.assertEquals(lista.count("A"),3);
	   Assert.assertEquals(lista.count("Y"),0);
	   
   }
   
   @Test
   public void testGetLast() throws EmptyCollectionException{
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>("A", "A", "B", "C", "B", "A", "C"); 
	   
	   Assert.assertEquals(lista.getLast(),"C");
	   
   }

   @Test
   public void testIsOrdered() {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>("A", "B", "A", "C", "B", "A", "C"); 
	   UnorderedLinkedListImpl<String> lista2=new UnorderedLinkedListImpl<String>("A", "A", "A", "C"); 
	   Assert.assertFalse(lista.isOrdered());
	   Assert.assertTrue(lista2.isOrdered());

   }
   
   @Test
   public void testRemove() throws EmptyCollectionException{
	   
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>("A", "B", "A", "C", "B", "A", "C"); 
	   Assert.assertEquals(lista.toString(),"(A B A C B A C )");
	   lista.remove("A");
	   Assert.assertEquals(lista.toString(),"(B A C B A C )");
	   lista.remove("C");
	   Assert.assertEquals(lista.toString(),"(B A B A C )");
   }
   
   @Test
   public void testRemoveLast() throws EmptyCollectionException{
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>("A", "B", "A", "C", "B", "A", "C"); 
	   Assert.assertEquals(lista.toString(),"(A B A C B A C )");
	   lista.removeLast("A");
	   Assert.assertEquals(lista.toString(),"(A B A C B C )");
	   lista.removeLast("C");
	   Assert.assertEquals(lista.toString(),"(A B A C B )");
	   UnorderedLinkedListImpl<String> lista2=new UnorderedLinkedListImpl<String>("A"); 
	   lista2.removeLast("A");
	   Assert.assertEquals(lista2.toString(), "()");
   }
   
   
   @Test
   public void testSize() {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>("A", "B", "A", "C", "B", "A", "C"); 
	   Assert.assertEquals(lista.size(),7);
   }
   
   @Test
   public void testGetFirst() throws EmptyCollectionException{
	   
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>("A", "B", "A", "C", "B", "A", "C"); 
	   Assert.assertEquals(lista.getFirst(),"A");
   }
   
   @Test
   public void testToStringFromUntil() {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>("A", "B", "A", "C", "B", "A", "C"); 
	   Assert.assertEquals(lista.toStringFromUntil(2,4),"(B A C )");
	   
	   Assert.assertEquals(lista.toStringFromUntil(100,102),"()");
	   Assert.assertEquals(lista.toStringFromUntil(6,300),"(A C )");
	   
	   
   }
   
   @Test
   public void testAddBefore() {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>("A", "B", "C", "E", "Y", "P", "Q"); 
	   Assert.assertEquals(lista.toString(), "(A B C E Y P Q )");
	   lista.addBefore("S", "P");
	   Assert.assertEquals(lista.toString(), "(A B C E Y S P Q )");
	   lista.addBefore("L", "A");
	   Assert.assertEquals(lista.toString(), "(L A B C E Y S P Q )");
   }
   
   @Test
   public void testIterator() {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>("A", "B", "C", "E", "Y", "P", "Q"); 

	   Iterator<String> iterador = lista.iterator();
	   
	   Assert.assertTrue(iterador.hasNext());
	   Assert.assertEquals(iterador.next(),"A");
   }
   
   //Test excepciones
   
   @Test(expected=NoSuchElementException.class)
   public void testException1Iterator() {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>(); 
	   Iterator<String> iterador = lista.iterator();
	   Assert.assertFalse(iterador.hasNext());
	   iterador.next();
   }
   
   @Test(expected=UnsupportedOperationException.class)
   public void testException2Iterator() {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>(); 
	   Iterator<String> iterador = lista.iterator();
	   iterador.remove();
   }
   
   @Test(expected=NullPointerException.class)
   public void testExceptionContains() {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>(); 
	   lista.contains(null);
   }
   
   @Test(expected=EmptyCollectionException.class)
   public void testExceptiongetLast() throws EmptyCollectionException {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>(); 
	   lista.getLast();
   }
   
   @Test(expected=NoSuchElementException.class)
   public void testRemoveException1() throws EmptyCollectionException {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>("A", "B");
	   lista.remove("C");
   }
   
   @Test(expected=NullPointerException.class)
   public void testRemoveException2() throws EmptyCollectionException {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>("A", "B");
	   lista.remove(null);
   }
   
   @Test(expected=EmptyCollectionException.class)
   public void testRemoveException3() throws EmptyCollectionException {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>();
	   lista.remove("C");
   }
   
   @Test(expected=NoSuchElementException.class)
   public void testRemoveLastException1() throws EmptyCollectionException {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>("A", "B");
	   lista.removeLast("C");
   }
   
   @Test(expected=NullPointerException.class)
   public void testRemoveLastException2() throws EmptyCollectionException {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>("A", "B");
	   lista.removeLast(null);
   }
   
   @Test(expected=EmptyCollectionException.class)
   public void testRemoveLastException3() throws EmptyCollectionException {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>();
	   lista.removeLast("C");
   }
   
   @Test(expected=EmptyCollectionException.class)
   public void testGetFirstException() throws EmptyCollectionException{
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>();
	   lista.getFirst();
   }
   
   @Test(expected=IllegalArgumentException.class)
   public void testToStringFromUntilException1() {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>();
	   lista.toStringFromUntil(0,1);
   }
   
   @Test(expected=IllegalArgumentException.class)
   public void testToStringFromUntilException2() {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>();
	   lista.toStringFromUntil(1,0);
   }
   
   @Test(expected=IllegalArgumentException.class)
   public void testToStringFromUntilException3() {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>();
	   lista.toStringFromUntil(-3,-1);
   }
   
   @Test(expected=EmptyCollectionException.class)
   public void testRemoveDuplicatesExceptio3() throws EmptyCollectionException{
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>();
	   lista.removeDuplicates();
   }
   
   @Test(expected= NullPointerException.class)
   public void testAddFirstException() {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>();
	   lista.addFirst(null);
   }
   
   @Test(expected= NullPointerException.class)
   public void testAddLastException() {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>();
	   lista.addLast(null);
   }
   
   @Test(expected= NullPointerException.class)
   public void testAddBeforeException1() {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>();
	   lista.addBefore(null, "A");
   }
   
   @Test(expected= NullPointerException.class)
   public void testAddBeforeException2() {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>();
	   lista.addBefore("A", null);
   }
   
   @Test(expected= NoSuchElementException.class)
   public void testAddBeforeException3() {
	   UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>("A", "B", "C", "E", "Y", "P", "Q"); 
	   lista.addBefore("S", "U");
   }
}
