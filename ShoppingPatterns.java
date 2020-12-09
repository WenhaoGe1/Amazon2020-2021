// sol from discussion who did OA


import java.util.*;

public class ShoppingPatterns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<Integer> a = new ArrayList<>();
//		a.add(1);
//		a.add(2);
//		a.add(2);
//		a.add(3);
//		a.add(4);
//		a.add(5);
//		List<Integer> b = new ArrayList<>();
//		b.add(2);
//		b.add(4);
//		b.add(5);
//		b.add(5);
//		b.add(5);
//		b.add(6);
//		getMinScore(6, a, b);
		
		List<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(1);
		a.add(2);
		a.add(2);
		a.add(4);
		a.add(3);
		List<Integer> b = new ArrayList<>();
		b.add(2);
		b.add(3);
		b.add(3);
		b.add(4);
		b.add(4);
		b.add(5);
		getMinScore(6, a, b);
	}
	private static int getMinScore(int numOfProducts, List<Integer> products_from, List<Integer> products_to) {
		if (numOfProducts < 1 || products_from == null || products_to == null || products_from.size() != products_to.size()) {
			return -1;
		}
		Map<Integer, Set<Integer>> edges = new HashMap<>();
		for (int i = 1; i <= numOfProducts; i++) {
			edges.put(i, new HashSet<Integer>());
		}
		for (int i = 0; i < numOfProducts; i++) {
			edges.get(products_from.get(i)).add(products_to.get(i));
			edges.get(products_to.get(i)).add(products_from.get(i));
		}
		int gloMin = Integer.MAX_VALUE;
		for (int i = 1; i <= numOfProducts; i++) {
			for (int j = i + 1; j <= numOfProducts; j++) {
				for (int k = j + 1; k <= numOfProducts; k++) {
					if (edges.get(i).contains(j) && edges.get(j).contains(k) && edges.get(k).contains(i)) {
						int count = edges.get(i).size() + edges.get(j).size() + edges.get(k).size() - 6;
						gloMin = Math.min(gloMin, count);
					}
				}
			}
		}
		System.out.println(gloMin);
		return gloMin == Integer.MAX_VALUE ? -1 : gloMin;
	}
}
