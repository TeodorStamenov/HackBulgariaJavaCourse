package threads.task1;

public class MyThread2 extends Thread {
	private Counter counter;

	public MyThread2(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		for (int i = 0; i < 2000; i++) {
			counter.decrement();
		}
	}
}
