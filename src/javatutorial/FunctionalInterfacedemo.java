package javatutorial;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FunctionalInterfacedemo {

	public static void main(String[] args) {
		
		Map<String,Long> map1 =new HashMap<String,Long>();
		Map<String,Long> map2 =new HashMap<String,Long>();
		
		map1.put("LG", 3000L);
		map2.put("Nokia", 3500L);
		map1.put("Apple", 3700L);
		map2.put("Moto", 1000L);
	Map<String, LinkedList<Long>> result = ProductService.mergeMap.andThen(ProductService.filterMap.compose(ProductService.applyDiscount))
		.apply(map1, map2);
	System.out.println(result);

	}

}
