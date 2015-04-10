package collections_and_generics.task8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MedianQuick implements Statistics, Iterable<Integer> {

	private Map<Integer, Integer> numbers = new HashMap<Integer, Integer>();
	private List<Integer> list = new ArrayList<Integer>();
	private Integer cnt;
	private int sum;
	private int smallest = Integer.MAX_VALUE;
	private int largest = Integer.MIN_VALUE;
	private int mode = 1;
	private int index;
	private int modeNum;
	
	
	public void add(int n){
		cnt = 1;
		sum = sum + n;
		list.add(n);
		
		if (!numbers.containsKey(n)) {
			numbers.put(n, cnt);
		} else {
			cnt =  numbers.get(n);
			numbers.put(n, ++cnt);
		}
		
		if (mode < cnt) {
			mode = cnt;
			modeNum = n;
		}
		
		if (smallest > n) {
			smallest = n;
		} else if (largest < n) {
			largest = n;
		}
	}
	
	@Override
	public float getMean() {
		if (numbers.isEmpty())
			throw new IndexOutOfBoundsException("List is empty");
		return sum / list.size();
	}

	@Override
	public float getMedian() {
		int sum;
		if (numbers.size() % 2 != 0) {
			
			Arrays.sort(list.toArray());
			index = (numbers.size() + 1 ) / 2;
			
			return (float)list.get(index);
			
		} else if (numbers.size() % 2 == 0){
			
			Arrays.sort(list.toArray());
			index = (numbers.size() / 2);
			
			sum = (int) list.get(index);
			sum =+ (int) list.get(index - 1);
			
			return (float) sum / 2;
		} else 
			throw new IndexOutOfBoundsException("List is empty!");
	}

	@Override
	public int getMode() {
		if (mode == 1)
			return 0;
		else if (mode > 1)
			return modeNum;
		else 
			throw new IndexOutOfBoundsException("List is empty!");
	}

	@Override
	public int getRange() {
		if(numbers.isEmpty())
			throw new IndexOutOfBoundsException("List is empty!");
		return largest - smallest;
	}

	@Override
	public Iterator<Integer> iterator() {
		return list.iterator();
	}
	
}
