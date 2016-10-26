package methodreferences;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Test4Map {

	public static void main(String[] args) {

		Map<String, String> favorites = new HashMap<>();
		favorites.put("Jenny", "Bus Tour");
		favorites.put("Tom", null);

		favorites.putIfAbsent("Jenny", "Tram"); // doesnt replace value of Jenny
		favorites.putIfAbsent("Sam", "Tram"); // sam not prsent, so populated
		favorites.putIfAbsent("Tom", "Tram"); // tom has null value, so
												// populated
		System.out.println(favorites); // {Tom=Tram, Jenny=Bus Tour, Sam=Tram}

		// V merge(K key, V value, BiFunction<V, V, V> biFunction)
		Map<String, String> favorites2 = new HashMap<>();
		favorites2.put("Jenny", "Bus Tour");
		favorites2.put("Tom", "Tram");

		// merger picks the highest of two values
		BiFunction<String, String, String> mergeMapper = (strValue1, strValue2) -> 
			strValue1.length() > strValue2.length() ? strValue1 : strValue2;
		String jenny = favorites2.merge("Jenny", "Skyride", mergeMapper);
		String tom = favorites2.merge("Tom", "Skyride", mergeMapper);
		System.out.println(favorites2); // {Tom=Skyride, Jenny=Bus Tour}
		System.out.println(jenny); // Bus Tour
		System.out.println(tom); // Skyride
		// if value is null or if key is not present, null pointer will not happen in merge
		
		
		
		// computeIfPresent computeIfAbsent
		// V computeIfPresent(Key k, BiFunction<K,V,V> biFunction)
		Map<String, Integer> counts = new HashMap<>();
		counts.put("Jenny", 1);
		BiFunction<String, Integer, Integer> mapper = (k, v) -> v + 1;
		Integer jenny2 = counts.computeIfPresent("Jenny", mapper);
		Integer sam = counts.computeIfPresent("Sam", mapper);
		System.out.println(counts); // {Jenny=2}
		System.out.println(jenny2); // 2
		System.out.println(sam); // null
		
		// V computeIfAbsent(Key k, Function<K,V> function)
		Map<String, Integer> counts2 = new HashMap<>();
		counts2.put("Jenny", 15);
		counts2.put("Tom", null);
		Function<String, Integer> mapper2 = (k) -> 1;
		Integer jenny3 = counts2.computeIfAbsent("Jenny", mapper2); // 15
		Integer sam3 = counts2.computeIfAbsent("Sam", mapper2); // 1
		Integer tom3 = counts2.computeIfAbsent("Tom", mapper2); // 1
		System.out.println(counts2); // {Tom=1, Jenny=15, Sam=1}
	}

}
