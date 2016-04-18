import java.util.Iterator;
import java.util.NoSuchElementException;


public class Queue<Item> implements Iterable <Item>{ // error, Interface always begins with C, not c;
   private static class Node<Item>{
     private Item item;
     private  Node<Item> next;
   }




  private Node first;
  private Node last;
  private int N;
 
  public Queue(){
      this.first =null;
      this.last= null;
      this.N=0;
      
  }  


 public void enqueue(Item item){
//
//     if(last == null){
//          last = new Node<item>();
//          last.item =item;
//          last.next =null;
//          first =last;
//     }
//     else {
//         Node oldlast = last;
//         last.item = item; //Serious Error, oldlast and last pointing to the same location, last must have a new memory allocation
//         last.next=null;
//         oldlast.next = last;
         
//     }
     Node oldlast =last;
     last = new Node<Item>();
     last.item = item;
     last.next =null;
     if (isEmpty()) first = last;
     else oldlast.next =last;   
     this.N++;

  }





  public Item dequeue(){
      if(isEmpty()) throw new NoSuchElementException();

      Item item = first.item;
      first =first.next;
      N--;
      if(isEmpty()) last =first;
      return item;  
   
//      Item toDequeue = first.item; 
//      if (first == last) {
//         first =last =null;
//         return toDequeue;
//      }
   
//      else {
//        first = first.next;
//        return toDequeue;    
//      }
      
//      this.N--;



  }


 public boolean isEmpty(){
   return first ==null;  
 }




public ListIterator<Item> iterator(){
  return ListIterator<Item>(first);
 
}



 private class ListIterator<Item> implements Iterator<Item>{
    private Node current;
  public ListIterator((Node<Item> first)){  // only method has parameter, OK! , class does not have this
    current = first; 
  } 
  public boolean hasNext(){
   return current != null;

  }
  
 
  public Item next(){
  if (!hasNext())  throw new NoSuchElementException(); 
    Item item = current.item;
    current = current.next();
    return item;
  }
 

  

 }






}
