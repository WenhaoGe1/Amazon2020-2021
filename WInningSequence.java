import java.util.LinkedList;
import java.util.List;

public class WInningSequence {

	public static void main(String[] args) {		
		List<Integer> list1 = findSequence(5, 10, 3);	// [9, 10, 9, 8, 7]
		List<Integer> list2 = findSequence(5, 10, 8);	// [8, 9, 10, 9, 8]
		List<Integer> list3 = findSequence(5, 10, 9);	// [-1]
		List<Integer> list4 = findSequence(4, 6, 3);	// [5, 6, 5, 4]
		List<Integer> list5 = findSequence(10, 30,20);	// [29, 30, 29, 28, 27, 26, 25, 24, 23, 22]
		List<Integer> list6 = findSequence(3, 8, 7);	// [7, 8, 7]
		List<Integer> list7 = findSequence(10, 10, 3);	// [8, 9, 10, 9, 8, 7, 6, 5, 4, 3]

	}
	private static List<Integer> findSequence(int num, int upperEnd, int lowerEnd) {
		List<Integer> res = new LinkedList<>();
		if ((upperEnd - lowerEnd + 1) * 2 - 1 < num) {
			res.add(-1);
			System.out.println(res);
			return res;
		}
		
		// max length of possible sequence from upperEnd to lowerEnd
		int lowerLength = upperEnd - lowerEnd + 1;
	
		// fulfill upper part  
		if (lowerLength >= num) {		// set upperEnd as second digit
			res.add(0, upperEnd - 1);	
		} else {
			for (int i = upperEnd - 1; i >= upperEnd - (num - lowerLength); i--) {
				res.add(0, i);
			}
		}
		
		int size = res.size();
		// fulfill lower part
		for (int i = upperEnd; i > upperEnd - (num - size); i--) {
			res.add(i);
		}
		System.out.println(res);
		return res;
	}
}
