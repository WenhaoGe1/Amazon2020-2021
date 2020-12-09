import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CutOffRank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		levelUp(4, 6, new Integer[] {2,2,2,3,4,5});
//		levelUp(2, 4, new Integer[] {0,4,4,4});
		levelUp(4, 5, new Integer[] {2,2,3,4,5});
		levelUp(3, 4, new Integer[] {100, 50, 50, 25});
	}
	
	/*
	 // may be TLE
	
	private static int levelUp(int cutOffRank, int num, Integer[] scores) {
		if (scores.length == 1) {
			return 1;
		}
		int pos = 1;
		int curRank = 1;
		Arrays.sort(scores, Collections.reverseOrder());
		for (int i = 0; i < num; i++) {
			// when scores[i] == scores[i - 1], curRank don't increment, only position++
			// else update curRank = current position;
			if (i == 0 || scores[i] != scores[i - 1]) {
				curRank = pos;
				if (curRank > cutOffRank || scores[i] == 0) {
					System.out.println(pos - 1);
					return pos - 1;
				}
			}
			pos++;
		}
		System.out.println(num);
		return num;

	}
	 */
	
	// discussion, accepted
	private static int levelUp(int cutOffRank, int num, Integer[] scores) {
		int[] freq = new int[100 + 1];
		for (int s: scores) {
			freq[s]++;
		}
		int res = 0;
		int curRank = 1;
		for (int i = 100; i >= 0 && curRank <= cutOffRank; i--) {
			if (freq[i] != 0) {
				res += freq[i];
				curRank += freq[i];
			}
		}
		System.out.println(num);
		return res;
	}
}

