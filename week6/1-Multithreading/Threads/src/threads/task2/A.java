package threads.task2;

public class A extends Thread {
	BlockQueueCustom<Integer> a = new BlockQueueCustom<Integer>();
	
	public A (BlockQueueCustom<Integer> a) {
		this.a = a;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			a.offer(i);
			System.out.println("Offer: " + i);
			try {
				A.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
