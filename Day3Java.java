package automation_collections_practice;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Day3Java {
	
	public static List<Integer> findDuplicates(int[] arr) {
		
		if (arr == null || arr.length == 0) {
			
			System.out.println("Input array is empty or null");
			
            return Collections.emptyList();
            
		}
		
		List<Integer> result = new ArrayList<>();
		
		Map<Integer, Integer> map = new LinkedHashMap<>();
		
		for (int ref : arr) {
			
			map.put(ref, map.getOrDefault(ref, 0)+1);
		}
		
		System.out.print("Duplicates are: ");
		
		for (Map.Entry<Integer, Integer> k : map.entrySet()) {
			if (k.getValue() > 1) {
				result.add(k.getKey());
			}
		}
		return result;
	}

	public static void main(String[] args) {
		
		int[] arr1 = {1, 2, 3, 2, 4, 3, 5, 1};
		
		System.out.print(findDuplicates(arr1));
		
		

	}

}
