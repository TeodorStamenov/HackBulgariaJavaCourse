package threads.task1;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
	private AtomicInteger counter = new AtomicInteger();
	
	public void increment() {
		counter.incrementAndGet();
	}
	
	public void decrement() {
		counter.decrementAndGet();
	}
	
	public int getCounter() {
		return counter.get();
	}
}
