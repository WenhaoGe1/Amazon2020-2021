// tested 37/37

import java.util.*;

public class FillTheTruck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// fillTheTruck(3, new int[] {1,2,3}, 3, new int[] {3, 2, 1}, 3);
		fillTheTruck(5, new int[] {2,2,3,1,1,}, 5, new int[] {2,3,5,1,5}, 20);
	}
	public static int fillTheTruck(int num, int[] boxes, int unitSize, int[] unitsPerBox, long truckSize) {
        
		List<Integer> packages = new ArrayList<>();
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[i]; j++) {
                packages.add(unitsPerBox[i]);
            }
        }
        Collections.sort(packages);
        Collections.reverse(packages);
        // System.out.println(packages);
        int res = 0;
        if (truckSize > packages.size()) {
        	for (Integer i : packages) {
        		res += i;
        	}
        } else {
        	for (long k = 0; k < truckSize; k++) {
                res += packages.get((int)k);
            }
        }
        
        // System.out.print(res);
        return res;
    }

}
