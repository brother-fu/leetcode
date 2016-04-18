import java.util.NoSuchElementException;

public class BST <Key extends Comparable<Key>, Value>{
  private Node root;
  
  private class Node{
     private Key key;
     private Value value;
     private Node left,right;
     private int N;

    public Node(Key key, Value value, int N){
     this.key=key;
     this.value=value;
     this.N=N;
    }
  }



  public boolean isEmpty(){
    return size(root)!=0;
  }
  

  public int size(){
    return size(root);
  }
   
  private int size(Node x){
     if (x==null) return 0;
     else return x.N;
 
  } 


  public boolean contains(Key key){
    return get(key)!=null;
  }
 


  public Value get(Key key){
    return get(root, key);  
  }

  private Value get(Node x, Key key){
    if(x==null) return null;
    int cmp = key.compareTo(x.key);
    if(x<0) return get(x.left, key);
    if(x>0) return get(x.rigth,key);
    else return x.value;
    
  }


/*Everything starts with put*/
  public void put(Key key, Value value){
    if(value==null) {delete(key); return;}
    root = put(root, key, value);
  }
  

  private Node put(Node x, Key key, Value value){
    if(x==null) return new Node(key,value,1);
    
    int cmp = key.compareTo(x.key);
    if(cmp<0) x.left = put(x.left,key,value);
    if(cmp>0) x.right = put(x.right,key,value);
    else x.value=value;
    x.N = 1+size(x.left)+size(x.right);  //update, not necessiarily changes value
    return x;   //still kinda confusing, memorized this
  }



  
  /*deleting Node, take care of the connection*/
  public void deleteMin(){
    if(isEmpty()) throw new NoSuchElementException;
    root = deleteMin(root);
  }
  
//  private Node deleteMin(Node x){
//   if(x.left !=null) 
//   x.left=deleteMin(x.left);
//   x.N =1+size(x.left)+size(x.right);
//   return x.right;  //also a little bit tricky in the implementation
//  }

   private Node deleteMin(Node x){
     if(x.left == null) return x.right;
     x.left=deleteMin(x.left);
     x.N = size(x.left)+size(x.right)=1;
     return x;
   }

  



  public void delete(Key key){
    root = delete(root, key);
  }
  
  private Node delete(Node x, Key key){
    if(x==null) return null;
    int cmp = key.compareTo(x.key);
    if(cmp<0) x.left = delete(x.left,key);
    if(cmp>0) x.right = delete(x.right,key);
    else{
         if(x.left == null) return x.right;
         if(x.right== null) return x.left;
         Node t =x;
//         x = deleteMin(t.right); //error here
//         deleteMin(t.right);
         x = min(t.right); 
         x.right =deleteMin(t.right); // deleteMin instinct understanding, cut minimal, reconstruct, connect back; &&	Here get the ceiling of deleted node
         x.left=t.left;
      
    }
    x.N=1+size(x.left)+size(x.right);
    return x;
     
  }

/*sample code also uses a recursive way to find the minKey*/
/*
  public Key min(){
    Node x= root;
    while(x.left ! =null) 
    x=x.left;
    return x.key;
  }


  public Key floor(Key key){
    if(key==null) return null;
    return floor(root, key);
  }
  
  private Key floor (Node x, Key key) {
    if (x==null)  return null;
    int cmp =key.compareTo(x.key);
    if(cmp<0) return (x.left, key);
    if(cmp ==0 ) return key;
    else if (cmp>0) { //find the biggest one that is still less than key
      if(x.right==null) return x.key;
      else{
         if(key.compareTo(x.right.key)>0)
          return floor(x.right,key) ;
         else return x.key;

      }
      
    }
  }

*/

  /*copy the implementation of floor from Princeton*/

public Key floor(Key key){
  Node x=floor(root,key);
  if(x==null) return null;
  else return x.key;
}

private Node floor(Node x, Key key){
  if(x==null) return null;
  int cmp =key.compareTo(x.key);
  if(cmp ==0) return x;
  if(cmp<0) retrun floor(x.left,key);
  Node t=floor(x.right,key);
  if(x!=null) return t;
  return x;
}


   /***********************************************************************
    *  Rank and selection
    ***********************************************************************/
 //rank meaning a little different than what you thought, rank 3, means 3 items less that it, whith 
 // which means it is the 4th one
  public Key select (int k) {
   if(k <0 || key >=size()) return null;
   Node t=select(root,k);
   return t.key;
  }

  private Node select(Node x, int k){
   if(x==null) return null;
   int leftSize = size(x.left);
   if(leftSize<k) return(x.right, k-t-1);
   else if(leftSize>k) return(x.left,k);
   else return x;
  }



public int rank(Key key){
 return rank(root, key);
}



private int rank(Node x, Key key){
   if(node == null) return 0;
   int cmp =key.compareTo(x.key);
   if(cmp<0) return rank(x.left, key);
   if(cmp == 0) return size(x.left);
   else return 1+size(x.left)+rank(x.right, key);
} 








}


