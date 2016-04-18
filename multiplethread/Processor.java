package wait;

import java.util.Scanner;

public class Processor {
    //using wait() and notify to implement producer and consumer
	public void produce() throws InterruptedException {
		//Thread.sleep(1000);  //只wait，不notify会发生什么事？
		synchronized(this) {
			System.out.println("Producer thread running");
			wait(); //只能在synchronized里面中call， 重新接下去必须先获得这个的锁；
			System.out.println("Resumed");
		}
	}
	public void consume() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		Thread.sleep(2000);
		synchronized(this) {
			System.out.println("Waiting for the return key");
			sc.nextLine();
			System.out.println("Return key presssed");			
			notify();
			System.out.println("doing its own job first"); //即便notify了依然先跑完自己，在释放object monitor锁
		}
		
	}
}
