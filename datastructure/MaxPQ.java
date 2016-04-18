import java.util.Iterator;
import java.util.Comparator;
import java.util.NoSuchElemetException;


public class MaxPQ<Key implements Iterable<Key>{
private Key[] pq；
private int N;
private Comparator<Key> comparator;





public MaxPQ(){
	this(1);
}



public MaxPQ(int capacity){
   pq = (Key[]) new object [capacity+1];
}



public MaxPQ(Key[] keys){
    pq = (Key[]) new object [keys.length+1];
    for(int i=0; i<keys.length; i++){
    	pq[i+1] = keys[i];
    	N++; 
    }
     for(int k=N/2; k>=1; k--) {
     	sink(k);
     }

}


public MaxPQ(int copacity, Comparator<Key> comparator){
	this.comparator =comparator;
	pq = (Key[]) new object[capacity+1];
}



private void sink(int k){
	while(2*k<=N){
     int j=2*k
     if(j<N && less(j, j+1))
     	j=j+1;
     if(! less(k,j)) break;

     exch(k,j);
     k=j;
    }
}


private void swim(int k){
	while (k>1 && less(k/2, k))
		exch(k/2,k);
	k=k/2;
}


private boolean less(int i, int j){
	if(comparator == null) return pq[i].compareTo(pq[j]) <0;
	else 
		return comparator.compare(pq[i], pq[j])<0;
}



public Iterator<Key> iterator(){
	return new HeapIterator();           // 方程里面绝对没有<Key>, 只是在Class上面有 xxx错我结论
	                                    // 应该看class定义的时候有没有加上<>!!!, 地下HeapIterator 没有

}



private class HeapInterator implements Iterator<Key>{ //为什么heapiterator class不需要定义generics？
	private MaxPQ<Key> copy;

	public HeapIterator（）{
    if(comparator == null)  copy = new MaxPQ<Key> (size());
    else copy = new MaxPQ<Key>(size(), comparator)；
    	for(int i=1; i<size()+1; i++)
    		copy[i] =pq[i];
	}


	public boolean hasNext(){
		return !copy.isEmpty();
	}
    
    public Key next(){
    	if(!hasNext()) throw new NoSuchElemetException;
    	else 
    		return copy.delMax();
    }


}]
]\''':




}