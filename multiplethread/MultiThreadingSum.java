package wait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/*check this*/
public class MultiThreadingSum {
    private class Worker extends Thread {
    	int start, end, sum; //用class来存储状态；
    	public Worker (int start, int end) {
    		this.start = start;
    		this.end = end;
    		sum = 0;
    	}
    	public void run() {
    		for (int i = start; i < end; i++)
    			sum += array[i];
    		allDone.release(); //释放一个semaphore;
    	}
    	public long getSum() {
    		return sum;
    	}
    }
	
	private int[] array;
    private Semaphore allDone; // 用semaphore来确定是否所有的thread 已经完成工作；
    
    public MultiThreadingSum(int len) {
    	array = new int[len];
    	for (int i = 0; i < len; i++)
    		array[i] = i % 10;
    }
    public void runParallel() {
    	int numWorkers = 10;
    	allDone = new Semaphore(0); //怎么初始化semaphore;
        List<Worker> workers = new ArrayList<Worker>();
        int workload = array.length / numWorkers;
        for (int i = 0; i < numWorkers; i++) {
        	int start = i * workload;
        	int end = (i + 1) * workload;
        	if (i == numWorkers - 1)
        		end = array.length;
        	Worker worker = new Worker(start, end);
        	workers.add(worker);
        	worker.start();
        }
        try {
        	allDone.acquire(numWorkers); //get ending signal from all workers
        } catch (InterruptedException ignored) {
        	;
        }
        
        
        //gather sum;
        int sum = 0;
        for (Worker worker : workers) {
        	sum += worker.getSum();
        }
        System.out.println(sum);
    }
    
    
    public static void main(String[] args) {
		MultiThreadingSum mts = new MultiThreadingSum(1000);
		mts.runParallel();
	}
    
}
