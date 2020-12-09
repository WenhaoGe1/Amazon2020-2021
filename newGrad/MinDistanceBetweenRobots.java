package newGrad;

import java.util.List;

public class MinDistanceBetweenRobots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findDistance(3, new int[]{0, 1, 2}, new int[] {0, 1, 4});
		
	}
	private static int findDistance(int numRobots, int[] positionX, int[] positionY) {
		int gloMin = Integer.MAX_VALUE;
		for (int i = 0; i < numRobots; i++) {
			for (int j = i + 1; j < numRobots; j++) {
				int curDistance = (positionX[i] - positionX[j]) *  (positionX[i] - positionX[j]) + 
						(positionY[i] - positionY[j]) * (positionY[i] - positionY[j]);
				if (curDistance == 0) {
					continue;
				}
				gloMin = Math.min(gloMin, curDistance);
			}
		}
		System.out.print(gloMin);
		return gloMin;
	}

}
