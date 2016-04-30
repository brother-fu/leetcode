import java.util.concurrent.Semaphore;

public class PrintEvenOdd {
	static int count = 1;
    public static void main(String[] args) throws InterruptedException{
    	Semaphore sm = new Semaphore(1);
    	Thread odd = new Thread(new Runnable(){
    		public void run() {
    			while (true) {
    				try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    				try {
						sm.acquire();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
    				if (count % 2 == 1) {
    				    System.out.println("t1 " + count);
    				    count++;
    				}
    				sm.release();
    			}
    		}
    	});
  
    	Thread even = new Thread(new Runnable(){
    		public void run() {
    			while (true) {
    				try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    				try {
						sm.acquire();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
    				if (count % 2 == 0) {
    				    System.out.println("t2  " + count);
    				    count++;
    				}
    				sm.release();
    			}
    		}
    	});
    	
    	odd.start();
    	even.start();
    	
    	odd.join();
    	even.join();
    	
    }
}
