import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class LRUCacheMisses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lruCacheMisses(6, new ArrayList<Integer>() {{add(1); add(2); add(1); add(3); add(1); add(2);}}, 2);
	}
	private static int lruCacheMisses(int num, List<Integer> pages, int maxCacheSize) {
		lruCache<Integer, Integer> cache = new lruCache<>(maxCacheSize);
		int misses = 0;
		for (Integer page : pages) {
			if (!cache.containsKey(page)) {
				misses++;
			}
			cache.put(page, 0);
		}
		System.out.print(misses);
		return misses;
	}
	static class lruCache<K, V> extends LinkedHashMap<K, V> {
		private final int maxSize;
		public lruCache(int maxSize) {
			super(16, 0.75f, true);
			this.maxSize = maxSize;
		}
		@Override
		protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
			// when size() > maxSize, remove eldest entry
			return size() > maxSize;
		}
	}
}
