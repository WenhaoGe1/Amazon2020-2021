import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Java: HashMap + one pass
//O(n) time, O(n) space. 
public class twoSum {

	public static void main(String[] args) {
		uniquePairs(new int[]{1,1,2,45,46,46}, 47);
		uniquePairs(new int[]{1,1}, 2);
		uniquePairs(new int[]{1,5,1,5}, 6);
		uniquePairs(new int[]{1,5,3,3,3}, 6);
	}
	private static int uniquePairs(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Map<Integer, Integer> visited = new HashMap<>();
		int res = 0;
		for (int i : nums) {
			if (!visited.containsKey(i)) {
				visited.put(i, 1);
				visited.put(target - i, 1);
			} else {
				if (visited.get(i) == 1 && visited.containsKey(target - i) && visited.get(target - i) == 1) {
					visited.put(i, 0);
					visited.put(target - i, 0);
					System.out.print(i + "+" + (target - i) + "|");
					res += 1;
				}
			}
		}
		System.out.println("	totalCount: " + res);
		return res;
	}

}
