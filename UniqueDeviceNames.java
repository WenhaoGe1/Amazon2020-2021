import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UniqueDeviceNames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		deviceName(7, new LinkedList<String>() {{
			add("h");
			add("h");
			add("d");
			add("h");
			add("d");
			add("tv");
			add("tv");
		}});
	}
	public static List<String> deviceName(int num, List<String> devicenames) {
		Map<String, Integer> count = new HashMap<>();
		List<String> res = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (String s : devicenames) {
			if (!count.containsKey(s)) {
				count.put(s, 0);
				res.add(s);
			} else {
				sb.setLength(0);
				int cur = count.get(s) + 1;
				count.put(s, cur);
				sb.append(s);
				sb.append(cur);
				res.add(sb.toString());
			}
		}
		System.out.println(res);
		return res;
	}
}
