// not finished
public class FiveStarReviews {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		fiveStarReviews(new int[][]{{4, 4}, {1, 2}, {3, 6}}, 77);
	}
	private static int fiveStarReviews(int[][] productRatings, int ratingsThreshold) {
		int n = productRatings.length;
		double gloMax = 0;
		double curReview = findCurReview(productRatings, -1) / n * 100;
//		System.out.println(curReview);
		if (curReview >= ratingsThreshold) {
			return (int)gloMax;
		}
		int biggestChange = findBiggestChange(productRatings);
//		System.out.println(biggestChange);
		double rest = findCurReview(productRatings, biggestChange);
		curReview = (rest + (double)productRatings[biggestChange][0] / (double)productRatings[biggestChange][1]) / n;
		while (curReview < ratingsThreshold) {
			gloMax++;
			
			biggestChange = findBiggestChange(productRatings);
			rest = findCurReview(productRatings, biggestChange);
			System.out.println(biggestChange);
			curReview = (rest + (double)(productRatings[biggestChange][0] + gloMax) / (double)(productRatings[biggestChange][1] + gloMax)) / n;
			curReview *= 100;
			System.out.println(curReview);
		}
		System.out.println(gloMax);
		return (int)gloMax;
	}
	private static int findBiggestChange(int[][] ratings) {
		double max = 0;
		int maxIndex = 0;
		for (int i = 0; i < ratings.length; i++) {
			if (ratings[i][0] == ratings[i][1]) {
				continue;
			}
			double cur = (double)ratings[i][0] + (double)ratings[i][1];
			double addOne = (double)(ratings[i][0] + 1.0) + (double)(ratings[i][1] + 1);
			double diff = addOne - cur;
			if (diff > max) {
				max = diff;
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	private static double findCurReview(int[][] ratings, int index) {
		
		double sum = 0;
		for (int i = 0; i < ratings.length; i++) {
			if (i != index) {
				sum += ((double)ratings[i][0] / (double)ratings[i][1]);
			}
		}
		return sum;
	}
}
