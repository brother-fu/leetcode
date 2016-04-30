public class DeadLock {
  public static void main(String[] args) throws InterruptedException {
	Object o1 = new Object();
	Object o2 = new Object();
	Thread t1 = new Thread(new Runnable(){
	    public void run() {
	    	while(true) {
	    		synchronized(o1) {
	    			System.out.println("t1 out");
	    			synchronized(o2) {
	    				System.out.println("t1 in");
	    			}
	    		}
	    	}
	    }
	});
	
	Thread t2 = new Thread(new Runnable(){
	    public void run() {
	    	while(true) {
	    		synchronized(o1) {
	    			System.out.println("t2 out");
	    			synchronized(o2) {
	    				System.out.println("t2 in");
	    			}
	    		}
	    	}
	    }
	});
	
	t1.start();
	t2.start();
	t1.join();
	t2.join();
  }

}
