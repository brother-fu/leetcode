public class SeqSearch<Key extends Comparable<Key>, Value> {
   private int N;
   private Node first;

   private class Node{
      private Key key;
      private Value value;
      private Node next;

      public Node(Key key, Value value, Node next){
       this.key =key;
       this.value=value;
       this.next = next;
      }

   }


  public SeqSearch(){
  // Do not need to do anything, cause  first is instianted in the put method
  }


  public void put(Key key, Value value){
       if(value == null) {delete(key); return;}
       for(Node current =first; current!= null; current = current.next )
           if (key.equals(current.key)) {
               current.value =value;
               return;
           }  
          //Node first = new Node(key, value. first); //Wrong, first is not constrained in this scope
          first = new Node(key, value. first);
          N++;
  }
  

 public Value get(Key key){  
      for(Node x = first; x!= null; x= x.next;)
         if(key.equals(x.key)) return x.value;
       return null;
  }


 public boolean contains(Key key){// great thought, get() requires more than contains, so contains use get() in its implemetation
    return this.get(key) !=null;
  }


/*The implementation of delete is really a wow, learn from it*/
 public void delete(Key key){
    if (!contains(key)) return;
    first = delete (first, key);   //use Node as a delete unit!  what a wonderful way of programming
 }
 
 private Node delete (Node x, Key key){ 
   if (key.equals(x.key)) {N--; return x.next; }
//   else {
//      x =x.next;
//      x= delete(x, key);
//   } 
   else
     x.next = Node(x.next, key);
   return x; // still the orginal thing!
 }

 public Iterable<Key> keys(){
   queue<Key> keys = new queue<Key>();
   for(Node x =first; x!=null; x=x.next) 
      keys.enqueue(key);
   return keys;
 }




}
