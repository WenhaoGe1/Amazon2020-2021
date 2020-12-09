// passed!

import java.util.Comparator;
import java.util.PriorityQueue;

public class LabelingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		labeling("bbcc", 2);
//		labeling("baccc", 2);

//		labeling("aabaccc", 2);
//		labeling("abbbbc", 2);
		//labeling("aaabbbcccddd", 2);
		//labeling("abbbbbbbc", 2);
//		labeling("abbbbbbc", 2);
//		labeling("daabaabc", 2);
//		labeling("daabaabc", 2);
		labeling("aaaaabbbbbcccccddddd", 2);
//		labeling("azzxxx", 2);
		
	}

	
	private static String labeling(String orignalLabel, int charLimit) {
		int n = orignalLabel.length();
		int[] letters = new int[26];
		for (int i = 0; i < n; i++) {
			letters[orignalLabel.charAt(i) - 'a']++;
		}
		StringBuilder res = new StringBuilder();
		
		for (int i = letters.length - 1; i >= 0; i--) {
			int count = 0;
			while (letters[i] > 0) {
				res.append((char)(i + 'a'));
				letters[i]--;
				count++;
				if (letters[i] > 0 && count == charLimit) {
					Character next = findNext(letters, i);
					if (next == null) {
						System.out.println(res);
						return res.toString();
					}
					res.append(next);
					count = 0;
				}
				
			}
			
		}
		System.out.println(res);
		
		return res.toString();
	}
	private static Character findNext(int[] letters, int index) {
		for (int i = index - 1; i >= 0; i--) {
			if (letters[i] > 0) {
				letters[i]--;
				return (char) (i + 'a');
			}
		}
		return null;
	}
	
	
//	private static String getNewLabel(String originalLabel, int maxIdenticalChars) {
//		String newLabel = "";
//		char prevChar = '\0';
//		PriorityQueue<Character> pQ = new PriorityQueue<Character>(new Comparator<Character>() {
//			@Override
//			public int compare(Character c1, Character c2) {
//				return c2 - c1;
//			}
//		});
//
//		for (int i = 0; i < originalLabel.length(); i++) {
//			pQ.add(originalLabel.charAt(i));
//		}
//
//		int k = 1;
//		for (int i = 0; i < originalLabel.length(); i++) {
//			char checkChar = pQ.poll();
//			if (i != 0) {
//
//				if (prevChar == checkChar) {
//					if ((++k) <= maxIdenticalChars) {
//						newLabel += checkChar;
//						prevChar = checkChar;
//					} else {
//						if (!pQ.isEmpty() && (prevChar != pQ.peek())) {
//							prevChar = pQ.poll();
//							newLabel += prevChar;
//							pQ.add(checkChar);
//						}
//					}
//				} else {
//					k = 1;
//					newLabel += checkChar;
//					prevChar = checkChar;
//				}
//			} else {
//				newLabel += checkChar;
//				prevChar = checkChar;
//			}
//		}
////		System.out.println(newLabel);
//		return newLabel;
//	}
	
	
}
