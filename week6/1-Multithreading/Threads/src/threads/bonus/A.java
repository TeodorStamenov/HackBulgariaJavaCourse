package threads.bonus;

public class A extends Thread {
	BlockQueueCustom<Integer> a = new BlockQueueCustom<Integer>(0);
	
	public A (BlockQueueCustom<Integer> a) {
		this.a = a;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			a.offer(i);
			System.out.println("Offer: " + i + " Size:" + a.size());
			try {
				A.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
