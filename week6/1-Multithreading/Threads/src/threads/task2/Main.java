package threads.task2;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		BlockQueueCustom<Integer> blockQueue = new BlockQueueCustom<Integer>();
		
		A t1 = new A(blockQueue);
		B t2 = new B(blockQueue);
		
		t1.start();
		t2.start();
	}

}
