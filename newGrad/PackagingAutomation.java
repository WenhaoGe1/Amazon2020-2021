package newGrad;

public class PackagingAutomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findMax(4, new int[] {1,3,2,2});
		findMax(3, new int[] {1,1,1});
	}
	private static int findMax(int numGroups, int[] arr) {
		if (arr.length == 1) {
			return 1;
		}
		int[] count = new int[numGroups + 1];
		for (int i : arr) {
			count[Math.min(i, numGroups)]++;
		}
		int size = 0;
		for (int i = 1; i <= numGroups; i++) {
			while (count[i] > 0 && size < i) {
				size++;
				count[i]--;
			}
		}
		System.out.println(size);
		return size;
	}
}
