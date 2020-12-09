// sol from discussion

public class ThrottlingGateway {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		droppedRequests(new int[] {1,1,1,1,2});
		droppedRequests(new int[] {1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,11,11,11,11});
		droppedRequests(new int[] {1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7});
	}
	private static int droppedRequests(int[] requestTime) {
		int n  = requestTime.length;
		int res = 0;
		
		for (int i = 0; i < n; i++) {
			if (i > 2 && (requestTime[i] == requestTime[i - 3])) {
				res++;
			} else if (i > 19 && (requestTime[i] - requestTime[i - 20] < 10)) {
				res++;
			} else if (i > 59 && (requestTime[i] - requestTime[i - 60] < 60)) {
				res++;
			}
			
		}
		System.out.println(res);
		return res;
	}
	
}
