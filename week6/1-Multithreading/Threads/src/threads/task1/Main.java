package threads.task1;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Counter cnt = new Counter();
		MyThread t = new MyThread(cnt);
		MyThread2 t2 = new MyThread2(cnt);
		t.start();
		t.join();
		t2.start();
		t2.join();
		System.out.println(cnt.getCounter());
	}
}
