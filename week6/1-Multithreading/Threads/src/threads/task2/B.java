package threads.task2;

public class B extends Thread {
	BlockQueueCustom<Integer> b = new BlockQueueCustom<Integer>();
	
	public B (BlockQueueCustom<Integer> b) {
		this.b = b;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Poll: " + b.poll());
			try {
				B.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
