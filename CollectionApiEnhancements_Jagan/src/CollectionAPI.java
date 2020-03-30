import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class CollectionAPI {

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "A");
		map.put(4, "D");
		map.put(3, "C");
		map.put(2, "B");

		// 'comparingByKey, comparingByValue' - To avoid using comparator for sorting..
		List<Map.Entry<Integer, String>> sortByKey = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toList());
		sortByKey.forEach(System.out::println);

		// 'getOrDefault' - To avoid unnecessary if..else while using containsKey..
		System.out.println(map.getOrDefault(3, "??"));

		// 'replaceAll' - To replace the map values on one go..
		map.replaceAll((k, v) -> v.toLowerCase());
		map.forEach((k, v) -> System.out.println(k + "=" + v));

		// 'putIfAbsent' - To avoid replacing an existing entry of an map..
		map.putIfAbsent(5, "e");
		System.out.println(map.get(5));

		// 'compute' - To replace the value of a key by the value..
		map.compute(5, (k, v) -> v.toUpperCase());
		System.out.println(map.get(5));

		List<String> list = Arrays.asList("ABC", "XYZ", "PQR");

		// 'spliterator & forEachRemaining'..
		Spliterator<String> spliterator = list.spliterator();
		spliterator.forEachRemaining(System.out::println);

		// 'removeIf' - To remove elements which matches a condition..
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 2, 4, 6, 8, 9));
		numbers.removeIf(number -> number % 3 == 0);
		System.out.println(numbers);
	}

}
