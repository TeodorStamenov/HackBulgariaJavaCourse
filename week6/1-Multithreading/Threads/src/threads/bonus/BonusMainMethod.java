package threads.bonus;

public class BonusMainMethod {

	public static void main(String[] args) {
		BlockQueueCustom<Integer> b = new BlockQueueCustom<Integer>(5);
		
		A t1 = new A(b);
		B t2 = new B(b);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
}
