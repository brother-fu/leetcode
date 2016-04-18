// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> it;
    private Integer cached;
    
	public PeekingIterator(Iterator<Integer> iterator) {
         it = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (cached == null){
            cached = it.next();
        }
        return cached;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (cached != null){
	        Integer ans = new Integer((int)cached);
	        cached = null;
	        return ans;
	    } else {
	        return it.next();
	    }
	    
	}

	@Override
	public boolean hasNext() {
	    return (cached != null || it.hasNext());
	}
}