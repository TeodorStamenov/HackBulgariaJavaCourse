package threads.bonus;

public class B extends Thread {
	BlockQueueCustom<Integer> b = new BlockQueueCustom<Integer>(0);
	
	public B (BlockQueueCustom<Integer> b) {
		this.b = b;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Poll: " + b.poll() + " Size:" + b.size());
			try {
				B.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
