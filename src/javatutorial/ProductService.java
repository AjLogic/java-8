package javatutorial;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

class ProductService {

	private ProductService() {

	}

	public static BiFunction<Map<String, Long>, Map<String, Long>, Map<String, LinkedList<Long>>> mergeMap = (
			Map<String, Long> firstMap, Map<String, Long> secondMap) -> {

		Map<String, LinkedList<Long>> result = new HashMap<>();
		firstMap.forEach((firstkey, value) -> {
			result.computeIfAbsent(firstkey, (k) -> {

				return new LinkedList<Long>();
			}).add(value);
		});
		secondMap.forEach((secondMapkey, valuefMap) -> {
			result.computeIfAbsent(secondMapkey, (k) -> {

				return new LinkedList<Long>();
			}).add(valuefMap);
		});

		return result;
	};

	public static Function<Map<String, LinkedList<Long>>, Map<String, LinkedList<Long>>> filterMap = (objectOfMAp) -> {

		return objectOfMAp.entrySet().stream().filter((x) -> x.getKey().startsWith("A"))
				.collect(Collectors.toMap(map -> map.getKey(), value -> value.getValue()));

	};

	public static Function<Map<String, LinkedList<Long>>, Map<String, LinkedList<Long>>> applyDiscount = (
			objectOfMAp) -> {

		objectOfMAp.values().forEach(listfLong -> {

			LongStream.range(0, ((LinkedList<Long>) listfLong).size()).forEach(index -> {
				Integer position = (int) index;
				Double l = listfLong.get(position) - (10.0 / 100 * listfLong.get(position));
				listfLong.set(position, l.longValue());
			});
		});
		return objectOfMAp;
	};
}