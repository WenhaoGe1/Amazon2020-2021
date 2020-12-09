// test web site has invalid input

import java.util.*;

public class NearestCity {
	public String[] findNearestCities(int numOfPoints,
            String[] points,
            int[] xCoordinates,
            int[] yCoordinates,
            int numOfQueries,
            String[] queries) {
		
		if (points == null || points.length == 0) {
		return null;
		}
		if (queries == null || queries.length == 0) {
		return null;
		}
	
		TreeMap<Integer, List<Integer>> xIntercept = new TreeMap<>();
		TreeMap<Integer, List<Integer>> yIntercept = new TreeMap<>();

		for (int x = 0; x < xCoordinates.length; x++) {
			if (!xIntercept.containsKey(xCoordinates[x])) {
				List<Integer> temp = new ArrayList<>();
				temp.add(x);
				xIntercept.put(xCoordinates[x], temp);
			} else {
				List<Integer> temp = xIntercept.get(xCoordinates[x]);
				temp.add(x);
				xIntercept.put(xCoordinates[x], temp);
			}
		}
		for (int y = 0; y < yCoordinates.length; y++) {
			if (!yIntercept.containsKey(yCoordinates[y])) {
				List<Integer> temp = new ArrayList<>();
				temp.add(y);
				yIntercept.put(yCoordinates[y], temp);
			} else {
				List<Integer> temp = yIntercept.get(yCoordinates[y]);
				temp.add(y);
				yIntercept.put(yCoordinates[y], temp);
		}
		}
		// System.out.print(xIntercept);
		// System.out.print(yIntercept);
		Map<String, Integer> dic = new HashMap<>();
		for (int i = 0; i < points.length; i++) {
			dic.put(points[i], i);
		}
		
		String[] res = new String[numOfQueries];
		for (int q = 0; q < queries.length; q++) {
		
		// for (int i = 0; i < points.length; i++) {
		//     if (points[i].equals(queries[q])) {
		//         pointIndex = i;
		//     }
		// }
			String matchedPoint = null;
			// Integer MatchedIndex = -1; 
			int pointIndex = dic.get(queries[q]);
			
			int closestDistance = Integer.MAX_VALUE;
			if (xIntercept.containsKey(xCoordinates[pointIndex])) {
				List<Integer> yC = xIntercept.get(xCoordinates[pointIndex]);
			
				int curY = yCoordinates[pointIndex];
				for (Integer y : yC) {
					if (pointIndex == y) {
						continue;
					}
					if (Math.abs(curY - yCoordinates[y]) < closestDistance) {
						matchedPoint = points[y];
					}
				}
			}
			if (yIntercept.containsKey(yCoordinates[pointIndex])) {
				List<Integer> xC = yIntercept.get(yCoordinates[pointIndex]);
				int curX = xCoordinates[pointIndex];
				for (Integer x : xC) {
					if (pointIndex == x) {
						continue;
					}
					if (Math.abs(curX - xCoordinates[x]) < closestDistance) {
						matchedPoint = points[x];
					}
				}
			}
			res[q] = matchedPoint;
		}
		
		
		return res;
		}
}
