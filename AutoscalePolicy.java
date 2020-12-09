
public class AutoscalePolicy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		finalInstances(2, new int[]{25,23,1,2,3,4,5,6,7,8,9,10,76,80});
		finalInstances(1, new int[]{3,5,10,80});
	}
	private static int finalInstances(Integer instances, int[] averageUtil) {
		for (int i = 0; i < averageUtil.length; i++) {
			if (averageUtil[i] < 25 && instances > 1) {
				instances /= 2;
				i += 10;
			} else if (averageUtil[i] > 60 && instances * 2 <= 2e8) {
				instances *= 2;
				i+= 10;
			}
		}
		System.out.println(instances);
		return instances;
	}

}
