package wait;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProduceConsumerBlockingQueue {
	private static BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(10); //不要忘记初始化blockingqueue的大小
    public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable(){
			public void run() {
				while(true) { //better approach是把这个循环放到consume(), produce里面去做
				    try {
					    produce(); // 只要底层实现有涉及到wait, notify, sleep等等的必须用try, catch block包括起来
				    } catch (InterruptedException e) {
					    // TODO Auto-generated catch block
					    e.printStackTrace();
				    }
				}
			}
		});
		Thread t2 = new Thread(new Runnable(){
			public void run() {
				while(true) {
				    try {
				    	Thread.sleep(100);
					    consume();
				    } catch (InterruptedException e) {
					    // TODO Auto-generated catch block
					    e.printStackTrace();
				    }
				}
			}
		});
	    t1.start();
	    t2.start();
	    
	    t1.join();
	    t2.join();
	}
    public static void produce() throws InterruptedException {
    	Random rd = new Random();
    	bq.put(rd.nextInt(100));
    }
    public static void consume() throws InterruptedException {
    	Random rd = new Random();
    	if (rd.nextInt(10) == 0) {
    		Integer item = bq.take();
    		System.out.println("item: " + item + " taken from queue");
    	}
    }
    
}
