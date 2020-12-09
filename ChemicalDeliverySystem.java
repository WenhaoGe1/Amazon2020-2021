import java.util.*;
public class ChemicalDeliverySystem {
	static class PairInt{
		int first;
		int second;
		PairInt(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numOfOrders = 4;
		int flaskTypes = 3;
		int totalMarks = 9;
		List<Integer> reqirements = new ArrayList<>();
		reqirements.add(4);
		reqirements.add(6);
		reqirements.add(6);
		reqirements.add(7);
		
		List<PairInt> marking = new ArrayList<>();
		marking.add(new PairInt(0, 3));
		marking.add(new PairInt(0, 5));
		marking.add(new PairInt(0, 7));
		marking.add(new PairInt(1, 6));
		marking.add(new PairInt(1, 8));
		marking.add(new PairInt(1, 9));
		marking.add(new PairInt(2, 3));
		marking.add(new PairInt(2, 5));
		marking.add(new PairInt(2, 6));
		
		int result = findFlask(numOfOrders, flaskTypes, totalMarks, reqirements, marking);
		System.out.print(result);
	}

	public static int findFlask(int numOfOrders, int flaskTypes, int totalMarks, List<Integer> reqirements, List<PairInt> marking) {
		List<Integer>[] groupedMarking = new List[flaskTypes];
		groupMarkingByTypes(groupedMarking, marking);

		int gloMin = Integer.MAX_VALUE;
		int resultFlask = -1;
		for (int type = 0; type < flaskTypes; type++) {
			int curMin = findWaste(reqirements, groupedMarking[type]);
			System.out.println("curMin: " + curMin);
			if (curMin < gloMin) {
				gloMin = curMin;
				resultFlask = type;
			}
		}
		System.out.println("gloMin: " + gloMin);
		return resultFlask;
	}

	private static void groupMarkingByTypes(List<Integer>[] groupedMarking, List<PairInt> marking) {
		Arrays.setAll(groupedMarking, (index) -> new ArrayList<>());
		for (PairInt mark : marking) {
			groupedMarking[mark.first].add(mark.second);
		}
	}

	private static int findWaste(List<Integer> reqirements, List<Integer> curMarking) {
		int curMin = 0;
		int i = 0; 
		for (Integer req : reqirements) {
			while (i < curMarking.size() && curMarking.get(i) < req) {
				i++;
			}
			if (i >= curMarking.size()) {
				return Integer.MAX_VALUE;
			}
			curMin += (curMarking.get(i) - req);
		}
		return curMin;
	}
}
