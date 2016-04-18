class RateLimiter {
    int qps;
    Queue<FLOAT> queue; 
    public RateLimiter(int qps) {
    	this.qps = qps;
    	queue = new LinkedList();
    }
    pubilc boolean allowAccess(FLOAT now) {
    	if (queue.size() < qps) {
    		queue.offer (now);
    		return true;
    	} else {
    		if (now - queue.peek() < 1) {
    			return false;
    		} else {
                queue.poll();
                queue.offer(now);
                return true;
    		}

    	}
    }
}